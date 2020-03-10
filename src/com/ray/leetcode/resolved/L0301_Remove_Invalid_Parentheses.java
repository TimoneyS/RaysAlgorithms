package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Remove Invalid Parentheses
 * -----------------------------------------------------------------------------
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example:
 *      Example 1
 *      Input: ()())()
 *      Output: [()()(), (())()]
 *      Example 2
 *      Input: (a)())()
 *      Output: [(a)()(), (a())()]
 *      Example 3
 *      Input: )(
 *      Output: []
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/remove-invalid-parentheses/
 * @since   2020-03-11 00:05:51
 */
public class L0301_Remove_Invalid_Parentheses {
    /**
     * 合法的括号字符串
     *      从左向右遍历字符串，遇到左括号入栈，遇到右括号出栈。
     *      若遇到右括号栈空，或者字符串遍历完毕栈不为空，则字符串不合法。
     *
     * 从左向右遍历字符串，利用stack 保存括号信息，同时跳过需要删除的字符串。到抵达字符串结尾时，如果括号能够对应则时合法结果。
     * 返回最长的搜索结果。
     */
    static class Solution {

        public List<String> removeInvalidParentheses(String s) {

            List<Set<String>> dp = new ArrayList<>();

            dp.add(new HashSet<>());
            dp.get(0).add("");

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    dp.add(new HashSet<>());
                    for (int j = dp.size()-2; j >= 0; j--) {
                        for (String ss : dp.get(j)) {
                            add(dp.get(j+1), ss+'(');
                        }
                    }
                } else if (s.charAt(i) == ')') {
                    for (int j = 0; j < dp.size()-1; j++) {
                        for (String ss : dp.get(j+1)) {
                            add(dp.get(j), ss+')');
                        }
                    }
                } else {
                    for (int j = 0; j < dp.size(); j++) {
                        Set<String> set = dp.get(j);
                        dp.set(j, new HashSet<>());
                        for (String ss : set) {
                            dp.get(j).add(ss+s.charAt(i));
                        }
                    }
                }
            }
            return new ArrayList<>(dp.get(0));
        }

        private void add(Set<String> set, String string) {
            set.removeIf(s -> s.length() < string.length());
            set.add(string);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
