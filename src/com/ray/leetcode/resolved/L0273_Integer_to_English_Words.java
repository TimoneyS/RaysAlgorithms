package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Integer to English Words
 * -----------------------------------------------------------------------------
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 2^31 - 1.
 *
 * Example:
 *      Example 1
 *      Input: 123
 *      Output: One Hundred Twenty Three
 *      Example 2
 *      Input: 12345
 *      Output: Twelve Thousand Three Hundred Forty Five
 *      Example 3
 *      Input: 1234567
 *      Output: One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
 *      Example 4
 *      Input: 1234567891
 *      Output: One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/integer-to-english-words/
 * @since   2020-03-09 23:55:47
 */
public class L0273_Integer_to_English_Words {
    /**
     * 英文表示数字
     *         1                                                                                    One
     *         11                                                                                 Eleven
     *        111                                                                    "One Hundred Eleven"
     *       1111                                                       "One Thousand One Hundred Eleven"
     *      11111                                                    "Eleven Thousand One Hundred Eleven"
     *     111111                                        "One Hundred Eleven Thousand One Hundred Eleven"
     *    1111111                            "One Million One Hundred Eleven Thousand One Hundred Eleven"
     *   11111111                         "Eleven Million One Hundred Eleven Thousand One Hundred Eleven"
     *  111111111             "One Hundred Eleven Million One Hundred Eleven Thousand One Hundred Eleven"
     * 1111111111 "One Billion One Hundred Eleven Million One Hundred Eleven Thousand One Hundred Eleven"
     */
    static class Solution {
        static Map<Integer, String> map = getMap();
        static Map<Integer, String> getMap() {
            Map<Integer, String> map = new HashMap<>();
            map.put(0, "Zero"); map.put(1, "One"); map.put(2, "Two"); map.put(3, "Three");
            map.put(4, "Four"); map.put(5, "Five"); map.put(6, "Six");
            map.put(7, "Seven"); map.put(8, "Eight"); map.put(9, "Nine");
            map.put(10, "Ten"); map.put(11, "Eleven"); map.put(12, "Twelve");
            map.put(13, "Thirteen"); map.put(14, "Fourteen"); map.put(15, "Fifteen");
            map.put(16, "Sixteen"); map.put(17, "Seventeen"); map.put(18, "Eighteen");
            map.put(19, "Nineteen"); map.put(20, "Twenty"); map.put(30, "Thirty"); map.put(40, "Forty"); map.put(50, "Fifty");
            map.put(60, "Sixty"); map.put(70, "Seventy"); map.put(80, "Eighty"); map.put(90, "Ninety");
            map.put(100, "Hundred");
            map.put(1000, "Thousand");
            map.put(1000000, "Million");
            map.put(1000000000, "Billion");
            return map;
        }

        public String numberToWords(int num) {
            if (num <= 20) return map.get(num);
            StringBuilder sb = new StringBuilder();
            int[] rate = {1000000000, 1000000, 1000};
            for (int r : rate) {
                if (num >= r) {
                    n3(num/r, sb).append(' ').append(map.get(r));
                    num %= r;
                }
            }
            n3(num, sb);
            return sb.toString();
        }

        private StringBuilder n3(int n, StringBuilder sb) {
            if (n >= 100) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(map.get(n/100)).append(' ').append(map.get(100));
                n %= 100;
            }
            if (n != 0) {
                if (sb.length() > 0) sb.append(' ');
                if (n <= 20 || n % 10 == 0) {
                    sb.append(map.get(n));
                } else {
                    sb.append(map.get(n / 10 * 10)).append(' ').append(map.get(n % 10));
                }
            }
            return sb;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().numberToWords(1000));
    }
}
