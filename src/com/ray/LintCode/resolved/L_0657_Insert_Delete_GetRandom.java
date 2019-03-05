package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 设计一个数据结构，这个数据结构能够支持如下的操作，并且时间复杂度平均是O(1)
 *      insert(val): 插入新值
 *      remove(val): 删除一个值
 *      getRandom  : 返回随机的一个元素，每个元素被返回的概率是相同的。
 * @author rays1
 *
 */
public class L_0657_Insert_Delete_GetRandom {

    static class RandomizedSet {
        
        int[] inner = new int[2]; 
        int cursor  = 0;
        Map<Integer, Integer> v2i = new HashMap<>();
        
        public boolean insert(int val) {
            ensureSpace();
            if (!v2i.containsKey(val)) {
                inner[cursor ++] = val;
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            Integer n;
            if ( (n = v2i.remove(val)) != null) {
                for (int i = n; i < cursor; i++) inner[i] = inner[i+1];
                cursor --;
                return true;
            }
            return false;
        }

        public int getRandom() {
            return inner[(int) (Math.random() * cursor)];
        }
        
        private void ensureSpace() {
            if (cursor >= inner.length)
                inner = Arrays.copyOf(inner, inner.length*2);
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new RandomizedSet());
        
    }

}
