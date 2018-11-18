package com.ray.LintCode;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * LFU (Least Frequently Used) is a famous cache eviction algorithm.
 * For a cache with capacity k, if the cache is full and need to evict a key in it,
 * the key with the lease frequently used will be kicked out.
 * <p>
 * 缓存淘汰算法（LFU）。
 * 当缓存满时，淘汰访问最不频繁的元素。
 * <p>
 * Implement set and get method for LFU cache.
 * <p>
 * <b>Example<b>
 * <p>
 * Given capacity=3
 * <li>set(2,2)
 * <li>set(1,1)
 * <li>get(2)
 * <li>>> 2
 * <li>get(1)
 * <li>>> 1
 * <li>get(2)
 * <li>>> 2
 * <li>set(3,3)
 * <li>set(4,4)
 * <li>get(3)
 * <li>>> -1
 * <li>get(2)
 * <li>>> 2
 * <li>get(1)
 * <li>>> 1
 * <li>get(4)
 * <li>>> 4
 * 
 * @author rays1
 *
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
                makeSpace(cursor, index);
                
                indexKeyMap.put(key, index);
                innerK[index] = key;
                innerV[index] = value;
                freqOf[index] = 1;
            }
        }
        
        // make space for new cache
        private void makeSpace(int begin, int end) {
            for (int i = begin; i > end; i --) {
                if (i == capacity) continue;
                indexKeyMap.put(innerK[i-1], i);
                moveTo(innerK, i-1, i);
                moveTo(innerV, i-1, i);
                moveTo(freqOf, i-1, i);
             }
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
            
            int key = innerK[index]; 
            int value = innerV[index];
            int newIndex = firstIndexOfFreqIs(freq);
            makeSpace(index, newIndex);
            
            indexKeyMap.put(key, newIndex);
            innerK[newIndex] = key;
            innerV[newIndex] = value;
            freqOf[newIndex] = freq;
            
        }
        
    }
    
    public static void main(String[] args) {
        
        LFUCache cache = new LFUCache(3);
        

        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        
Out.p(cache.innerK);        
        Out.p(cache.get(1));
Out.p(cache.innerK);         
        cache.set(4, 40);
Out.p(cache.innerK);
        Out.p(cache.get(4));
        Out.p(cache.get(3));

        
//        Out.p(cache.get(2));
//        Out.p(cache.get(1));
//        
//        cache.set(5, 50);
//        
//        Out.p(cache.get(1));
//        Out.p(cache.get(2));
//        Out.p(cache.get(3));
//        Out.p(cache.get(4));
//        Out.p(cache.get(5));
        
    }
    
}
