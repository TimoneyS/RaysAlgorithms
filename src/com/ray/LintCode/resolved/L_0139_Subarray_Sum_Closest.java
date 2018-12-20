package com.ray.LintCode.resolved;

import java.util.Map.Entry;

import com.ray.io.Out;

import java.util.TreeMap;

/**
 * Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
 * 一个整数数组，寻找所有和最接近0的子数组。
 * 
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 * @author rays1
 *
 */
public class L_0139_Subarray_Sum_Closest {

    static class Solution {
        /*
         * @param nums: A list of integers
         * @return: A list of integers includes the index of the first number and the index of the last number
         */
        public int[] subarraySumClosest(int[] nums) {
            
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum)) {
                    return new int[] {map.get(sum)+1, i};
                } else {
                    map.put(sum, i);
                }
            }
            
            int i = 0, j = 0;
            Entry<Integer, Integer> prev = map.pollFirstEntry();

            int closest = Math.abs(prev.getKey());
            for (Entry<Integer, Integer> entry = map.pollFirstEntry(); entry != null; entry = map.pollFirstEntry()) {
                
                if (closest > Math.abs(entry.getKey())) {
                    closest = Math.abs(entry.getKey());
                    i = 0;
                    j = entry.getValue();
                }
                
                if (closest > Math.abs(entry.getKey() - prev.getKey())) {
                    closest = Math.abs(entry.getKey() - prev.getKey());
                    i = Math.min(prev.getValue(), entry.getValue()) + 1;
                    j = Math.max(prev.getValue(), entry.getValue());
                }
                prev = entry;
            }
            
            return new int[] {i, j};
        }
    }
    
    public static void main(String[] args) {
        
        int[] nums = {2,0,0,1,-1,-1};
        
        Out.p(new Solution().subarraySumClosest(nums));
    }

}
