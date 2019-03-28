package com.zen.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.HttpTask;
import com.zen.domain.TcpTask;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/26 23:36
 **/
public class ChainClient {

    private final static TransformHttpTask httpHandler = new TransformHttpTask();
    private final static TransformIcmpTask icmpHandler = new TransformIcmpTask();
    private final static TransformTcpTask tcpHandler = new TransformTcpTask();

    static {
        httpHandler.setNextTransformTask(icmpHandler);
        icmpHandler.setNextTransformTask(tcpHandler);
    }

    public static void main(String[] args) {
        HttpTask httpTask = new HttpTask(12, 30, "HTTP",
                "rule1", "http://2.2.2.2", "post", "postbody");

        String httpTaskJson = JSON.toJSONString(httpTask);
        JSONObject jsonObject = JSON.parseObject(httpTaskJson);
        System.out.println(JSON.toJSONString(getTaskByProtocol(jsonObject.getString("protocol"), jsonObject)));

        TcpTask tcpTask = new TcpTask(11, 30, "TCP",
                "rule2", "1.1.1.1", 80);
        String tcpTaskJson = JSON.toJSONString(tcpTask);
        JSONObject tcpJson = JSON.parseObject(tcpTaskJson);
        System.out.println(JSON.toJSONString(getTaskByProtocol(tcpJson.getString("protocol"), tcpJson)));

    }

    public static Object getTaskByProtocol(String protocol, JSONObject jsonObject) {
//        return httpHandler.transform(protocol, jsonObject);
        return httpHandler.execute(protocol, jsonObject);
    }
}
