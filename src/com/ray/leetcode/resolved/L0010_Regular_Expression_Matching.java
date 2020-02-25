package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Regular Expression Matching
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Note:
 * 	s could be empty and contains only lowercase letters a-z.
 * 	p could be empty and contains only lowercase letters a-z, and characters like . or *.
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
 *      p = a*
 *      Output: true
 *      Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes aa.
 *      Example 3
 *      Input:
 *      s = ab
 *      p = .*
 *      Output: true
 *      Explanation: .* means zero or more (*) of any character (.).
 *      Example 4
 *      Input:
 *      s = aab
 *      p = c*a*b
 *      Output: true
 *      Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches aab.
 *      Example 5
 *      Input:
 *      s = mississippi
 *      p = mis*is*p*.
 *      Output: false
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/regular-expression-matching/
 * @since   2020-02-25 20:44:20
 */
public class L0010_Regular_Expression_Matching {
    /**
     * 正则表达式本身可以看作是一个状态机，每个字符是一个输入
     * 每次输入，正则表达式由几个状态变到另外几个状态
     * 当最终字符输入完毕，正则表达式的状态中包含结束状态，就能认为字符匹配
     * 那么正则表达式的核心就是构造状态变迁图
     *
     * 如正则表达式 ab*ac 的状态图如下：
     *           ↘-/
     *     -> a -> b -> c -> d
     *         \------↗
     *
     *  用字符串 abbcd 去匹配
     *  1.投入 a，a和第一个状态匹配，那么能够到达下面的状态
     *  [b, c]
     *  2.投入 b, b 在状态列表中，变迁为
     *  [b, c]
     *  3.投入 b，b 在状态列表中，变迁为
     *  [b, c]
     *  4.投入 c，c 在状态列表中，变迁为
     *  [d]
     *  4.投入 d，d 在状态列表种，变迁为
     *  [end]
     *
     *  如果用算法来解释，就是构造状态图，然后从起点开始，对状态做深度优先，无法变迁的状态是死路
     *  直到能够抵达终点
     */
    static class Solution {
        ArrayList<Integer>[] adj;
        char[] pattern;

        public boolean isMatch(String txt, String pat) {
            // 正则表达式相关
            pattern = pat.toCharArray();
            adj = new ArrayList[pat.length()+1];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < pat.length(); i ++) {
                if (pattern[i] == '*' && i != 0) {
                    adj[i].add(i+1);
                    adj[i-1].add(i);
                    adj[i].add(i-1);
                }
            }
            // 匹配方法
            Set<Integer> status = new HashSet<>();
            dfs(0, status);
            for (int i = 0; i < txt.length(); i++) {
                Set<Integer> newStatus = new HashSet<>();
                for (int v : status) {
                    if ( v < pattern.length && (txt.charAt(i) == pattern[v] || pattern[v] == '.')) {
                        newStatus.add(v+1);
                    }
                }
                status.clear();
                newStatus.forEach(v -> dfs(v, status));
            }
            return status.contains(pat.length());
        }

        private void dfs(int v, Set<Integer> status) {
            status.add(v);
            for (int w : adj[v]) {
                if (!status.contains(w)) {
                    dfs(w, status);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String txt = "acd";
        String pat = "ab*cd";
        Out.p(new Solution().isMatch(txt, pat));
    }
}
