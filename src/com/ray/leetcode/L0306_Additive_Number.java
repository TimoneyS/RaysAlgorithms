package com.ray.leetcode;

import com.ray.io.Out;

/**
 * Additive Number
 * -----------------------------------------------------------------------------
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Example:
 *      Example 1
 *      Input: 112358
 *      Output: true
 *      Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
 *                   1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *      Example 2
 *      Input: 199100199
 *      Output: true
 *      Explanation: The additive sequence is: 1, 99, 100, 199. 
 *                   1 + 99 = 100, 99 + 100 = 199
 *      Constraints:
 *      	num consists only of digits '0'-'9'.
 *      	1 <= num.length <= 35
 *      Follow up:
 *      How would you handle overflow for very large input integers?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/additive-number/
 * @since   2020-03-11 00:48:16
 */
public class L0306_Additive_Number {

    static class Solution {
        public boolean isAdditiveNumber(String num) {
            if (num.length() < 3) return false;
            return helper(num, 0, java.math.BigInteger.valueOf(-1), java.math.BigInteger.valueOf(-1), java.math.BigInteger.valueOf(-1));
        }

        boolean helper(String num, int start, java.math.BigInteger prev, java.math.BigInteger pprev, java.math.BigInteger ppprev) {
            if (start >= num.length()) return ppprev.compareTo(java.math.BigInteger.ZERO) >= 0;
            java.math.BigInteger curr = java.math.BigInteger.ZERO;
            for (int i = start; i < (num.charAt(start) == '0' ? start + 1 : num.length()); i++) {
                curr = curr.multiply(java.math.BigInteger.TEN).add(java.math.BigInteger.valueOf(num.charAt(i) - '0'));
                if (pprev.compareTo(java.math.BigInteger.ZERO) < 0) {
                    // 如果还没有达到三个数字，就计算用当前数字能否匹配
                    if (helper(num, i + 1, curr, prev, pprev))
                        return true;
                } else if (pprev.add(prev).equals(curr)) {
                    // 如果当前的数字和前两个数字和相等了，那就只能用当前数字往下继续
                    return helper(num, i + 1, curr, prev, pprev);
                } else if (pprev.add(prev).compareTo(curr) < 0) {
                    // 如果当前的数字已经大于前两个数字了，那么无法继续
                    return false;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        String num = "111";
        Out.p(new Solution().isAdditiveNumber(num));
    }
}
