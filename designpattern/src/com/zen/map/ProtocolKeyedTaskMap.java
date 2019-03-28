package com.zen.map;

import com.zen.domain.HttpTask;
import com.zen.domain.IcmpTask;
import com.zen.domain.Task;
import com.zen.domain.TcpTask;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/3/28 22:14
 **/
// 想要覆盖hashMap的put方法，注意都要加上泛型<K,V>，查看HashMap就可以看到了HashMap<K,V> extends AbstractMap<K,V>
//public class ProtocolKeyedTaskMap<K, V> extends HashMap<K, V> {
//
//    public static final Map protocolKeyedTaskMap = new ProtocolKeyedTaskMap<String, Task>();
//
//    static {
//        protocolKeyedTaskMap.put("HTTP", HttpTask.class);
//        protocolKeyedTaskMap.put("ICMP", IcmpTask.class);
//        protocolKeyedTaskMap.put("TCP", TcpTask.class);
//    }
//
//    @Override
//    public V put(K key, V value) {
//        throw new UnSupportedException(getClass().getName() + " 不支持put方法");
//    }
//
//    @Override
//    public V remove(Object key) {
//        throw new UnSupportedException(getClass().getName() + " 不支持remove方法");
//    }
//
//    public static Object get(String key) {
//        return protocolKeyedTaskMap.get(key);
//    }
//}
public class ProtocolKeyedTaskMap {
    private static final Map protocolKeyedTaskMap = new HashMap();

    static {
        protocolKeyedTaskMap.put("HTTP", HttpTask.class);
        protocolKeyedTaskMap.put("ICMP", IcmpTask.class);
        protocolKeyedTaskMap.put("TCP", TcpTask.class);
    }

    public static Class<? extends Task> get(String key) {
        return (Class<? extends Task>) protocolKeyedTaskMap.get(key);
    }

}
