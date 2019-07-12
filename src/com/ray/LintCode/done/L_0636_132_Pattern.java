package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a sequence of n integers a1, a2, ..., an, a `132` pattern is a subsequence ai, aj, ak such that `i` < `j` < `k` and `ai` < `ak` < `aj`. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 *      
 *      `n` will be less than `20,000`.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: nums = [1, 2, 3, 4] 
 *      Output: False 
 *      Explanation:
 *      There is no 132 pattern in the sequence.
 *      ```
 *      Example 2:
 *      ```
 *      Input: nums = [3, 1, 4, 2] 
 *      Output: True 
 *      Explanation:
 *      There is a 132 pattern in the sequence: [1, 4, 2].
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/132-pattern/description
 * @date   2019-07-11 18:34:37
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
        
        Out.p(new Solution());
        
    }

}
