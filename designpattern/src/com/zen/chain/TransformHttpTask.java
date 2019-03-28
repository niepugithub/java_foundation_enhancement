package com.zen.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.HttpTask;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/27 20:49
 **/
public class TransformHttpTask extends AbstractTransformTask<HttpTask> {
    @Override
    protected String getLevel() {
        return "HTTP";
    }

    @Override
    public HttpTask doBySon(JSONObject jsonObject) {
        return JSON.toJavaObject(jsonObject, HttpTask.class);
    }
}
