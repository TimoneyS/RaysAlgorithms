package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Edit Distance
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * 	Insert a character
 * 	Delete a character
 * 	Replace a character
 *
 * Example:
 *      Example 1
 *      Input: word1 = horse, word2 = ros
 *      Output: 3
 *      Explanation: 
 *      horse -> rorse (replace 'h' with 'r')
 *      rorse -> rose (remove 'r')
 *      rose -> ros (remove 'e')
 *      Example 2
 *      Input: word1 = intention, word2 = execution
 *      Output: 5
 *      Explanation: 
 *      intention -> inention (remove 't')
 *      inention -> enention (replace 'i' with 'e')
 *      enention -> exention (replace 'n' with 'x')
 *      exention -> exection (replace 'n' with 'c')
 *      exection -> execution (insert 'u')
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/edit-distance/
 * @since   2020-02-28 23:20:45
 */
public class L0072_Edit_Distance {
    static class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[] mem = new int[n+1];
            for (int i = 0; i < mem.length; i++) mem[i] = i;
            for (int i = 1; i <= m; i++) {
                int pre = i;
                for (int j = 1; j <= n; j++) {
                    int t = pre;
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        pre = mem[j - 1];
                    else
                        pre = Math.min(Math.min(pre, mem[j]), mem[j - 1]) + 1;
                    mem[j-1] = t;
                }
                mem[n] = pre;
            }
            return mem[n];
        }
    }

    static class SolutionRec {
        int[][] mem;
        public int minDistance(String word1, String word2) {
            mem = new int[word1.length()+1][word2.length()+1];
            int rs = md(word1, word1.length()-1, word2, word2.length()-1);
            return rs;
        }

        private int md(String s1, int i, String s2, int j) {
            if (mem[i+1][j+1] == 0) {

                if (j < 0) {
                    mem[i+1][j+1] = i+1;
                } else if (i < 0) {
                    mem[i+1][j+1] = j+1;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    mem[i+1][j+1] = md(s1, i-1, s2, j-1);
                } else {
                    int ins_dis = md(s1, i, s2, j-1) + 1;
                    int rep_dis = md(s1, i-1, s2, j-1) + 1;
                    int del_dis = md(s1, i-1, s2, j) + 1;
                    mem[i+1][j+1] = Math.min(Math.min(ins_dis, rep_dis), del_dis);
                }
            }
            return mem[i+1][j+1];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
