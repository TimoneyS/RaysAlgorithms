package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Distinct Subsequences
 * -----------------------------------------------------------------------------
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, ACE is a subsequence of ABCDE while AEC is not).
 *
 * Example:
 *      Example 1
 *      Input: S = rabbbit, T = rabbit
 *      Output: 3
 *      Explanation:
 *      As shown below, there are 3 ways you can generate rabbit from S.
 *      (The caret symbol ^ means the chosen letters)
 *      rabbbit
 *      ^^^^ ^^
 *      rabbbit
 *      ^^ ^^^^
 *      rabbbit
 *      ^^^ ^^^
 *      Example 2
 *      Input: S = babgbag, T = bag
 *      Output: 5
 *      Explanation:
 *      As shown below, there are 5 ways you can generate bag from S.
 *      (The caret symbol ^ means the chosen letters)
 *      babgbag
 *      ^^ ^
 *      babgbag
 *      ^^    ^
 *      babgbag
 *      ^    ^^
 *      babgbag
 *        ^  ^^
 *      babgbag
 *          ^^^
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/distinct-subsequences/
 * @since   2020-03-04 21:36:14
 */
public class L0115_Distinct_Subsequences {
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
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
