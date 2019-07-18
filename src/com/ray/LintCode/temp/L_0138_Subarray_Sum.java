package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array, find a subarray where the sum of numbers is **zero**. Your code should return the index of the first number and the index of the last number.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:  [-3, 1, 2, -3, 4]
 *      Output: [0, 2] or [1, 3].
 *      Explanation: return anyone that the sum is 0.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  [-3, 1, -4, 2, -3, 4]
 *      Output: [1,5]	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/subarray-sum/description
 * @date   2019-07-11 18:31:03
 */
public class L_0138_Subarray_Sum {

    /*
     * 如果数组中从 i 到 j 部分的和为 0
     * 那么必然数组之和 s[0..i-1] = s[0..j+1]
     * 因此只要一直加，同时保存每次累加的结果
     * 直到找到两个和相等的部分即可
     */
    static class Solution {
        public List<Integer> subarraySum(int[] nums) {
            
            ArrayList<Integer> rs = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum)) {
                    rs.add(map.get(sum)+1);
                    rs.add(i);
                    break;
                }
                map.put(sum, i);
            }
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {-3,1,2,-3,4};
        
        Out.p(new Solution().subarraySum(nums));
    }

}
