package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: nums = [1,1,1] and k = 2
 *      Output: 2
 *      Explanation:
 *      subarray [0,1] and [1,2]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: nums = [2,1,-1,1,2] and k = 3
 *      Output: 4
 *      Explanation:
 *      subarray [0,1], [1,4], [0,3] and [3,4]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/subarray-sum-equals-k/description
 * @date   2019-07-11 18:37:19
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
        
        Out.p(new Solution());
        
    }

}
