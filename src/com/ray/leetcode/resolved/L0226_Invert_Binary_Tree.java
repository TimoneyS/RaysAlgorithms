package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Invert Binary Tree
 * -----------------------------------------------------------------------------
 * Invert a binary tree.
 *
 * Example:
 *      Example 1
 *      Input:
 *           4
 *         /   \
 *        2     7
 *       / \   / \
 *      1   3 6   9
 *      Output:
 *           4
 *         /   \
 *        7     2
 *       / \   / \
 *      9   6 3   1
 *      Trivia:
 *      This problem was inspired by this original tweet by Max Howell:
 *      Google: 90% of our engineers use the software you wrote (Homebrew), but you can&rsquo;t invert a binary tree on a whiteboard so f*** off.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/invert-binary-tree/
 * @since   2020-03-09 21:29:12
 */
public class L0226_Invert_Binary_Tree {
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode t = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(t);
            return root;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
