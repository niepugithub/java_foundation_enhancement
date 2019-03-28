package com.zen.strategy.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/28 23:01
 **/
public class TransformContext {

    private Transform transform;

    public TransformContext(Transform transform) {
        this.transform = transform;
    }

    public Object execute(JSONObject jsonObject) {
        return transform.exec(jsonObject);
    }
}
