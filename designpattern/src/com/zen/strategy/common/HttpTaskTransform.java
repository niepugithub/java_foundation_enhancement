package com.zen.strategy.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.HttpTask;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/28 22:57
 **/
public class HttpTaskTransform implements Transform<HttpTask> {
    @Override
    public HttpTask exec(JSONObject jsonObject) {
        return JSON.toJavaObject(jsonObject, HttpTask.class);
    }
}
