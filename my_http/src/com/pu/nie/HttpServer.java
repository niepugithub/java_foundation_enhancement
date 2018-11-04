package com.pu.nie;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/11/4 14:03
 **/

public class HttpServer {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocketChannel，监听8080端口
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8080));
        // 设置为非阻塞模式
        ssc.configureBlocking(false);
        // 为ssc注册选择器
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 创建处理器
        while(true){
            // 等待请求，每次等待阻塞3s，超过3s后线程继续向下运行，如果传入0或者不传参将一直阻塞
            if(selector.select(3000)==0){
                continue;
            }
            // 获取待处理的SelectionKey
            Iterator<SelectionKey> keyIterator=selector.selectedKeys().iterator();

            while(keyIterator.hasNext()){
                SelectionKey key=keyIterator.next();
                // 启动线程处理SelectionKey
                new Thread(new HttpHandler(key)).start();
                // 处理完毕，从待处理的SelectionKey迭代器中移除当前所使用的key
                keyIterator.remove();
            }
        }
    }


    private static class HttpHandler implements Runnable{
        private int bufferSize=1024;
        private String localCharset="UTF-8";
        private SelectionKey key;

        public HttpHandler(SelectionKey key){
            this.key=key;
        }

        public void handlerAccept() throws IOException {
            SocketChannel clientChannel=((ServerSocketChannel)key.channel()).accept();
            clientChannel.configureBlocking(false);
            clientChannel.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handleRead() throws IOException {
            // 获取channel
            SocketChannel sc = (SocketChannel) key.channel();
            // 获取buffer并重置
            ByteBuffer byteBuffer=(ByteBuffer)key.attachment();
            byteBuffer.clear();
            // 没有读到内容则关闭
            if(sc.read(byteBuffer)==-1){
                sc.close();
            }else {
                // 接收请求数据
                byteBuffer.flip();
                String receivedString = Charset.forName(localCharset).newDecoder().decode(byteBuffer).toString();
                // 控制台打印请求报文头
                String[] requestMessage=receivedString.split("\r\n");
                for(String s:requestMessage){
                    System.out.println(s);
                    // 遇到空行说明报文头已经打完了
                    if(s.isEmpty()){
                        break;
                    }
                }
                // 控制台打印首行信息
                String[] firstLine=requestMessage[0].split(" ");
                System.out.println();
                System.out.println("Method:\t"+firstLine[0]);
                System.out.println("url:\t"+firstLine[1]);
                System.out.println("HTTP Version:\t"+firstLine[2]);
                System.out.println();

                // 返回客户端
                StringBuilder sendString = new StringBuilder();
                // \n是换行,英文是New line。\r是回车,英文是Carriage return
                sendString.append("HTTP/1.1 200 OK\r\n");//响应报文首行，200表示成功
                sendString.append("Content-Type:text/html;charset="+localCharset+"\r\n");
                sendString.append("\r\n");// 报文结束后加一个空行

                sendString.append("<html><head><title>显示报文</title></head><body>");
                sendString.append("接收到请求报文是:<br/>");
                for(String s:requestMessage){
                    sendString.append(s+"<br/>");
                }
                sendString.append("</body></html>");

                byteBuffer=ByteBuffer.wrap(sendString.toString().getBytes(localCharset));
                sc.write(byteBuffer);
                sc.close();
            }
        }

        @Override
        public void run() {
            try{
                // 接收到连接请求
                if(key.isAcceptable()){
                    handlerAccept();
                }
                // 读数据
                if(key.isReadable()){
                    handleRead();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
