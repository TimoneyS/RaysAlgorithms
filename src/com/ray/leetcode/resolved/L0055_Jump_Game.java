package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Example:
 *      Example 1
 *      Input: [2,3,1,1,4]
 *      Output: true
 *      Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *      Example 2
 *      Input: [3,2,1,0,4]
 *      Output: false
 *      Explanation: You will always arrive at index 3 no matter what. Its maximum
 *                   jump length is 0, which makes it impossible to reach the last index.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/jump-game/
 * @since   2020-02-27 22:27:53
 */
public class L0055_Jump_Game {
    static class Solution {
        public boolean canJump(int[] A) {
            if (A.length <= 1) return true;

            int n = A.length;
            int cursor = n-1;
            for (int i = n-2; i >= 0; i--) {
                if (A[i]+i >= cursor) {
                    cursor = i;
                }
            }
            return cursor == 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
