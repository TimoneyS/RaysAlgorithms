package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Ugly Number II
 * -----------------------------------------------------------------------------
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 *
 * Example:
 *      Example 1
 *      Input: n = 10
 *      Output: 12
 *      Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *      Note:  
 *      	1 is typically treated as an ugly number.
 *      	n does not exceed 1690.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/ugly-number-ii/
 * @since   2020-03-09 21:51:16
 */
public class L0264_Ugly_Number_II {
    /**
     * 丑数最终可以分解为 若干个 2 3 5 相乘。
     *
     * 因此下一个丑数必然是之前出现的某个丑数乘以 2 3 5 得到。
     * 比如最小的三个丑数是 1 2 3
     *
     * 下一个丑数必然是这三个数字乘以  2 3 5 的最小值
     *      1 * 2 = 2
     *      2 * 2 = 4
     *      3 * 2 = 6
     *
     * 最小数字是 2，这个丑数和已经有的重复，继续计算，因为 1 * 2 的数字已经使用过，因此需要变换乘法
     *      1 * 3 = 3
     *      2 * 2 = 4
     *      3 * 2 = 6
     * 最小数字是 3，这个丑数也重复，继续计算
     *      1 * 5 = 5
     *      2 * 2 = 4
     *      3 * 2 = 6
     * 最小数字是 4，因此下一个丑数是 4， 继续计算
     *      1 * 5 = 5
     *      2 * 3 = 6
     *      3 * 2 = 6
     * 最小数字是5，因此下一个丑数是5，同时1 * 5 已经使用，因此1已经无法产生新的丑数，下一个计算将用下一个丑数 4 代替，计算计算
     *      4 * 2 = 8
     *      2 * 3 = 6
     *      3 * 2 = 6
     * 如此重复即可。
     */
    static class Solution {
        public int nthUglyNumber(int k) {
            if (k < 7) return k;
            int t2 = 0, t3 = 0, t5 = 0;
            int[] result = new int[k];
            result[0] = 1;
            for (int i = 1; i < k; ++i) {
                result[i] = Math.min(result[t2] * 2, Math.min(result[t3] * 3, result[t5] * 5));
                if (result[i] == result[t2] * 2) t2++;
                if (result[i] == result[t3] * 3) t3++;
                if (result[i] == result[t5] * 5) t5++;
            }
            return result[k - 1];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
