package com.ray.LintCode.resolved;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0175_Invert_Binary_Tree {

    static class Solution {
        public void invertBinaryTree(TreeNode root) {
            
            if (root == null) return;
            
            TreeNode l = root.left;
            TreeNode r = root.right;
            
            invertBinaryTree(l);
            invertBinaryTree(r);
            
            root.right = l;
            root.left  = r;
            
        }
    }
    
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,2,3,4}");
        TreeNode.show(root);
        
        new Solution().invertBinaryTree(root);
        
        TreeNode.show(root);
    }

}
