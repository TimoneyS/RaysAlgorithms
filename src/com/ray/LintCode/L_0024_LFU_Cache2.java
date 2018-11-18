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
public class L_0024_LFU_Cache2 {
    
    /**
     * 基本思想：所有的缓存元素存放在数组种，使用双向队列维护元素的索引。
     * 每个元素按照 访问次数排序，访问次数相同的则按照时间排序。
     * 
     * 新增元素：访问次数为1淘汰，并淘汰队队尾元素 （当队列满时队尾元素为最后一个元素，队列未满是队尾元素为空）
     * 修改、访问元素：元素访问次数加1，并对将元素插入到访问次数相同的所有元素之前。
     * 
     * 
     * 使用链表结构，避免过多的移动元素。
     * 同时因为表的长度是固定的，则用数组维护左右链接。
     * 
     * 一个可优化的点是：修改和访问元素时寻找元素的索引从首部循环，新增元素寻找位置时从尾部循环。
     * 
     * @author rays1
     *
     */
    static class LFUCache {
        
        private int size;
        private Map<Integer, Integer> keyIndexMap = new HashMap<>();
        
        private int[] freqOf;
        private int[] innerV;
        private int[] innerK;
        
        private int[] leftOf;
        private int[] rightOf;
        
        private int head;
        private int tail;
        
        /*
         * @param capacity: An integer
         */
        public LFUCache(int capacity) {
            // do intialization if necessary
            size = capacity;
            
            freqOf = new int[size];
            innerV = new int[size];
            innerK = new int[size];
            
            leftOf = new int[size];
            rightOf = new int[size];
            
            head = tail = 0;
            
            for (int i = 0; i < size; i++) {
                leftOf[i] = i - 1;
                rightOf[i] = i + 1;
            }
            
        }
        
        private void insert(int index, int k, int v, int freq) {
            innerK[index] = k;
            innerV[index] = v;
            freqOf[index] = freq;
        }
        
        private void insertBefore(int srcIndex, int tarIndex) {
            int l = leftOf[tarIndex];
            int r = tarIndex;
            
            if (l > -1 && l < size) rightOf[l] = srcIndex;
            if (r > -1 && r < size) leftOf[r] = srcIndex;
            
            leftOf[srcIndex] = l;
            rightOf[srcIndex] = r;
        }

        private void deleteAt(int index) {
            int l = leftOf[index];
            int r = rightOf[index];
            if (l > -1 && l < size) rightOf[l] = r;
            if (r > -1 && r < size) leftOf[r] = l;
        }
        
        private int indexOfFreq(int freq) {
            for (int i = head; i < size; i = rightOf[i]) {
                if (freqOf[i] <= freq) return i;
            }
            return tail;
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
            int srcIndex,tarIndex,freq;
            if (keyIndexMap.containsKey(key)) {
                srcIndex = keyIndexMap.get(key);
                freq = freqOf[srcIndex] +1;
                tarIndex = indexOfFreq(freq);
            } else {
                srcIndex = tail;
                keyIndexMap.remove(innerK[tail]);
                keyIndexMap.put(key, srcIndex);
                freq = 1;
                tarIndex = indexOfFreq(freq);
                if (rightOf[tail] < size)
                    tail = rightOf[tail];
            }
            
            insert(srcIndex, key, value , freq);
            
            if (srcIndex == tarIndex) return;
            
            if (tarIndex == head) head = srcIndex;
            if (srcIndex == tail) tail = leftOf[srcIndex];
            // envict old link
            deleteAt(srcIndex);
            insertBefore(srcIndex, tarIndex);
            
        }
        
        /*
         * @param key: An integer
         * 
         * @return: An integer
         */
        public int get(int key) {
            // write your code here
            if (keyIndexMap.containsKey(key)) {
                int oldIndex = keyIndexMap.get(key);
                set(key, innerV[oldIndex]);
                return innerV[oldIndex];
            } else {
                return -1;
            }

        }
        
        public void printOrder() {
            Out.sep();
            
            StringBuilder linkSb = new StringBuilder();
            StringBuilder strSb = new StringBuilder();
            
            linkSb.append(leftOf[head]).append(" <-- ");
            strSb.append("[] <-- ");
            
            for (int i = head; i != tail; i = rightOf[i]) {
                linkSb.append(i).append(" <--> ");
                strSb.append("[").append(innerK[i] ).append(", ")
                    .append(innerV[i]).append(", ")
                    .append(freqOf[i]).append("]").append(" <--> ");
            }
            linkSb.append(tail).append(" --> ").append(rightOf[tail]);
            
            strSb.append("[").append(innerK[tail] ).append(", ")
                .append(innerV[tail]).append(", ")
                .append(freqOf[tail]).append("]").append(" --> []");
            
            Out.p(linkSb);
            Out.p(strSb);            
            Out.p(keyIndexMap);
            
            Out.sep();
        }
        
        

    }
    
    public static void main(String[] args) {
        
        LFUCache cache = new LFUCache(3);
        
        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        Out.pt(cache.get(1)+",");
        cache.set(4, 40);
        Out.pt(cache.get(4)+",");
        Out.pt(cache.get(3)+",");
        Out.pt(cache.get(2)+",");
        Out.pt(cache.get(1)+",");
        cache.set(5, 50);
        Out.pt(cache.get(1)+",");
        Out.pt(cache.get(2)+",");
        Out.pt(cache.get(3)+",");
        Out.pt(cache.get(4)+",");
        Out.pt(cache.get(5));
        // [10,40,30,-1,10,10,-1,30,-1,50]
        
//        cache.set(1, 10);
//        cache.set(2, 20);
//        cache.set(3, 30);
//        Out.p(cache.get(1));
//        cache.set(4, 40);
//        Out.p(cache.get(4));
//        Out.p(cache.get(3));
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
