package com.zen.strategy.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.IcmpTask;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/28 23:01
 **/
public class IcmpTaskTransform implements Transform<IcmpTask> {

    @Override
    public IcmpTask exec(JSONObject jsonObject) {
        return JSON.toJavaObject(jsonObject, IcmpTask.class);
    }
}
