package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Insert Delete GetRandom O(1) - Duplicates allowed
 * -----------------------------------------------------------------------------
 * Design a data structure that supports all following operations in average O(1) time.
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 *
 * Example:
 *      Example 1
 *      // Init an empty collection.
 *      RandomizedCollection collection = new RandomizedCollection();
 *      // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 *      collection.insert(1);
 *      // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 *      collection.insert(1);
 *      // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 *      collection.insert(2);
 *      // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 *      collection.getRandom();
 *      // Removes 1 from the collection, returns true. Collection now contains [1,2].
 *      collection.remove(1);
 *      // getRandom should return 1 and 2 both equally likely.
 *      collection.getRandom();
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * @since   2020-03-23 21:59:14
 */
public class L0381_Insert_Delete_GetRandom_O1___Duplicates_allowed {
    static class RandomizedCollection {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        public RandomizedCollection() {}

        public boolean insert(int val) {
            list.add(val);
            if (!map.containsKey(val)) map.put(val, new HashSet<>());
            map.get(val).add(list.size() - 1);
            return map.get(val).size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).isEmpty()) return false;
            int idx = list.get(list.size() - 1) == val ? list.size() - 1 : map.get(val).iterator().next();
            if (idx != list.size() - 1) {
                int newVal = list.get(list.size() - 1);
                map.get(newVal).add(idx);
                map.get(newVal).remove(list.size() - 1);
                list.set(idx, newVal);
            }
            map.get(val).remove(idx);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));
        }
    }
    
    public static void main(String[] args) {
    }
}
