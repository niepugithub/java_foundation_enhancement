package com.zen.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zen.domain.TcpTask;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/27 20:52
 **/
public class TransformTcpTask extends AbstractTransformTask<TcpTask> {

    @Override
    protected String getLevel() {
        return "TCP";
    }

    @Override
    public TcpTask doBySon(JSONObject jsonObject) {
        return JSON.toJavaObject(jsonObject, TcpTask.class);
    }
}
