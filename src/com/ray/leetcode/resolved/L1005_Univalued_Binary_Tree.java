package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Univalued Binary Tree
 * -----------------------------------------------------------------------------
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 *
 * Example:
 *      Example 1
 *      Input: [1,1,1,1,1,null,1]
 *      Output: true
 *      Example 2
 *      Input: [2,2,2,5,2]
 *      Output: false
 *      Note:
 *      	The number of nodes in the given tree will be in the range [1, 100].
 *      	Each node's value will be an integer in the range [0, 99].
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/univalued-binary-tree/
 * @since   2020-03-27 00:11:56
 */
public class L1005_Univalued_Binary_Tree {
    /**
     * Definition for a binary tree node.
     * public static class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;
            if (root.left != null && root.left.val != root.val
                    || root.right != null && root.right.val != root.val
            ) {
                return false;
            }
            return isUnivalTree(root.left) && isUnivalTree(root.right);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
