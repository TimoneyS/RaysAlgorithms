package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * You can assume that you can always reach the last index.
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/jump-game-ii/
 * @since   2020-02-27 22:12:05
 */
public class L0045_Jump_Game_II {
    /**
     * 贪心算法
     *
     * 从 i 开始，可以跳跃的下一个位置 j 在 i - i + nums[i] 之间
     * 这里使用贪心选择，选择 nums[j] + [j] 最大的位置作为跳跃位置
     * 因为如果有其他的位置 k 能够到达终点，那么 k 必然要经过下一个位置 k1
     * 那么因为 j+nums[j] >= k + nums[k] ，所以 j 也能够到达下一个位置 k1
     *
     */
    static class Solution {
        public int jump(int[] nums) {
            int max1 = 0;
            int max2 = nums[0];
            int jump = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > max1) {
                    jump ++;
                    max1 = max2;
                }
                max2 = Math.max(max2, i+nums[i]);
            }
            return jump;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
