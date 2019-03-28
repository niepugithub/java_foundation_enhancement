package com.zen.strategy.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/28 22:56
 **/
public interface Transform<T> {
    T exec(JSONObject jsonObject);
}
