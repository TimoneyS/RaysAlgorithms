package com.ray.LintCode;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: 
 *      [-3,1,1,-3,5] 
 *      Output: 
 *      [0,2]
 *      Explanation: [0,2], [1,3], [1,1], [2,2], [0,4]
 *      ```
 *
 * 挑战：
 *      O(nlogn) time
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/subarray-sum-closest/description
 * @date   2019-07-11 18:31:04
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
