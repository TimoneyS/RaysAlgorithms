package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 * Input: 23
 * Output: [ad, ae, af, bd, be, bf, cd, ce, cf].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @since   2020-02-24 20:41:47
 */
public class L0017_Letter_Combinations_of_a_Phone_Number {
    /**
     * 拨号盘的界面如下
     * --------------------------
     * [1 ⚯  ] [2 abc ] [3 def ]
     * [4 ghi ] [5 jkl ] [6 mno ]
     * [7 pqrs] [8 tuv ] [9 wxyz]
     * [* +   ] [0 ︺  ] [⇧   # ]
     *----------------------------
     * 递归遍历即可
     */
    static class Solution {
        static char[][] dict = new char[][] {
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'}
        };

        public List<String> letterCombinations(String digits) {
            return helper(digits, 0, new char[digits.length()], new ArrayList<>());
        }

        private List<String> helper(String digits, int start, char[] chars, ArrayList<String> rs) {
            if (start == digits.length()) {
                if (chars.length != 0) {
                    rs.add(new String(chars));
                }
            } else {
                for (char c : dict[digits.charAt(start)-'2']) {
                    chars[start] = c;
                    helper(digits, start+1, chars, rs);
                }
            }
            return rs;
        }
    }

    public static void main(String[] args) {
        String digits = "";
        List<String> rs = new Solution().letterCombinations(digits);
        rs.sort(String::compareTo);
        Out.p(rs);
        Out.p(rs.size());
    }
}
