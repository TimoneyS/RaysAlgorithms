package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Binary Tree Maximum Path Sum
 * -----------------------------------------------------------------------------
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3]
 *             1
 *            / \
 *           2   3
 *      Output: 6
 *      Example 2
 *      Input: [-10,9,20,null,null,15,7]
 *         -10
 *         / \
 *        9  20
 *          /  \
 *         15   7
 *      Output: 42
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @since   2020-03-04 22:34:31
 */
public class L0124_Binary_Tree_Maximum_Path_Sum {
    /**
     * 计算每个结点向下的最大路径，则
     *     dp[root] = max {root.val , root.val + dp[root.left], root.val + dp[root.right]}
     * 在计算的过程中，统计最大可能的路径和
     *      rs = Math.max(rs, dp[root], root.val+dp[root.left]+dp[root.right]))
     */
    static class Solution {
        private int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            mps(root);
            return max;
        }

        private int mps(TreeNode n) {
            if (n == null) return 0;
            int l = mps(n.left);
            int r = mps(n.right);
            int cm = Math.max(0, Math.max(l, r)) + n.val;
            max = Math.max(max, Math.max(cm, n.val+l+r));
            return cm;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
