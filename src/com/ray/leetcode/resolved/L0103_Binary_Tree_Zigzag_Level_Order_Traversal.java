package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Zigzag Level Order Traversal
 * -----------------------------------------------------------------------------
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @since   2020-03-03 23:22:53
 */
public class L0103_Binary_Tree_Zigzag_Level_Order_Traversal {
    static class Solution {
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
        Out.p(new Solution());
    }
}
