package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个无重复的正整数数组，寻找可能的组合使其总和为给定的数字
 * 
 * 例如
 *      nums = [1, 2, 4], target = 4
 *      可能的组合如下
 *          [1, 1, 1, 1]
 *          [1, 1, 2]
 *          [1, 2, 1]
 *          [2, 1, 1]
 *          [2, 2]
 *          [4]
 * 
 * @author rays1
 *
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
