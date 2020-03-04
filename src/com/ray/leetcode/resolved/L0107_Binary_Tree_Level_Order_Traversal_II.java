package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal II
 * -----------------------------------------------------------------------------
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @since   2020-03-04 21:25:02
 */
public class L0107_Binary_Tree_Level_Order_Traversal_II {

    static class Solution {

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> rs = new ArrayList<>();
            if (root != null)
                tree(root, 0, rs);
            return rs;
        }

        public void tree(TreeNode node, int level, List<List<Integer>> rs) {
            addToList(node, level, rs);
            if (node.left != null) tree(node.left, level + 1, rs);
            if (node.right != null) tree(node.right, level + 1, rs);
        }

        private void addToList(TreeNode node, int level, List<List<Integer>> rs) {
            List<Integer> list = null;
            if (level >= rs.size()) {
                list = new ArrayList<Integer>();
                rs.add(0, list);
            } else {
                list = rs.get(rs.size() - level - 1);
            }
            list.add(node.val);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
