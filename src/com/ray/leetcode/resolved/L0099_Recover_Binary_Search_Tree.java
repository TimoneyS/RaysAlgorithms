package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Recover Binary Search Tree
 * -----------------------------------------------------------------------------
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Example:
 *      Example 1
 *      Input: [1,3,null,null,2]
 *         1
 *        /
 *       3
 *        \
 *         2
 *      Output: [3,1,null,null,2]
 *         3
 *        /
 *       1
 *        \
 *         2
 *      Example 2
 *      Input: [3,1,4,null,null,2]
 *        3
 *       / \
 *      1   4
 *         /
 *        2
 *      Output: [2,1,4,null,null,3]
 *        2
 *       / \
 *      1   4
 *         /
 *        3
 *      Follow up:
 *      	A solution using O(n) space is pretty straight forward.
 *      	Could you devise a constant space solution?
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @since   2020-03-03 23:11:42
 */
public class L0099_Recover_Binary_Search_Tree {
    /**
     * 按照 左 - 中 - 右 ， 的顺序遍历树，这样搜索树的元素会有序输出。
     * 问题可以转变为寻找有序数组中，被调换顺序的两个数字。
     */
    static class Solution {
        public void recoverTree(TreeNode root) {
            TreeNode pile = new TreeNode(Integer.MIN_VALUE);
            pile.right = root;
            prev = pile;
            help(root);
            if (errorNode != null) {
                int t = errorNode.val;
                errorNode.val = errorNode2.val;
                errorNode2.val = t;
            }
        }

        TreeNode prev, errorNode, errorNode2;

        public void help(TreeNode root) {
            if (root == null) return;
            help(root.left);
            if (prev.val > root.val) {
                if (errorNode == null) {
                    errorNode = prev;
                }
                errorNode2 = root;
            } else {
                prev = root;
            }
            help(root.right);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
