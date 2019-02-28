package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 在二叉树中寻找最大结点。
 *
 * @author rays1
 *
 */
public class L_0632_Binary_Tree_Maximum_Node {

    static class Solution {
    
        public TreeNode maxNode(TreeNode root) {
            if (root == null) return null;
            TreeNode max = root;
            TreeNode lmax = maxNode(root.left);
            TreeNode rmax = maxNode(root.right);
            if (lmax != null && lmax.val > max.val) max = lmax;
            if (rmax != null && rmax.val > max.val) max = rmax;            
            return max;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
