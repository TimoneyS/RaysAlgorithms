package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * 一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 *
 * @author rays1
 *
 */
public class L_0093_Balanced_Binary_Tree {
    
    static class Solution {
        
        /**
         * @param root: The root of binary tree.
         * @return: True if this Binary tree is Balanced, or false.
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return maxDeep(root) != -1;
        }
        
        public int maxDeep(TreeNode n) {
            if (n == null) return 0;
            int v1 = 0, v2 = 0;
            if (n.left != null)
                v1 = maxDeep(n.left);
            if (n.right != null)
                v2 = maxDeep(n.right);
            
            if (Math.abs(v2 - v1) > 1 || v1 == -1 || v2 == -1) return -1;
            else return 1 + Math.max(v1, v2);
        }
        
    }

    static class TreeNode {
        
        public int      val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.left = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        root.left.right.right.left.left = new TreeNode(8);
        root.left.right.right.left.right = new TreeNode(9);
        
        Out.p(new Solution().maxDeep(root.left.right.right.left));
        
        
    }
    
}
