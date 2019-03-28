package com.zen.domain;

import com.zen.domain.Task;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/26 23:33
 **/
public class IcmpTask extends Task {


    private String hostIp;

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public IcmpTask(int timeout, int interval, String protocol, String ruleName, String hostIp) {
        super(timeout, interval, protocol, ruleName);
        this.hostIp = hostIp;
    }

    @Override
    public String toString() {
        return "IcmpTask{" +
                "hostIp='" + hostIp + '\'' +
                '}';
    }
}
