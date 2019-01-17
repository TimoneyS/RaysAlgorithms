package com.ray.LintCode.resolved;

import com.ray.LintCode.help.TreeNode;
import com.ray.io.Out;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * 给出一棵二叉树，寻找一条路径使其路径和最大
 * 路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
 * @author rays1
 *
 */
public class L_0094_Binary_Tree_Maximum_Path_Sum {
    
    static class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: An integer
         */
        private int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            mps(root);
            return max;
        }
        
        private int mps(TreeNode n) {
            if (n == null) return 0;
            
            int l = mps(n.left);
            int r = mps(n.right);
            int m = n.val;
            
            int cm = m;
            cm = Math.max(cm, l+m);
            cm = Math.max(cm, r+m);
            
            max = Math.max(max, cm);
            max = Math.max(max, m+l+r);
            
            return cm;
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode r = TreeNode.parse("{-2,-1,-3}");
        TreeNode.show(r);
        
        Out.p(new Solution().maxPathSum(r));
        
    }

}
