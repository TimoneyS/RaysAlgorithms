package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束
 *      （路径和为两个节点之间所在路径上的节点权值之和）
 * 用例：
 *      Example 1:
 *      	Input:  For the following binary tree:
 *            1
 *           / \
 *          2   3
 *      	Output: 6
 * 难度： Medium
 *
 * @author rays1
 * @link   https://www.lintcode.cn/problem/binary-tree-maximum-path-sum/description
 * @since  2019-07-11 18:30:09
 */
public class L_0094_Binary_Tree_Maximum_Path_Sum {

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
        TreeNode r = TreeNode.parse("{-2,-1,-3}");
        TreeNode.show(r);
        Out.p(new Solution().maxPathSum(r));
    }
}
