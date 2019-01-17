package com.ray.LintCode.resolved;

import com.ray.LintCode.help.TreeNode;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0087_Remove_Node_in_Binary_Search_Tree {

    static class Solution {
        /*
         * @param root: The root of the binary search tree.
         * @param value: Remove the node with given value.
         * @return: The root of the binary search tree after removal.
         */
        public TreeNode removeNode(TreeNode root, int value) {
            if (root == null) return null;
            
            if (root.val == value) {
                if (root.right == null) return root.left;
                if (root.left  == null) return root.right;
                TreeNode n = min(root.right);
                root.right = removeMin(root.right);
                root.val = n.val;
            } else if (root.val < value) {
                root.right = removeNode(root.right, value);
            } else {
                root.left = removeNode(root.left, value);
            }
            return root;
        }
        
        private TreeNode min (TreeNode n) {
            if (n.left == null) return n;
            return min(n.left);
        }
        
        private TreeNode removeMin(TreeNode n) {
            if (n.left == null) return n.right;
            n.left = removeMin(n.left);
            return n;
        }
        
    }

}
