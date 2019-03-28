package com.zen.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.HttpTask;
import com.zen.domain.Task;
import com.zen.domain.TcpTask;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/28 22:33
 **/
public class Main {
    public static void main(String[] args) {
        HttpTask httpTask = new HttpTask(12, 30, "HTTP",
                "rule1", "http://2.2.2.2", "post", "postbody");

        String httpTaskJson = JSON.toJSONString(httpTask);
        JSONObject jsonObject = JSON.parseObject(httpTaskJson);

        Class<? extends Task> http = ProtocolKeyedTaskMap.get(jsonObject.getString("protocol"));
        System.out.println(JSON.toJSONString(JSON.toJavaObject(jsonObject, http)));

        TcpTask tcpTask = new TcpTask(11, 30, "HTTP",
                "rule2", "1.1.1.1", 80);
        String tcpTaskJson = JSON.toJSONString(tcpTask);
        JSONObject tcpJson = JSON.parseObject(tcpTaskJson);
        Class<? extends Task> tcp = ProtocolKeyedTaskMap.get(tcpJson.getString("protocol"));
        System.out.println(JSON.toJSONString(JSON.toJavaObject(tcpJson, tcp)));

    }
}
