package com.zen.factory.method;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/20 22:16
 **/
public abstract class AbstractHumanFactory {
    abstract Human getHuman(Class<? extends Human> clazz);
}
