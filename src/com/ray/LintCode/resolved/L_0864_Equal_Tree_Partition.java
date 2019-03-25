package com.ray.LintCode.resolved;

import java.util.HashSet;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees
 *  which have the equal sum of values after removing exactly one edge on the original tree.
 *
 * @author rays1
 * @url    
 */
public class L_0864_Equal_Tree_Partition {

    static class Solution {
    
        public boolean checkEqualTree(TreeNode root) {
            
            TreeNode.show(root);
            
            HashSet<Integer> set = new HashSet<>();
            int rs = root != null ? root.val : 0; 
            rs += sum(root.left, set);
            rs += sum(root.right, set);
            
            return rs % 2 == 0 && set.contains(rs/2);
        }
        
        int sum(TreeNode root, HashSet<Integer> set) {
            if (root == null) return 0;
            int rs = sum(root.left, set) + sum(root.right, set) + root.val;
            set.add(rs);
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().checkEqualTree(TreeNode.parse("{5,10,10,#,#,2,3}")));
        
    }

}
