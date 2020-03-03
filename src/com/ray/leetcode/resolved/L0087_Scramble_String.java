package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Scramble String
 *
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = great:
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node gr and swap its two children, it produces a scrambled string rgeat.
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that rgeat is a scrambled string of great.
 * Similarly, if we continue to swap the children of nodes eat and at, it produces a scrambled string rgtae.
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that rgtae is a scrambled string of great.
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * Example:
 *      Example 1
 *      Input: s1 = great, s2 = rgeat
 *      Output: true
 *      Example 2
 *      Input: s1 = abcde, s2 = caebd
 *      Output: false
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/scramble-string/
 * @since   2020-03-01 23:34:20
 */
public class L0087_Scramble_String {
    /**
     * 字符串的生成的二叉树，其实是对字符串的一种递归划分，而交换左右结点，则是子划分区域之间的交换
     * 这种交换的本质只是原字符串字符顺序的变动，变动前后字符串之间的关系可以用 ~ 作记号
     *
     * 首先 s1 可以划分为两个子字符串
     *      s1 [****][...]
     * 那么通过 s1 变换为 s2 可能有两种情况
     *      1. s1 这两个子划分发生了交换
     *          s2  [...][****]
     *      2. s1 这两个子划分未发生交换
     *          s2  [****] [...]
     *
     * 因此可知 若要从 s1 变换为 s2 必然存在  sub(s1) ~ sub(s2)
     * 算法只要从 s1 首部开始寻找 子字符串 sub1 ，然后分别在s2从首部和尾部寻找 sub(s2)
     */
    static class Solution {

        public boolean isScramble(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            return search(s1, s2, 0, 0, s2.length());
        }

        private boolean search(String s1, String s2, int l1, int l2, int size) {
            Map<Character, Integer> left = new HashMap<>();
            Map<Character, Integer> right = new HashMap<>();
            int i = 0;
            while (i < size) {
                count(left, s1.charAt(l1 + i), 1);
                count(right, s1.charAt(l1 + i), 1);
                count(left, s2.charAt(l2 + i), -1);
                count(right, s2.charAt(l2 + size - i - 1), -1);

                if (i+1 == size) {
                    return size <= 3 && (left.size() == 0 || right.size() == 0);
                }

                if (left.size() == 0
                        && search(s1, s2, l1, l2, i+1) && search(s1, s2, l1+i+1, l2+i+1, size - i - 1)
                        || right.size() == 0
                        && search(s1, s2, l1, l2 + size - i - 1, i + 1) && search(s1, s2, l1 + i + 1, l2, size - i - 1)
                ) {
                    return true;
                }
                i++;
            }
            return false;
        }

        private void count(Map<Character, Integer> map, char c, int d) {
            d += map.getOrDefault(c, 0);
            if (d == 0) {
                map.remove(c);
            } else {
                map.put(c, d);
            }
        }
    }
    
    public static void main(String[] args) {
        String s1 = "attkadzge";
        String s2 = "getadzkta";
//        "attkadzge"
//        "getadzkta"

        Out.p(new Solution().isScramble(s1, s2));
    }
}
