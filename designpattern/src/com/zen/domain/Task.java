package com.zen.domain;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/26 23:32
 **/
public class Task {
    private int timeout;
    private int interval;
    private String protocol;
    private String ruleName;

    public Task(int timeout, int interval, String protocol, String ruleName) {
        this.timeout = timeout;
        this.interval = interval;
        this.protocol = protocol;
        this.ruleName = ruleName;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}
