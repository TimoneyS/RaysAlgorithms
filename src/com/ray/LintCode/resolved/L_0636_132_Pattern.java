package com.ray.LintCode.resolved;

import java.util.Stack;

import com.ray.io.Out;

/**
 * n 个数字的序列 a1, a2, ... , an
 * 132模式是一个子序列 ai aj ak 符合以下规律  i < j < k 且 ai < ak < aj
 * 设计算法检查序列是否存在 132 模式
 * n will be less than 20,000.
 * @author rays1
 *
 */
public class L_0636_132_Pattern {
    
    /**
     * 对于任意的 a3 = nums[i]
     *      a2 可以取 nums[i] 右则的小于 nums[i] 的最大值
     *      a1 可以取 nums[i] 左则的小于 a2 的值即可
     * 
     * 在处理到 nums[i] 时，如果已经找到了一对 a3 和 a2 此时有三种情况
     *      nums[i] < a2 找到
     *      nums[i] > a3 则可以更新 a3 和 a2 的值， a3 替换为  nums[i]，a2 可以替换为栈中的小于nums[i] 的最大值
     *      nums[i] 在 a2 和 a3 之间，插入栈中备用
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean find132pattern(int[] nums) {
            
            int a2 = Integer.MIN_VALUE;
            Stack<Integer> s = new Stack<>();
            
            for (int i = nums.length - 1; i >= 0; i--) {
                
                if (nums[i] < a2) return true;
                
                while (!s.isEmpty() && nums[i] > s.peek()) {
                    a2 = s.pop();
                }
                s.push(nums[i]);

            }
            
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1, 6, 5, 9};
        
        Out.p(new Solution().find132pattern(nums));
        
    }

}
