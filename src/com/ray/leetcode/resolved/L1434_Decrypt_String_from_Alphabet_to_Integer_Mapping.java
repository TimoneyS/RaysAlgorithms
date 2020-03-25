package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Decrypt String from Alphabet to Integer Mapping
 * -----------------------------------------------------------------------------
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 * 	Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * 	Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
 * Return the string formed after mapping.
 * It's guaranteed that a unique mapping will always exist.
 *
 * Example:
 *      Example 1
 *      Input: s = 10#11#12
 *      Output: jkab
 *      Explanation: j -> 10# , k -> 11# , a -> 1 , b -> 2.
 *      Example 2
 *      Input: s = 1326#
 *      Output: acz
 *      Example 3
 *      Input: s = 25#
 *      Output: y
 *      Example 4
 *      Input: s = 12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#
 *      Output: abcdefghijklmnopqrstuvwxyz
 *      Constraints:
 *      	1 <= s.length <= 1000
 *      	s[i] only contains digits letters ('0'-'9') and '#' letter.
 *      	s will be valid string such that mapping is always possible.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * @since   2020-03-25 22:04:27
 */
public class L1434_Decrypt_String_from_Alphabet_to_Integer_Mapping {
    static class Solution {
        public String freqAlphabets(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                    sb.append((char)('j' + (((s.charAt(i) - '0') * 10 + ((s.charAt(i+1) - '0') - 10)))));
                    i+=2;
                } else {
                    sb.append((char)('a' + (s.charAt(i) - '1')));
                }
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().freqAlphabets("10#11#12"));
    }
}
