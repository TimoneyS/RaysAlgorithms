package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Unique Binary Search Trees
 * -----------------------------------------------------------------------------
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *      Input: 3
 *      Output: 5
 *      Explanation:
 *      Given n = 3, there are a total of 5 unique BST's:
 *         1         3     3      2      1
 *          \       /     /      / \      \
 *           3     2     1      1   3      2
 *          /     /       \                 \
 *         2     1         2                 3
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @since   2020-03-03 22:53:15
 */
public class L0096_Unique_Binary_Search_Trees {
    static class Solution {

        public int numTrees(int n) {
            int[] mem = new int[n+1];
            return nt(n, mem);
        }

        public int nt(int n, int[] mem) {
            if (n <= 1) return 1;
            if (n == 2) return 2;

            if (mem[n] == 0) {
                int count = 0;
                for (int i = 0; i < n; i ++) {
                    int l = nt(i, mem);
                    int r = nt(n-1-i, mem);
                    count += l*r;
                }
                mem[n] = count;
            }
            return mem[n];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
