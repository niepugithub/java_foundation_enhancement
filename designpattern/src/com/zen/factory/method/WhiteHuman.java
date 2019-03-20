package com.zen.factory.method;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/20 22:07
 **/
public class WhiteHuman implements Human {
    @Override
    public String getColor() {
        return "white";
    }

    @Override
    public String say() {
        return "i am a white man";
    }
}
