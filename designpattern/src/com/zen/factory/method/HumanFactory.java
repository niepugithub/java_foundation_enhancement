package com.zen.factory.method;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/20 22:21
 **/
public class HumanFactory extends AbstractHumanFactory {
    @Override
    Human getHuman(Class<? extends Human> clazz) {
        Human human = null;
        try {
            human = (Human) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }
}
