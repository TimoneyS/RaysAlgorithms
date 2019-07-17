package com.ray.LintCode.tostudy;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;
import com.ray.util.Assert;

/**
 * 描述：
 *      LFU(最低频率使用)是一个著名的缓存清理算法。
 *      对于容量为 k 的缓存，当缓存满了需要清理元素时，LFU会选择使用频率最低的一个元素进行清理。
 *      实现LFU的set和get方法
 *
 * 用例：
 *      Input:
 *      LFUCache(3)     // 缓存空间为 3
 *      set(2,2)        // 缓存： 2(0)->2
 *      set(1,1)        // 缓存： 2(0)->2, 1(0) -> 1
 *      get(2)          // 缓存： 2(1)->2, 1(0) -> 1           输出 2
 *      get(1)          // 缓存： 2(1)->2, 1(1) -> 1           输出 1
 *      get(2)          // 缓存： 2(2)->2, 1(1) -> 1           输出 2
 *      set(3,3)        // 缓存： 2(2)->2, 1(1) -> 1, 3(0) -> 3
 *      set(4,4)        // 缓存： 2(2)->2, 1(1) -> 1, 4(0) -> 4  因为3的使用频率最低，被清理
 *      get(3)          // -1
 *      get(2)          // 2
 *      get(1)          // 1
 *      get(4)          // 4
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/lfu-cache/description
 * @date   2019-07-10 22:55:45
 */
public class L_0024_LFU_Cache {

    /**
     * LFU 需要记录每个key被访问的频率
     * 
     * set 和 get 时均要增加频率
     * set时，如果缓存满则需要清理访问频率最低的元素
     * 
     * 键值对应用 map 即可
     * 对于频率，要能够快速找到任意键的频率，同时还能快速找到最小频率
     * 
     * 这里得算法使用数组保存键值对，使用map保存键对应的索引。
     * 当频率改变时，调整数组的顺序
     * 
     * 
     * @author rays1
     *
     */
    static class LFUCache {
        
        private Map<Integer, Integer> indexKeyMap;
        private int[] innerK;
        private int[] innerV;
        private int[] freqOf;
        private int cursor = 0;
        private int capacity;
        
        public LFUCache(int capacity) {
            // 初始化
            this.capacity = capacity;
            cursor = 0;
            innerK = new int[capacity];
            innerV = new int[capacity];
            freqOf = new int[capacity];
            indexKeyMap = new HashMap<Integer, Integer>();
        }

        public void set(int key, int value) {
            int index;
            
            if (indexKeyMap.containsKey(key)) {
                // 已经在缓存中
                index = indexKeyMap.get(key);
                innerV[index] = value;
                addFreqOf(index);
            } else {
                // 添加新键值对
                index = firstIndexOfFreqIs(1);
                
                if (cursor == capacity) {
                    // 缓存满，需要淘汰
                    if (index == cursor ) index -= 1;
                    indexKeyMap.remove(innerK[cursor - 1]);
                } else {
                    // 缓存没满，直接添加
                    cursor ++;
                }
                
                // make space for new cache
                insertToNew(cursor, index, key, value, 1);
                
            }
        }
        
        // 给新缓存移出空间
        private void insertToNew(int envictIndex, int newIndex, int k, int v, int freq) {

            for (int i = envictIndex; i > newIndex; i--) {
                if (i == capacity) {
                    continue;
                }
                indexKeyMap.put(innerK[i - 1], i);
                innerK[i] = innerK[i - 1];
                innerV[i] = innerV[i - 1];
                freqOf[i] = freqOf[i - 1];
            }

            indexKeyMap.put(k, newIndex);
            innerK[newIndex] = k;
            innerV[newIndex] = v;
            freqOf[newIndex] = freq;

        }
        
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
            freqOf[index] ++; 
            insertToNew(index, firstIndexOfFreqIs(freqOf[index]), innerK[index], innerV[index], freqOf[index]);
        }
        
    }
    
    /**
     * 基本思想：所有的缓存元素存放在数组中，使用双向队列维护元素的索引。
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
    static class LFUCache2 {
        
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
        public LFUCache2(int capacity) {
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
        
        cache.set(2, 2);
        cache.set(1, 1);
        Assert.assertEquals(cache.get(2), 2);
        Assert.assertEquals(cache.get(1), 1);
        Assert.assertEquals(cache.get(2), 2);
        cache.set(3, 3);
        cache.set(4, 4);
        Assert.assertEquals(cache.get(3), -1);
        Assert.assertEquals(cache.get(2), 2);
        Assert.assertEquals(cache.get(1), 1);
        Assert.assertEquals(cache.get(4), 4);
        
    }

}
