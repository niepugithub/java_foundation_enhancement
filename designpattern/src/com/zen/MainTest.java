package com.zen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.HttpTask;
import com.zen.domain.IcmpTask;
import com.zen.domain.Task;
import com.zen.domain.TcpTask;
import com.zen.strategy.common.HttpTaskTransform;
import com.zen.strategy.common.IcmpTaskTransform;
import com.zen.strategy.common.TcpTaskTransform;
import com.zen.strategy.common.TransformContext;
import org.junit.Test;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/28 23:04
 **/
public class MainTest {

    // 这里写父类的引用是可以，不会隐藏掉子类的属性
    Task httpTask = new HttpTask(12, 30, "HTTP",
            "rule1", "http://2.2.2.2", "post", "postbody");

    Task icmpTask = new IcmpTask(11, 30, "ICMP",
            "rule2", "1.1.1.1");

    Task tcpTask = new TcpTask(11, 30, "TCP",
            "rule2", "1.1.1.1", 80);

    @Test
    public void testStrategy() {
        String httpTaskJson = JSON.toJSONString(icmpTask);
        JSONObject jsonObject = JSON.parseObject(httpTaskJson);
        if ("HTTP".equals(jsonObject.getString("protocol"))) {
            TransformContext context = new TransformContext(new HttpTaskTransform());
            System.out.println(JSON.toJSONString(context.execute(jsonObject)));
        } else if ("ICMP".equals(jsonObject.getString("protocol"))) {
            TransformContext context = new TransformContext(new IcmpTaskTransform());
            System.out.println(JSON.toJSONString(context.execute(jsonObject)));
        } else if ("TCP".equals(jsonObject.getString("protocol"))) {
            TransformContext context = new TransformContext(new TcpTaskTransform());
            System.out.println(JSON.toJSONString(context.execute(jsonObject)));
        }
    }
}
