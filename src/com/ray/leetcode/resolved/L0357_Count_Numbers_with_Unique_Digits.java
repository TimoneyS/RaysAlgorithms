package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Count Numbers with Unique Digits
 * -----------------------------------------------------------------------------
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 *      Example 1
 *      Input: 2
 *      Output: 91 
 *      Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
 *                   excluding 11,22,33,44,55,66,77,88,99
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * @since   2020-03-16 23:58:41
 */
public class L0357_Count_Numbers_with_Unique_Digits {
    /**
     * 可以将数字分为包含 0 和 不包含 0
     * 1 位数 :       9               10
     * 2 位数 :       9 * 9           91
     * 3 位数 :       9 * 9 * 8       648
     * 4 位数 :       9 * 9 * 8 * 7
     */
    static class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            int num = 9, sum = 10;
            for (int i = 1; i < n; i++) {
                num *= (9 - i + 1);
                n   += num;
            }
            return sum;
        }
    }
    
    public static void main(String[] args) {
        int n = 3;
        Out.p(new Solution().countNumbersWithUniqueDigits(n));
    }
}
