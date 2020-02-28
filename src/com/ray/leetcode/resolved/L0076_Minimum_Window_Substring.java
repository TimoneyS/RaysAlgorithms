package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 * Input: S = ADOBECODEBANC, T = ABC
 * Output: BANC
 * Note:
 * 	If there is no such window in S that covers all characters in T, return the empty string .
 * 	If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/minimum-window-substring/
 * @since   2020-02-28 23:47:14
 */
public class L0076_Minimum_Window_Substring {
    /**
     * 用一个窗口在原始字符串上滑动，当窗口内的字符串不足够时，窗口向右延申。
     * 当字符串溢出时，窗口从左侧收缩。不断的记录最小的窗口值。
     *
     * 维护两个数组
     *
     * cc 当前字符计数
     * ct 目标字符计数
     *
     * 寻找一个子字符串，其计数结果 cc，对于每一个字符 c 均有 cc[c] > ct[c]
     * 目标是 寻找符合以上条件的最短的子字符串
     */
    static class Solution {
        public String minWindow(String source, String target) {
            Map<Character, Integer> base = new HashMap<>();
            Map<Character, Integer> curr = new HashMap<>();
            for (int i = 0; i < target.length(); i++) {
                base.put(target.charAt(i), base.getOrDefault(target.charAt(i), 0) + 1);
                curr.put(target.charAt(i), 0);
            }
            int l = 0, count = 0;
            String min = "";
            for (int i = 0; i < source.length(); i++) {
                char c = source.charAt(i);
                if (base.containsKey(c)) {
                    curr.put(c, curr.get(c)+1);
                    if (curr.get(c).equals(base.get(c))) {
                        count ++;
                    }
                    if (count == base.size()) {
                        l = cleanBehind(source, l, base, curr);
                        if (min.length() == 0 || min.length() > i-l+1) {
                            min = source.substring(l, i+1);
                        }
                    }
                }
            }
            return min;
        }

        private int cleanBehind(String source, int l, Map<Character, Integer> base, Map<Character, Integer> curr) {
            while (true) {
                char c = source.charAt(l);
                if (base.containsKey(c)) {
                    if (curr.get(c) > base.get(c)) {
                        curr.put(c, curr.get(c) - 1);
                    } else {
                        break;
                    }
                }
                l++;
            }
            return l;
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        Out.p(new Solution().minWindow(s, t));
    }
}
