package com.zen.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.ParameterizedType;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/27 20:58
 **/
public abstract class AbstractTransformTask<T> {

    // 责任链模式：抽象处理器只需要记住三点：
    // 我处理谁：level，
    // 我怎么处理：transfor，
    // 我的下一个是谁：nextTransform

    public T transform(String protocol, JSONObject jsonObject) {
        // 这里获取到类上泛型的类型手法也不错啊！！！！
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        if (this.getLevel().equals(protocol)) {
            return JSON.toJavaObject(jsonObject, (Class<T>) pt.getActualTypeArguments()[0]);
        } else {
            if (this.nextTransformTask != null) {
                return (T) this.nextTransformTask.transform(protocol, jsonObject);
            } else {
                return null;
            }
        }
    }

    private AbstractTransformTask nextTransformTask;

    public void setNextTransformTask(AbstractTransformTask nextTransformTask) {
        this.nextTransformTask = nextTransformTask;
    }

    protected abstract String getLevel();
    // 这里抽象类直接处理了所有转化逻辑，实际上这里应该有抽象方法，供子类去实现
    // 也就是处理者实现自己的处理逻辑；
    // 在本例中，抽象类直接通过泛型，获取到了不同处理类的处理逻辑，自己处理结束了；
    // 实际上是通过分发请求，虽然一开始并不知道前端传递是什么协议类型，但是将所有处理者
    // 循环一遍，总存在合适的处理者，而这个处理者肯定知道咋么处理前端的数据，是转为什么类型的task的

}
