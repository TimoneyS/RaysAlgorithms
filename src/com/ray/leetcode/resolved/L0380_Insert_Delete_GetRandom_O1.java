package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Insert Delete GetRandom O(1)
 * -----------------------------------------------------------------------------
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * Example:
 *      Example 1
 *      // Init an empty set.
 *      RandomizedSet randomSet = new RandomizedSet();
 *      // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 *      randomSet.insert(1);
 *      // Returns false as 2 does not exist in the set.
 *      randomSet.remove(2);
 *      // Inserts 2 to the set, returns true. Set now contains [1,2].
 *      randomSet.insert(2);
 *      // getRandom should return either 1 or 2 randomly.
 *      randomSet.getRandom();
 *      // Removes 1 from the set, returns true. Set now contains [2].
 *      randomSet.remove(1);
 *      // 2 was already in the set, so return false.
 *      randomSet.insert(2);
 *      // Since 2 is the only number in the set, getRandom always return 2.
 *      randomSet.getRandom();
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * @since   2020-03-23 22:00:04
 */
public class L0380_Insert_Delete_GetRandom_O1 {
    static class RandomizedSet {
        private List<Integer> inner;
        private Map<Integer, Integer> map ;

        public RandomizedSet() {
            inner = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            inner.add(val);
            map.put(val, inner.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int idx = map.get(val);
            if (idx != inner.size() - 1) {
                inner.set(idx, inner.get(inner.size() - 1));
                map.put(inner.get(idx), idx);
            }
            inner.remove(inner.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return inner.get((int) (Math.random() * inner.size()));
        }
    }
    
    public static void main(String[] args) {
    }
}
