package com.zen.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.IcmpTask;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/27 20:56
 **/
public class TransformIcmpTask extends AbstractTransformTask<IcmpTask> {

    @Override
    protected String getLevel() {
        return "ICMP";
    }

    @Override
    public IcmpTask doBySon(JSONObject jsonObject) {
        return JSON.toJavaObject(jsonObject, IcmpTask.class);
    }
}
