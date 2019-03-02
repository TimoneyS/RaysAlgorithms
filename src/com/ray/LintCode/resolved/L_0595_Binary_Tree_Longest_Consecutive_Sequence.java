package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 给定一颗二叉树，寻找最长的连续路径
 * 连续路径是从父结点到其任意子结点，不逆序。
 * 
 * @author rays1
 *
 */
public class L_0595_Binary_Tree_Longest_Consecutive_Sequence {

    /**
     * 每个结点统计一个值：从上延申来的长度
     * 
     * 全局最大长度 = max { 每个结点从上延申来的长度 }
     * 
     * @author rays1
     *
     */
    static class Solution {
        public int longestConsecutive(TreeNode root) {
            return helper(root, null, 0);
        }
        
        private int helper(TreeNode root, TreeNode parent, int maxLength) {
            if (root == null)  return 0;
            int length = (parent != null && parent.val + 1 == root.val) ? maxLength + 1 : 1;
            int left  = helper(root.left, root, length);
            int right = helper(root.right, root, length);
            return Math.max(length, Math.max(left, right));
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,#,2,#,4,#,5,#,6}");
        
        Out.p(new Solution().longestConsecutive(root));
        
    }

}