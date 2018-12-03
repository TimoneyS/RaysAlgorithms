package com.ray.LintCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

            Queue<TreeNode> queue1 = new ArrayDeque<>();
            Queue<TreeNode> queue2 = new ArrayDeque<>();
            if (root != null)
                queue1.add(root);
            boolean flag = true;
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                Queue<TreeNode> curr = null;
                Queue<TreeNode> next = null;
                if (flag) {
                    curr = queue1;
                    next = queue2;
                } else {
                    curr = queue2;
                    next = queue1;
                }

                flag = !flag;
                next.clear();
                
                List<Integer> l = new ArrayList<Integer>();
                while (!curr.isEmpty()) {
                    TreeNode n = curr.poll();
                    l.add(n.val);
                    if (n.left != null) next.add(n.left);
                    if (n.right != null) next.add(n.right);
                }
                rs.add(l);
                
            }            
            
            return rs;
        }
        
    }
    
    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}
