package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * @author rays1
 *
 */
public class L_0071_Binary_Tree_Zigzag_Level_Order_Traversal {

    static class Solution {
        
        /**
         * @param root: A Tree
         * @return: Level order a list of lists of integer
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (level % 2 == 1)
                list.add(0, node.val);
            else
                list.add(node.val);
        }
        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        Out.p(new Solution().zigzagLevelOrder(root));
        
    }

}
