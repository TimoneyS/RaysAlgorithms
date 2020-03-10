package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Diameter of Binary Tree
 * -----------------------------------------------------------------------------
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 *      Example 1
 *      Given a binary tree 
 *                1
 *               / \
 *              2   3
 *             / \     
 *            4   5    
 *      Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *      Note:
 *      The length of path between two nodes is represented by the number of edges between them.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @since   2020-03-10 23:56:03
 */
public class L0543_Diameter_of_Binary_Tree {
    /**
     * 最长的路径一定经过某个根节点，所以只要统计每个根节点的左右长路径即可
     */
    static class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            int[] rs = new int[1];
            deep(root, 0, rs);
            return rs[0];
        }

        int deep(TreeNode root, int base, int[] rs) {
            if (root == null) return base;
            int r = deep(root.left, 0, rs);
            int l = deep(root.right, 0, rs);
            rs[0] = Math.max(l + r, rs[0]);
            return Math.max(l, r) + 1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
