package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * @author rays1
 *
 */
public class L_0095_Validate_Binary_Search_Tree {

    
    static class Solution {
        
        Integer prev = null;
        
        /**
         * @param root: The root of binary tree.
         * @return: True if the binary tree is BST, or false
         */
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            
            boolean rs = true;
            
            rs &= isValidBST(root.left);
            if (prev != null)
                rs &= (root.val > prev);
            prev = root.val;
            rs &= isValidBST(root.right);
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{10,5,#,1,6}");        
        TreeNode.show(root);
        
        Out.p(new Solution().isValidBST(root));
        
    }

}
