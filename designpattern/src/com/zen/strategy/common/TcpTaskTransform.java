package com.zen.strategy.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.TcpTask;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/28 23:00
 **/
public class TcpTaskTransform implements Transform<TcpTask> {
    @Override
    public TcpTask exec(JSONObject jsonObject) {
        return JSON.toJavaObject(jsonObject, TcpTask.class);
    }
}
