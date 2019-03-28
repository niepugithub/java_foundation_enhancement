package com.zen.chain;

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
}
