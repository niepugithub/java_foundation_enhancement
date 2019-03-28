package com.zen.chain;

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
}
