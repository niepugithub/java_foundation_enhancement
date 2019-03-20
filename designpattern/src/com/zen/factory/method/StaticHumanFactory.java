package com.zen.factory.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/20 22:08
 **/
public class StaticHumanFactory {

    public static Human getHuman(Class<? extends Human> clazz) {
        Human human = null;
        try {
            Constructor constructor = clazz.getConstructor();
            human = (Human) constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return human;
    }
}
