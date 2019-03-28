package com.zen.domain;

import com.zen.domain.Task;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/26 23:31
 **/
public class HttpTask extends Task {
    private String url;
    private String method;
    private String body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpTask(int timeout, int interval, String protocol, String ruleName, String url, String method, String body) {
        super(timeout, interval, protocol, ruleName);
        this.url = url;
        this.method = method;
        this.body = body;
    }

    @Override
    public String toString() {
        return "HttpTask{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
