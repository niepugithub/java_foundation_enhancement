package com.zen.chain;

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
}
