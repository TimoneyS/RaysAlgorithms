package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 *
 * 给定一个字符串 S 和 T ,计算S中等于T的子序列数量 Given S = "rabbbit", T = "rabbit", return 3.
 *
 * @author rays1
 *
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
