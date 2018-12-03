package com.ray.LintCode;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author rays1
 *
 */
public class L_0067_Binary_Tree_Inorder_Traversal {

    static class Solution {
        
        /**
         * @param root: A Tree
         * @return: Inorder in ArrayList which contains node values.
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            if (root != null)
                tree(root, rs);
            return rs;
        }
        
        public void tree(TreeNode node, List<Integer> rs) {
            if (node.left != null) tree(node.left, rs);
            rs.add(node.val);
            if (node.right!= null) tree(node.right, rs);
        }
        
    }
    
    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        Out.p(new Solution().inorderTraversal(root));
        
    }
    
}
