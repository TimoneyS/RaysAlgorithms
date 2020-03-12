package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Top K Frequent Elements
 * -----------------------------------------------------------------------------
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example:
 *      Example 1
 *      Input: nums = [1,1,1,2,2,3], k = 2
 *      Output: [1,2]
 *      Example 2
 *      Input: nums = [1], k = 1
 *      Output: [1]
 *      Note: 
 *      	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *      	Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @since   2020-03-12 22:50:38
 */
public class L0347_Top_K_Frequent_Elements {
    /**
     * 统计所有数字的计数，然后一次将所有数字统计数-1
     * 将统计位 0  的数字移除，直到map中剩下的数字恰好为 k
     */
    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums)
                map.put(i, map.getOrDefault(i, 0) + 1);
            while (map.size() > k) {
                map.entrySet().forEach(e -> e.setValue(e.getValue()-1));
                map.entrySet().removeIf(e -> e.getValue() <= 0);
            }
            return new ArrayList<>(map.keySet());
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
