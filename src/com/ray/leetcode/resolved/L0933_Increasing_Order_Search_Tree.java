package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Increasing Order Search Tree
 * -----------------------------------------------------------------------------
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 *
 * Example:
 *      Example 1
 *      Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *             5
 *            / \
 *          3    6
 *         / \    \
 *        2   4    8
 *       /        / \ 
 *      1        7   9
 *      Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *       1
 *        \
 *         2
 *          \
 *           3
 *            \
 *             4
 *              \
 *               5
 *                \
 *                 6
 *                  \
 *                   7
 *                    \
 *                     8
 *                      \
 *                       9  
 *      Constraints:
 *      	The number of nodes in the given tree will be between 1 and 100.
 *      	Each node will have a unique integer value from 0 to 1000.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @since   2020-04-08 22:02:10
 */
public class L0933_Increasing_Order_Search_Tree {
    static class Solution {
        public TreeNode increasingBST(TreeNode root) {
            TreeNode rs = new TreeNode(0);
            helper(root, rs);
            return rs.right;
        }

        private TreeNode helper(TreeNode root, TreeNode rs) {
            if (root == null) return rs;

            rs = helper(root.left, rs);

            root.left = null;
            rs.right = root;
            rs = rs.right;

            return helper(root.right, rs);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
