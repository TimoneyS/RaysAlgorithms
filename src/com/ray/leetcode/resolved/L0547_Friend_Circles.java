package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Friend Circles
 * -----------------------------------------------------------------------------
 * 
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      [[1,1,0],
 *       [1,1,0],
 *       [0,0,1]]
 *      Output: 2
 *      Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. The 2nd student himself is in a friend circle. So return 2.
 *      Example 2
 *      Input: 
 *      [[1,1,0],
 *       [1,1,1],
 *       [0,1,1]]
 *      Output: 1
 *      Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 *      Note:
 *      N is in range [1,200].
 *      M[i][i] = 1 for all students.
 *      If M[i][j] = 1, then M[j][i] = 1.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/friend-circles/
 * @since   2020-04-08 22:04:02
 */
public class L0547_Friend_Circles {
    static class Solution {
        public int findCircleNum(int[][] M) {

            int[] parent = new int[M.length];
            for (int i = 0; i < M.length; i ++) {
                parent[i] = i;
            }

            for (int i = 0; i < M.length; i ++) {
                for (int j = i + 1; j < M.length; j ++) {
                    if (M[i][j] == 1) {
                        connect(parent, i, j);
                    }
                }
            }
            int rs = 0;
            for (int i = 0;i < M.length; i ++) {
                if (parent[i] == i) rs ++;
            }
            return rs;
        }

        private void connect(int[] parent, int i, int j) {
            int pi = parent(parent, i);
            int pj = parent(parent, j);
            parent[pj] = pi;
        }

        private int parent(int[] parent, int i) {
            if (parent[i] != i) {
                parent[i] = parent(parent, parent[i]);
            }
            return parent[i];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
