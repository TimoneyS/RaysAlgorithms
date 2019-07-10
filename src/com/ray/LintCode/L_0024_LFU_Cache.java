package com.ray.LintCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 *      LFU (Least Frequently Used) is a famous cache eviction algorithm.
 *      
 *      For a cache with capacity *k*, if the cache is full and need to evict a key in it, the key with the lease frequently used will be kicked out.
 *      
 *      Implement `set` and `get` method for LFU cache.
 *
 * 用例：
 *      ```plain
 *      Input:
 *      LFUCache(3)
 *      set(2,2)
 *      set(1,1)
 *      get(2)
 *      get(1)
 *      get(2)
 *      set(3,3)
 *      set(4,4)
 *      get(3)
 *      get(2)
 *      get(1)
 *      get(4)
 *      
 *      Output:
 *      2
 *      1
 *      2
 *      -1
 *      2
 *      1
 *      4
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/lfu-cache/description
 * @date   2019-07-10 22:55:45
 */
public class L_0024_LFU_Cache {

static class LFUCache {
        
        private int[] innerK;
        private int[] innerV;
        private int[] freqOf;
        private Map<Integer, Integer> indexKeyMap = new HashMap<Integer, Integer>();
        private int cursor = 0;
        private int capacity;
        
        /*
         * @param capacity: An integer
         */
        public LFUCache(int capacity) {
            // do intialization if necessary
            this.capacity = capacity;
            cursor = 0;
            innerK = new int[capacity];
            innerV = new int[capacity];
            freqOf = new int[capacity];
        }

        /*
         * @param key: An integer
         * 
         * @param value: An integer
         * 
         * @return: nothing
         */
        public void set(int key, int value) {
            // write your code here
            
            int index;
            
            // alreay in cache
            if (indexKeyMap.containsKey(key)) {
                index = indexKeyMap.get(key);
                innerV[index] = value;
                addFreqOf(index);
            } else {
            
                index = firstIndexOfFreqIs(1);
                
                if (cursor == capacity) {
                    // cache is full
                    if (index == cursor ) index -= 1;
                    indexKeyMap.remove(innerK[cursor - 1]); // cache is full, evict last cache
                } else {
                    // cache not full
                    cursor ++;
                }
                
                // make space for new cache
                insertToNew(cursor, index, key, value, 1);
                
            }
        }
        
        // make space for new cache
        private void insertToNew(int envictIndex, int newIndex, int k, int v, int freq) {

            for (int i = envictIndex; i > newIndex; i--) {
                if (i == capacity)
                    continue;
                indexKeyMap.put(innerK[i - 1], i);
                moveTo(innerK, i - 1, i);
                moveTo(innerV, i - 1, i);
                moveTo(freqOf, i - 1, i);
            }

            indexKeyMap.put(k, newIndex);
            innerK[newIndex] = k;
            innerV[newIndex] = v;
            freqOf[newIndex] = freq;

        }
        
        private void moveTo(int[] arr, int i, int j) {
            arr[j] = arr[i];
        }

        /*
         * @param key: An integer
         * 
         * @return: An integer
         */
        public int get(int key) {
            // write your code here
            if (indexKeyMap.containsKey(key)) {
                int index = indexKeyMap.get(key);
                int v = innerV[index]; 
                addFreqOf(index);
                return v;
            } else {
                return -1;
            }
        }

        // find first cache of freq, return curcor if no such cache
        private int firstIndexOfFreqIs(int freq) {
            // find first index whitch freq is 1
            for (int i = 0; i < cursor; i++)
                if (freqOf[i] <= freq) return i;
            return cursor;
        }
        
        private void addFreqOf(int index) {
            int freq = freqOf[index] + 1; 
            freqOf[index] = freq;
            int newIndex = firstIndexOfFreqIs(freq);
            insertToNew(index, newIndex, innerK[index], innerV[index], freq);
        }
        
    }
    
    public static void main(String[] args) {
        
    }

}
