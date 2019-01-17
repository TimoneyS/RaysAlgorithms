package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.help.TreeNode;
import com.ray.io.Out;

/**
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * @author rays1
 *
 */
public class L_0069_Binary_Tree_Level_Order_Traversal {
    
    static class Solution {
        
        /**
         * @param root: A Tree
         * @return: Level order a list of lists of integer
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> rs = new ArrayList<>();
            if (root != null)
                tree(root, 0, rs);
            return rs;
        }
        
        public void tree(TreeNode node, int level, List<List<Integer>> rs) {
            addToList(node, level, rs);
            if(node.left != null) tree(node.left, level+1, rs);
            if(node.right != null) tree(node.right, level+1, rs);
        }
        
        public void addToList(TreeNode node, int level, List<List<Integer>> rs) {
            List<Integer> list = null;
            if (level >= rs.size()) {
                list = new ArrayList<Integer>();
                rs.add(level, list);
            } else {
                list = rs.get(level);
            }
            list.add(node.val);
        }
        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        Out.p(new Solution().levelOrder(root));
        
    }

}
