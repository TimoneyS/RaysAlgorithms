package com.ray.LintCode.util;

import java.util.HashMap;
import java.util.Map;

public class OutputCollector<K, V> {
    
    Map<K, V> inner = new HashMap<>();
    
    public void collect(K key, V value) {
        inner.put(key, value);
    }
}