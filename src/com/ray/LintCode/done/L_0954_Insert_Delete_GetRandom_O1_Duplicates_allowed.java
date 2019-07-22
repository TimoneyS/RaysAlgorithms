package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Design a data structure that supports all following operations in average **O(1)** time.
 *      
 *      设计一个数据结构，需要支持以下操作，且平均时间复杂度为 O(1)。允许有重复元素
 *          insert(val): 往容器中插入一个值为 val 的元素。
 *          remove(val): 从容器中移除一个值为 val 的元素，如果存在于容器中的话。
 *          getRandom: 随机返回一个容器中现有的元素。每个元素被返回的概率与它在容器中的数量呈线性关系。
 *      
 * 用例：
 *      **用例 1:**
 *      ```
 *      输入:
 *      insert(1)
 *      insert(1)
 *      insert(2)
 *      getRandom()
 *      remove(1)
 *      
 *      // Init an empty collection.
 *      RandomizedCollection collection = new RandomizedCollection();
 *      
 *      // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 *      collection.insert(1);
 *      
 *      // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 *      collection.insert(1);
 *      
 *      // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 *      collection.insert(2);
 *      
 *      // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 *      collection.getRandom();
 *      
 *      // Removes 1 from the collection, returns true. Collection now contains [1,2].
 *      collection.remove(1);
 *      
 *      // getRandom should return 1 and 2 both equally likely.
 *      collection.getRandom();
 *      ```
 *      
 *      **用例 2:**
 *      ```
 *      输入:
 *      insert(1)
 *      insert(1)
 *      getRandom()
 *      remove(1)
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/insert-delete-getrandom-o1-duplicates-allowed/description
 * @date   2019-07-22 01:19:12
 */
public class L_0954_Insert_Delete_GetRandom_O1_Duplicates_allowed {

    /**
     * 用 List 保存元素以及其在 Map 中的索引
     * 用 Map 保存元素在 List 中的索引，有重复的元素因此索引是一个列表
     * 
     * 例如添加  1 2 3 1 2 后的数据结构如下： 
     *  
     *          List  [0, 1] [0, 2] [0, 3] [1, 1] [1, 2] 
     *          Map   1 -> [0, 3]
     *                2 -> [1, 4]
     *                3 -> [2]
     * 
     * 此时各种方法的实现：
     *      1. 随机元素，直接随机 [0, List.size()] 之间数字
     *      2. 添加元素，如添加 1，无论是 Map 还是List 都是将 1 添加到最尾部
     *          因此 1 在List 中的索引是 5，在 Map 中的索引是 2
     *          因此向 List 尾部添加 [2, 1]
     *          向Map 1 对应的 value 尾部添加 5
     *          
     *          List  [0, 1] [0, 2] [0, 3] [1, 1] [1, 2] [2, 1] 
     *          Map   1 -> [0, 3, 5]
     *                2 -> [1, 4]
     *                3 -> [2]
     *          
     *      3. 删除元素，如果删除 3
     *          先从 Map 找到 3 在列表中的索引 2
     *          数值列表索引5 覆盖索引 2，即用 [2, 1] 覆盖 [0, 3]
     *          将 1 对应的索引列表中位置2的索引改为 2
     *          然后在 Map 因为 3 对应的索引列表删除最后一位后为空，因此移除 3 对应的列表
     *          
     *          List  [0, 1] [0, 2] [2, 1] [1, 1] [1, 2]  
     *          Map   1 -> [0, 3, 2]
     *                2 -> [1, 4]
     *          
     * @author rays1
     *
     */
    static class RandomizedCollection {

        private List<int[]> inner;
        private Map<Integer, List<Integer>> hash;
        
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            inner = new ArrayList<>();
            hash = new HashMap<>();
            
        }
        
        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contains = hash.containsKey(val);
            if (!contains) {
                hash.put(val, new ArrayList<>());
            }
            hash.get(val).add(inner.size());
            inner.add(new int[] {hash.get(val).size()-1, val});
            return !contains;
        }
        
        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            
            if (!hash.containsKey(val)) {
                return false;
            }

            List<Integer> indices = hash.get(val);
            int index = indices.get(indices.size() - 1);
            
            int[] numIndex = inner.get(inner.size() - 1);
            inner.set(index, numIndex);
            inner.remove(inner.size() - 1);
            hash.get(numIndex[1]).set(numIndex[0], index);
            
            indices.remove(indices.size() - 1);
            if (indices.size() == 0) {
                hash.remove(val);
            }
            
            return true;
        }
        
        /** Get a random element from the collection. */
        public int getRandom() {
            int index = (int) (Math.random() * inner.size());
            return inner.get(index)[1];
        }
        
    }
    
    /**
     * 用 List 保存数值
     * 用 Map 保存数值对应的索引，索引集合用 LinkedHashSet
     * 
     * 例如添加  1 2 3 1 2 后的数据结构如下： 
     *          List  1 2 3 1 2
     *          Map   1 -> [0, 3]
     *                2 -> [1, 4]
     *                3 -> [2]
     * 
     * 此时各种方法的实现：
     *      1. 随机元素，直接随机 [0, List.size()] 之间数字
     *      
     *      2. 添加元素 1
     *         1 放入列表的末尾，索引为 5，在Map中添加1对应的索引 5
     *          List  1 2 3 1 2 1
     *          Map   1 -> [0, 3, 5]
     *                2 -> [1, 4]
     *                3 -> [2]
     *      
     *      3. 删除元素 3
     *          找到 3 对应的索引 2
     *          用数值列表尾部索引5 覆盖 索引 2
     *          在索引集合中删除 1 对应的索引5，添加 1对应的索引 2
     *          在索引集合中删除 3 对应的索引 2，删除后索引集合为空，删除 3 的映射
     *          
     *          List  1 2 1 1 2
     *          Map   1 -> [0, 3, 2]
     *                2 -> [1, 4]
     * 
     * @author rays1
     *
     */
    class RandomizedCollection2 {

        ArrayList<Integer> inner;
        HashMap<Integer, LinkedHashSet<Integer>> hash;
        
        public RandomizedCollection2() {
            inner = new ArrayList<Integer>();
            hash = new HashMap<Integer, LinkedHashSet<Integer>>();
        }

        public boolean insert(int val) {
            boolean alreadyExists = hash.containsKey(val);
            if(!alreadyExists) {
                hash.put(val, new LinkedHashSet<Integer>());
            }
            hash.get(val).add(inner.size());
            inner.add(val);
            return !alreadyExists;
        }
        
        public boolean remove(int val) {
            if(!hash.containsKey(val)) {
                return false;
            }
            LinkedHashSet<Integer> indexSet = hash.get(val);
            int indexToReplace = indexSet.iterator().next();
            
            int lastNum = inner.get(inner.size() - 1);
            LinkedHashSet<Integer> replaceWith = hash.get(lastNum);
            
            inner.set(indexToReplace, lastNum);
            
            indexSet.remove(indexToReplace);
            
            if(indexToReplace != inner.size() - 1) {
                replaceWith.remove(inner.size() - 1);
                replaceWith.add(indexToReplace);
            }
            inner.remove(inner.size() - 1);
            
            if(indexSet.isEmpty()) {
                hash.remove(val);
            }
            return true;
        }
        
        public int getRandom() {
            return inner.get((int)(Math.random() * inner.size()));
        }
        
    }
    
    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        
        rc.insert(1);
        rc.insert(2);
        rc.insert(3);
        rc.insert(1);
        rc.insert(2);
        
        for (int[] a: rc.inner)
            Out.pt(Arrays.toString(a));
        Out.p();
        Out.p(rc.hash);
        
        rc.insert(1);
        
        Out.sep();
        for (int[] a: rc.inner)
            Out.pt(Arrays.toString(a));
        Out.p();
        Out.p(rc.hash);
        
        rc.remove(3);
        
        Out.sep();
        for (int[] a: rc.inner)
            Out.pt(Arrays.toString(a));
        Out.p();
        Out.p(rc.hash);
               
    }

}
