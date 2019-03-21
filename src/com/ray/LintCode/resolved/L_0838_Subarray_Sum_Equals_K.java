package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * @author rays1
 *
 */
public class L_0838_Subarray_Sum_Equals_K {

    /**
     * 前缀数组
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int subarraySumEqualsK(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < nums.length; i++)  nums[i] += nums[i-1];
            
            int rs = 0;
            map.put(0, 1);
            for (int n : nums) {
                rs += map.getOrDefault(n-k, 0);
                map.put(n, map.getOrDefault(n, 0)+1);
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,1,1};
        int k = 2;
        Out.p(new Solution().subarraySumEqualsK(nums, k));
        
    }

}
