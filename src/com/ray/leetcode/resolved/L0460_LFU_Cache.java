package com.ray.leetcode.resolved;

import java.util.HashMap;
import java.util.Map;

/**
 * LFU Cache
 * -----------------------------------------------------------------------------
 *  LFU(最低频率使用)是一个著名的缓存清理算法。
 *  对于容量为 k 的缓存，当缓存满了需要清理元素时，LFU会选择使用频率最低的一个元素进行清理。
 *  实现LFU的set和get方法
 * Example:
 *      LFUCache cache = new LFUCache( 2);
 *      cache.put(1, 1);
 *      cache.put(2, 2);
 *      cache.get(1);       // returns 1
 *      cache.put(3, 3);    // evicts key 2
 *      cache.get(2);       // returns -1 (not found)
 *      cache.get(3);       // returns 3.
 *      cache.put(4, 4);    // evicts key 1.
 *      cache.get(1);       // returns -1 (not found)
 *      cache.get(3);       // returns 3
 *      cache.get(4);       // returns 4
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/lfu-cache/
 * @since   2020-04-04 17:31:36
 */
public class L0460_LFU_Cache {
    /**
     * LFU 中每个 key 对应两个值，频率和访问顺序
     * 所有 key 按照频率和访问顺序排序
     * 所有的访问顺序都会更新频率和访问顺序
     *
     * 键值对应用 map 即可
     * 对于频率，要能够快速找到任意键的频率，同时还能快速找到最小频率
     * 这里得算法使用数组保存键值对，使用map保存键对应的索引。
     * 当频率改变时，调整数组的顺序
     */
    static class LFUCache {
        private Map<Integer, Integer> indexKeyMap;
        private int[] innerK;
        private int[] innerV;
        private int[] freqOf;
        private int cursor = 0;       
        private int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            cursor = 0;
            innerK = new int[capacity];
            innerV = new int[capacity];
            freqOf = new int[capacity];
            indexKeyMap = new HashMap<Integer, Integer>();
        }

        public void put(int key, int value) {

            if (capacity < 1) return;

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
     * 使用链表结构，避免过多的移动元素。
     * 同时因为表的长度是固定的，则用数组维护左右链接。
     *
     * 一个可优化的点是：修改和访问元素时寻找元素的索引从首部循环，新增元素寻找位置时从尾部循环。
     */
    static class LFUCache_2 {
        private int size;
        private Map<Integer, Integer> keyIndexMap = new HashMap<>();

        private int[] freqOf;
        private int[] innerV;
        private int[] innerK;

        private int[] leftOf;
        private int[] rightOf;

        private int head;
        private int tail;

        public LFUCache_2(int capacity) {
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

        public void put(int key, int value) {
            if (size < 1) return;
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

        public int get(int key) {
            if (keyIndexMap.containsKey(key)) {
                int oldIndex = keyIndexMap.get(key);
                put(key, innerV[oldIndex]);
                return innerV[oldIndex];
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache_2 cache = new LFUCache_2(0);
        cache.put(0, 0);
    }
}
