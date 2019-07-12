package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are **arranged in a circle**. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 *      
 *      Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight **without alerting the police**.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:  nums = [3,6,4]
 *      Output: 6
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input:  nums = [2,3,2,3]
 *      Output: 6
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/house-robber-ii/description
 * @date   2019-07-11 18:33:51
 */
public class L_0534_House_Robber_II {

    /**
     * 抢劫 
     * 0  - n-2
     * 1  - n-1
     * 选择最大值
     * 
     * @author rays1
     *
     */
    static class Solution {
        public int houseRobber2(int[] nums) {
            if (nums.length == 1) return nums[0];
            return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }
        
        public int rob(int[] nums, int start, int end) {
            int s = 0, w = 0, pres = 0;
            for (int i = start; i <= end; i++) {
                pres = s;
                s = w + nums[i];
                w = Math.max(w, pres);
            }
            return Math.max(s, w);
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
