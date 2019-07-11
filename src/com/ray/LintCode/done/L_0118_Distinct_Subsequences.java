package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two strings `S` and `T`. Count the number of distinct subsequences of `S` which equals `T`.
 *      
 *      A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, `"ACE"` is a subsequence of `"ABCDE"` while `"AEC"` is not)
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: S = "rabbbit", T = "rabbit"
 *      Output: 3
 *      Explanation: You could remove any 'b' in S, so there are 3 ways to get T.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: S = "abcd", T = ""
 *      Output: 1
 *      Explanation: There is only 1 way to get T - remove all chars in S.
 *      ```
 *
 * 挑战：
 *      Do it in O($n^2$) time and O(n) memory. 
 *      
 *      O($n^2$) memory is also acceptable if you do not know how to optimize memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/distinct-subsequences/description
 * @date   2019-07-11 18:30:47
 */
public class L_0118_Distinct_Subsequences {

    static class Solution {
        public int numDistinct(String S, String T) {
            int[] mem = new int[T.length()+1];
            mem[0] = 1;
            for (int i = 0; i < S.length(); i++) {
                for (int j = T.length(); j > 0; j--) {
                    if (j-1 <= i && S.charAt(i) == T.charAt(j-1))
                        mem[j] = mem[j] + mem[j - 1];
                }
            }
            return mem[T.length()];
        }
    }

    static class SolutionRec {

        int[][] mem;

        public int numDistinct(String S, String T) {
            mem = new int[S.length()][T.length()];
            for (int i = 0; i < S.length(); i++)
                for (int j = 0; j < T.length(); j++)
                    mem[i][j] = -1;
            return nd(S, S.length() - 1, T, T.length() - 1);
        }

        private int nd(String s, int si, String t, int ti) {
            if (ti < 0)
                return 1;
            if (si < 0 || si < ti)
                return 0;
            if (mem[si][ti] == -1) {
                mem[si][ti] = nd(s, si - 1, t, ti);
                if (s.charAt(si) == t.charAt(ti))
                    mem[si][ti] += nd(s, si - 1, t, ti - 1);
            }
            return mem[si][ti];
        }
    }

    public static void main(String[] args) {
        String S = "rrraa";
        String T = "rra";
        Out.p(new Solution().numDistinct(S, T));
    }

}
