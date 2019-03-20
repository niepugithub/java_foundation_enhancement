package com.zen.factory.method;

import org.junit.Test;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/20 22:11
 **/

public class FactoryTest {

    @Test
    public void test1() {
        Human yellowHuman = StaticHumanFactory.getHuman(YellowHuman.class);
        System.out.println(yellowHuman.getColor());
        System.out.println(yellowHuman.say());

        Human whiteman = StaticHumanFactory.getHuman(WhiteHuman.class);
        System.out.println(whiteman.getColor());
        System.out.println(whiteman.say());

        Human blackman = StaticHumanFactory.getHuman(BlackHuman.class);
        System.out.println(blackman.getColor());
        System.out.println(blackman.say());
    }

    @Test
    public void getHumanFactory() {
        HumanFactory humanFactory = new HumanFactory();
        Human yellowHuman = humanFactory.getHuman(YellowHuman.class);
        System.out.println(yellowHuman.getColor());
        System.out.println(yellowHuman.say());

        Human whiteman = humanFactory.getHuman(WhiteHuman.class);
        System.out.println(whiteman.getColor());
        System.out.println(whiteman.say());

        Human blackman = humanFactory.getHuman(BlackHuman.class);
        System.out.println(blackman.getColor());
        System.out.println(blackman.say());
    }
}
