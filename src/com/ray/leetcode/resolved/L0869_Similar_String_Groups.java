package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Similar String Groups
 * -----------------------------------------------------------------------------
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.
 * For example, tars and rats are similar (swapping at positions 0 and 2), and rats and arts are similar, but star is not similar to tars, rats, or arts.
 * Together, these form two connected groups by similarity: {tars, rats, arts} and {star}.  Notice that tars and arts are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 * We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?
 *
 * Example:
 *      Example 1
 *      Input: A = ["tars","rats","arts","star"]
 *      Output: 2
 *      Constraints:
 *      	1 <= A.length <= 2000
 *      	1 <= A[i].length <= 1000
 *      	A.length * A[i].length <= 20000
 *      	All words in A consist of lowercase letters only.
 *      	All words in A have the same length and are anagrams of each other.
 *      	The judging time limit has been increased for this question.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/similar-string-groups/
 * @since   2020-04-08 22:06:32
 */
public class L0869_Similar_String_Groups {
    static class Solution {
        public int numSimilarGroups(String[] A) {
            int[] parent = new int[A.length];
            for (int i = 0; i < A.length; i ++) {
                parent[i] = i;
            }
            for (int i = 0; i < A.length; i ++) {
                for (int j = i+1; j < A.length; j ++) {
                    if (isSimilar(A[i], A[j])) {
                        int pi = parent(parent, i);
                        int pj = parent(parent, j);
                        if (pi != pj) {
                            parent[pj] = pi;
                        }
                    }
                }
            }
            int rs = 0;
            for (int i = 0;i < A.length; i ++) {
                if (parent[i] == i) rs ++;
            }
            return rs;
        }

        private int parent(int[] parent, int i) {
            if (parent[i] != i) {
                parent[i] = parent(parent, parent[i]);
            }
            return parent[i];
        }

        private boolean isSimilar(String a, String b) {
            if (a.length() != b.length()) return false;
            int c = 0;
            for (int i = 0; i < a.length(); i ++) {
                if (a.charAt(i) != b.charAt(i) && (++c) > 2) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
