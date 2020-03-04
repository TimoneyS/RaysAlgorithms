package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Balanced Binary Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example:
 *      Example 1
 *      Given the following tree [3,9,20,null,null,15,7]:
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 *      Return true.
 *      Example 2
 *      Given the following tree [1,2,2,3,3,null,null,4,4]:
 *             1
 *            / \
 *           2   2
 *          / \
 *         3   3
 *        / \
 *       4   4
 *      Return false.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/balanced-binary-tree/
 * @since   2020-03-04 21:30:49
 */
public class L0110_Balanced_Binary_Tree {

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return maxDeep(root) != -1;
        }

        int maxDeep(TreeNode n) {
            if (n == null) return 0;
            int dl = maxDeep(n.left);
            int dr = maxDeep(n.right);
            return (Math.abs(dr - dl) > 1 || dl == -1 || dr == -1) ? -1 : 1 + Math.max(dl, dr);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
