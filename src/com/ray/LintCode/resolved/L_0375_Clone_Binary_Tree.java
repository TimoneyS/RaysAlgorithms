package com.ray.LintCode.resolved;

/**
 * 深拷贝二叉树
 *
 * @author rays1
 *
 */
public class L_0375_Clone_Binary_Tree {

    static class Solution {
        public TreeNode cloneTree(TreeNode root) {
            if (root == null) return null;
            TreeNode copy = new TreeNode(root.val);
            copy.left = cloneTree(root.left);
            copy.right = cloneTree(root.left);            
            return copy;
        }
    }
    
    public static void main(String[] args) {
        
    }

}
