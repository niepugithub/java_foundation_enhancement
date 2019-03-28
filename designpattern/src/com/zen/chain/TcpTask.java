package com.zen.chain;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/26 23:34
 **/
public class TcpTask extends Task {
    private String hostIp;
    private int port;

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public TcpTask(int timeout, int interval, String protocol, String ruleName, String hostIp, int port) {
        super(timeout, interval, protocol, ruleName);
        this.hostIp = hostIp;
        this.port = port;
    }

    @Override
    public String toString() {
        return "TcpTask{" +
                "hostIp='" + hostIp + '\'' +
                ", port=" + port +
                '}';
    }
}
