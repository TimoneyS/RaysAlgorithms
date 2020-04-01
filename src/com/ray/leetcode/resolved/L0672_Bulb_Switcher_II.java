package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Bulb Switcher II
 * -----------------------------------------------------------------------------
 * There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.
 * Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:
 * 	Flip all the lights.
 * 	Flip lights with even numbers.
 * 	Flip lights with odd numbers.
 * 	Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
 *
 * Example:
 *      Example 1
 *      Input: n = 1, m = 1.
 *      Output: 2
 *      Explanation: Status can be: [on], [off]
 *      Example 2
 *      Input: n = 2, m = 1.
 *      Output: 3
 *      Explanation: Status can be: [on, off], [off, on], [off, off]
 *      Example 3
 *      Input: n = 3, m = 1.
 *      Output: 4
 *      Explanation: Status can be: [off, on, off], [on, off, on], [off, off, off], [off, on, on].
 *      Note: n and m both fit in range [0, 1000].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/bulb-switcher-ii/
 * @since   2020-03-31 22:22:21
 */
public class L0672_Bulb_Switcher_II {
    /**
     * 4 种开关则是
     *      全部
     *      奇数
     *      偶数
     *      3的倍数
     *
     * 观察一下可以发现，如果有 12盏灯，那么第 1 盏灯和第 7 盏灯的明暗一定是一致的，一次类推还有 2 8，3 9...
     * 那么无论经过哪些操作对于 1-6盏灯得到的每种状态，对应 7-12 盏灯中的每盏灯的状态都是确定
     * 因此题目只需要考虑 1 ~ 6 盏灯的情况即可
     */
    static class Solution {
        public int flipLights(int n, int m) {
            if (n == 0 || m == 0) return 1;
            if (n == 1) return 2;
            if (n == 2) return m == 1 ? 3 : 4;
            if (m == 1) return 4;
            return m == 2 ? 7 : 8;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
