package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 判断树是否是完全二叉树。
 *
 * @author rays1
 *
 */
public class L_0726_Check_Full_Binary_Tree {

    static class Solution {
    
        public boolean isFullTree(TreeNode root) {
            if (root == null) return true;
            if (root == null || root.left == null && root.right == null || root.left != null && root.right != null) 
                return isFullTree(root.left) && isFullTree(root.right);
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,2,3}");
        Out.p(new Solution().isFullTree(root));
        
    }

}
