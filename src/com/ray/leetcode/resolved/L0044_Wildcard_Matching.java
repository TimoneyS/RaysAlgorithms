package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashSet;

/**
 * Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * Note:
 * 	s could be empty and contains only lowercase letters a-z.
 * 	p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * Example:
 *      Example 1
 *      Input:
 *      s = aa
 *      p = a
 *      Output: false
 *      Explanation: a does not match the entire string aa.
 *      Example 2
 *      Input:
 *      s = aa
 *      p = *
 *      Output: true
 *      Explanation: '*' matches any sequence.
 *      Example 3
 *      Input:
 *      s = cb
 *      p = ?a
 *      Output: false
 *      Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *      Example 4
 *      Input:
 *      s = adceb
 *      p = *a*b
 *      Output: true
 *      Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring dce.
 *      Example 5
 *      Input:
 *      s = acdcb
 *      p = a*c?b
 *      Output: false
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/wildcard-matching/
 * @since   2020-02-26 23:08:05
 */
public class L0044_Wildcard_Matching {
    /**
     * 利用简化的正则表达式的原理，当出现匹配时，前进到下一个状态。
     * 当出现*时，同时保留当前状态和下一个状态
     */
    static class Solution {

        public boolean isMatch(String s, String p) {
            char[] ptn = p.toCharArray();

            HashSet<Integer> set = new HashSet<Integer>();
            HashSet<Integer> pre = new HashSet<Integer>();

            set.add(0);
            for (int i = 0; i < ptn.length; i++) {
                if (ptn[i] != '*') break;
                set.add(i+1);
            }

            for (int i = 0; i < s.length(); i++) {

                Out.p(set);

                for (Integer stat : set) {
                    if (stat >= ptn.length) continue;
                    if (ptn[stat] == s.charAt(i) || ptn[stat] == '?') {
                        pre.add(stat+1);
                    } else if (ptn[stat] == '*') {
                        pre.add(stat);
                        pre.add(stat+1);
                    }
                }

                set.clear();

                for (Integer stat : pre) {
                    set.add(stat);
                    if (stat >= ptn.length) continue;

                    if (ptn[stat] == '*') {
                        for (int j = stat; j < ptn.length; j++) {
                            if (ptn[j] != '*') break;
                            set.add(j+1);
                        }
                    }
                }

                pre.clear();
            }

            return set.contains(ptn.length);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
