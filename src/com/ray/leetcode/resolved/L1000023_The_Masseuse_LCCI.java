package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * The Masseuse LCCI
 * -----------------------------------------------------------------------------
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * Example 1
 *      Input:  [1,2,3,1]
 *      Output:  4
 *      Explanation:  Accept request 1 and 3, total minutes = 1 + 3 = 4
 * Example 2
 *      Input:  [2,7,9,3,1]
 *      Output:  12
 *      Explanation:  Accept request 1, 3 and 5, total minutes = 2 + 9 + 1 = 12
 * Example 3
 *      Input:  [2,1,4,5,3,1,1,3]
 *      Output:  12
 *      Explanation:  Accept request 1, 3, 5 and 8, total minutes = 2 + 4 + 3 + 3 = 12
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/the-masseuse-lcci/
 * @since   2020-03-24 21:24:40
 */
public class L1000023_The_Masseuse_LCCI {
    static class Solution {
        public int massage(int[] nums) {
            int[] dp = new int[3];
            for (int i = 0; i < nums.length; i++)
                dp[i%3] = nums[i] + Math.max(dp[(i)%3], dp[(i+1)%3]);
            return Math.max(Math.max(dp[0], dp[1]), dp[2]);
        }
    }
    
    public static void main(String[] args) {
        int[] a = {2,1,4,5,3,1,1,3};
        Out.p(new Solution().massage(a));
    }
}
