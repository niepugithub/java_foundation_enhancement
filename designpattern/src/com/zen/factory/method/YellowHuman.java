package com.zen.factory.method;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/20 22:07
 **/
public class YellowHuman implements Human {
    @Override
    public String getColor() {
        return "yellow";
    }

    @Override
    public String say() {
        return "i am a yellow man";
    }
}
