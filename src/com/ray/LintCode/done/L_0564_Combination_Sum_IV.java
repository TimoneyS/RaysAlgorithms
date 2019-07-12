package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array `nums` with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer `target`.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: nums = [1, 2, 4], and target = 4
 *      Output: 6
 *      Explanation:
 *      The possible combination ways are:
 *      [1, 1, 1, 1]
 *      [1, 1, 2]
 *      [1, 2, 1]
 *      [2, 1, 1]
 *      [2, 2]
 *      [4]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: nums = [1, 2], and target = 4
 *      Output: 5
 *      Explanation:
 *      The possible combination ways are:
 *      [1, 1, 1, 1]
 *      [1, 1, 2]
 *      [1, 2, 1]
 *      [2, 1, 1]
 *      [2, 2]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/combination-sum-iv/description
 * @date   2019-07-11 18:33:59
 */
public class L_0564_Combination_Sum_IV {

    /**
     * 标准动态规划
     * 
     * 或者按照 trie 单词查找树的思路
     * 
     *    1  1  1 ...
     *       1  2 ...
     *       1  4 ...
     *       2   
     *       ..
     * @author rays1
     *
     */
    static class Solution {
    
        int[] mem;
        
        public int backPackVI(int[] nums, int target) {
            mem = new int[target+1];
            return helper(nums, target);
        }
        
        public int helper(int[] nums, int target) {
            if (target == 0) return 1;
            else if (target < 0) return 0;
            if (mem[target] == 0) {
                for (int num : nums) {
                    mem[target] += helper(nums, target - num);
                }
            }
            return mem[target];
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
