package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Description :
 *   Given an array of `01`. You can flip `1` to be `0` or flip `0` to be `1`. 
 *   Find the minimum number of flipping steps so that the array meets the following rules:
 *   The back of `1` can be either` 1` or `0`, but` 0` must be followed by `0`.
 * 
 * Notice
 *   The length of the given array n <= 100000.
 * 
 * Example :
 *   **Example 1:**
 *   Input: [1,0,0,1,1,1]
 *   Output: 2
 *   Explanation: Turn two 0s into 1s.
 *   
 *   **Example 2:**
 *   Input: [1,0,1,0,1,0]
 *   Output: 2
 *   Explanation: Turn the second 1 and the third 1 into 0.
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/digital-flip/description
 * @date   2019-07-03 17:12:00
 */
public class L_0843_Digital_Flip {

    /**
     * 假设前 n-1 个数字：
     *      最后一个数字为 0 的最优步数为 f0
     *      最后一个数字为 1 的最优步数为 f1
     * 
     * 则第 n 个数字时:
     *      若数字为 0，则可以直接跟在任意数字后面，最优解为 min {f0, f1}
     *                 也可以翻转后跟在 1 后面，最优解为 f1 + 1
     *      若数字为 1，则可以跟在1后面，最优解为 f1
     *                 也可以翻转后跟在任意数字后面，最优解为 min{f0, f1} + 1
     * 因此 n 个数字时：
     *      最后一个数字为 0 的最优步数为 f0 = min {f0, f1} + nums[n]
     *      最后一个数字为 1 的最优步数为 f1 = f1 + 1 - nums[n]
     *      
     * 最终最优解为 min {f0, f1}     
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int flipDigit(int[] nums) {
            int f0 = nums[0], f1 = 1-nums[0];
            for (int i = 1; i < nums.length; i++) {
                f0 = Math.min(f0, f1) + nums[i];
                f1 = f1 + 1 - nums[i];
            }
            return Math.min(f0, f1);
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,0,0,0,1,0};
        
        Out.p(new Solution().flipDigit(nums));
        
    }

}
