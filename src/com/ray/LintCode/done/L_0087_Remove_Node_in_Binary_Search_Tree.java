package com.ray.LintCode.done;

import com.ray.leetcode.util.TreeNode;

/**
 * 描述：
 *      给定一个二叉搜索树的根结点，移除指定结点。
 *      要求移除后还是一个合法的二叉树
 *
 * 难度： Hard
 *
 * @author rays1
 * @link   https://www.lintcode.cn/problem/remove-node-in-binary-search-tree/description
 * @since  2019-07-11 18:30:03
 */
public class L_0087_Remove_Node_in_Binary_Search_Tree {
    static class Solution {
        public TreeNode removeNode(TreeNode root, int value) {
            if (root == null) return null;
            if (root.val == value) {
                if (root.right == null) return root.left;
                if (root.left  == null) return root.right;
                int val = min(root.right).val;
                root.right = removeMin(root.right);
                root.val = val;
            } else if (root.val < value) {
                root.right = removeNode(root.right, value);
            } else {
                root.left = removeNode(root.left, value);
            }
            return root;
        }
        
        private TreeNode min(TreeNode n) {
            if (n.left == null) return n;
            return min(n.left);
        }
        
        private TreeNode removeMin(TreeNode n) {
            if (n.left == null) return n.right;
            n.left = removeMin(n.left);
            return n;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("{4,2,6,1,3,5,7}");
        TreeNode.show(root);
        new Solution().removeNode(root, 6);
        TreeNode.show(root);
    }
}
