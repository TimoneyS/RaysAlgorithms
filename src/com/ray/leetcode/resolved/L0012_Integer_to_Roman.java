package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Integer to Roman
 *
 * Roman numerals are represented by seven different symbols:&nbsp;I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example,&nbsp;two is written as II&nbsp;in Roman numeral, just two one&#39;s added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * 	I can be placed before V (5) and X (10) to make 4 and 9.&nbsp;
 * 	X can be placed before L (50) and C (100) to make 40 and 90.&nbsp;
 * 	C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example:
 *      Example 1
 *      Input:&nbsp;3
 *      Output: III
 *      Example 2
 *      Input:&nbsp;4
 *      Output: IV
 *      Example 3
 *      Input:&nbsp;9
 *      Output: IX
 *      Example 4
 *      Input:&nbsp;58
 *      Output: LVIII
 *      Explanation: L = 50, V = 5, III = 3.
 *      Example 5
 *      Input:&nbsp;1994
 *      Output: MCMXCIV
 *      Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/integer-to-roman/
 * @since   2020-02-23 20:44:27
 */
public class L0012_Integer_to_Roman {
    /**
     * 罗马表示法
     *      I       1
     *      V       5
     *      X       10
     *      L       50
     *      C       100
     *      D       500
     *      M       1000
     * 罗马数字重复的次数表示数字的几倍
     * 左加右减：
     *      大数右侧的小数表示大数加小数，右侧小数的个数不超过 3 个
     *      大数左侧的小数表示大数减小数，左侧小数的个数只能有 1 个
     *          左侧的小数只能是 I X C，且不能跨越位制
     *
     * 数字的每个位置的表示是独立的, 如 1929 = 1000 + 900 + 20 + 9, 表示是
     *      1000    M
     *      900     CM
     *      20      XX
     *      9       IX
     * 拼凑可得  MCMXXIX
     */
    static class Solution {
        static Map<Integer, String> hash = new HashMap<>();
        static {
            hash.put(1,    "I");
            hash.put(5,    "V");
            hash.put(10,   "X");
            hash.put(50,   "L");
            hash.put(100,  "C");
            hash.put(500,  "D");
            hash.put(1000, "M");
        }

        int[] V = {1, 5, 10, 50, 100, 500, 1000};

        public String intToRoman(int n) {
            String rs = "";
            int num = n;
            for (int i = 0; i <= 4; i += 2) {
                int t = num % 10;
                num = num /10;
                rs = intToRoman(t, V[i+2], V[i+1], V[i]) + rs;
                if (num == 0) break;
            }
            if (n >= 1000) {
                for (int i = 0; i < n/1000; i ++) {
                    rs = hash.get(1000) + rs;
                }
            }
            return rs;
        }

        public String intToRoman(int t, int high, int mid, int low) {
            String rs = "";
            if (t >= 5) {
                rs = hash.get(mid);
                t -= 5;
            } else {
                high = mid;
            }
            String s1 = hash.get(high);
            String s2 = hash.get(low);
            if (t == 4) {
                return s2 + s1;
            } else {
                for (int i = 0; i < t; i ++) {
                    rs += s2;
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        int n = 9999;
        Out.p(new Solution().intToRoman(n));
    }
}
