package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Greatest Common Divisor of Strings
 * -----------------------------------------------------------------------------
 * For strings S and T, we say T divides S if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 * Example:
 *      Example 1
 *      Input: str1 = ABCABC, str2 = ABC
 *      Output: ABC
 *      Example 2
 *      Input: str1 = ABABAB, str2 = ABAB
 *      Output: AB
 *      Example 3
 *      Input: str1 = LEET, str2 = CODE
 *      Output: 
 *      Note:
 *      	1 <= str1.length <= 1000
 *      	1 <= str2.length <= 1000
 *      	str1[i] and str2[i] are English uppercase letters.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 * @since   2020-03-12 22:48:48
 */
public class L1146_Greatest_Common_Divisor_of_Strings {
    /**
     * 和数字的最大公约数一致，显示用两个数字中较短的那个去把较长的那个截断
     * 叫截下来的部分循环处理。
     */
    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (str1.length() < str2.length()) return gcdOfStrings(str2, str1);
            if (str1.equals(str2)) return str1;
            if (str2.hashCode() == hash(str1, 0, str2.length())) {
                return gcdOfStrings(str1.substring(str2.length()), str2);
            } else {
                return "";
            }
        }

        private int hash(String str, int l, int r) {
            return str.substring(l, r).hashCode();
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
