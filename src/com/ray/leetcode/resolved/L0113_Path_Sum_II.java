package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II
 * -----------------------------------------------------------------------------
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 *      Example 1
 *      Given the below binary tree and sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \    / \
 *      7    2  5   1
 *      Return:
 *      [
 *         [5,4,11,2],
 *         [5,8,4,5]
 *      ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/path-sum-ii/
 * @since   2020-03-04 21:34:26
 */
public class L0113_Path_Sum_II {

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> rs = new ArrayList<>();
            helper(root, sum, new ArrayList<>(), rs);
            return rs;
        }

        private void helper(TreeNode root, int sum, List<Integer> base, List<List<Integer>> rs) {
            if (root == null) {
                return;
            } else if (root.left == null && root.right == null && root.val == sum) {
                ArrayList<Integer> l = new ArrayList<>(base);
                l.add(sum);
                rs.add(l);
            }
            base.add(root.val);
            helper(root.left, sum - root.val, base, rs);
            helper(root.right, sum - root.val, base, rs);
            base.remove(base.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
