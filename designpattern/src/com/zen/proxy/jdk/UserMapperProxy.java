package com.zen.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/21 22:12
 **/
public class UserMapperProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        System.out.println(Arrays.toString(args));
        System.out.println(proxy.getClass());
        return null;
    }

    public Object getProxy(Class<?> interfaceProxy) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{interfaceProxy}, this);
    }

    public static void main(String[] args) {
        // 代理可以完全没有目标类，代理的是接口中所有方法；
        // invoke方法可以获取到对应接口的当前调用方法；
        UserMapperProxy userMapperProxy = new UserMapperProxy();
        UserMapper userMapper = (UserMapper) userMapperProxy.getProxy(UserMapper.class);
        userMapper.getUserById(1);
    }
}
