package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * House Robber III
 * -----------------------------------------------------------------------------
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the root. Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place forms a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example:
 *      Example 1
 *      Input: [3,2,3,null,3,null,1]
 *           3
 *          / \
 *         2   3
 *          \   \ 
 *           3   1
 *      Output: 7 
 *      Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *      Example 2
 *      Input: [3,4,5,1,3,null,1]
 *           3
 *          / \
 *         4   5
 *        / \   \ 
 *       1   3   1
 *      Output: 9
 *      Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/house-robber-iii/
 * @since   2020-03-12 22:44:28
 */
public class L0337_House_Robber_III {
    /**
     *
     * 如果选择了根结点，则左右子结点均不能选择
     * 如果选择左右某个结点，则根结点也无法选择
     *
     * 设 根结点为 root, 左右子结点为 l r
     *
     * 设
     *      S[n] 表示以n为根的子树，抢劫n的最大收获
     *      W[n] 表示以n为根的子树，不抢劫n的最大收获
     * 则
     *          S[root] = W[l] + W[r] + root.value
     *      W[root] = max { S[l], W[l] } + max {  S[r], W[r] }
     */
    static class Solution {

        public int rob(TreeNode root) {
            if (root == null) return 0;

            Map<TreeNode, Integer> S = new HashMap<>();
            Map<TreeNode, Integer> W = new HashMap<>();
            pre(root, S, W);
            return Math.max(S.get(root), W.get(root));
        }

        private void pre(TreeNode node, Map<TreeNode, Integer> S, Map<TreeNode, Integer> W) {
            if (node == null) return ;

            pre(node.left,  S, W);
            pre(node.right, S, W);

            int sl = node.left  == null ? 0 : S.get(node.left);
            int sr = node.right == null ? 0 : S.get(node.right);
            int wl = node.left  == null ? 0 : W.get(node.left);
            int wr = node.right == null ? 0 : W.get(node.right);

            S.put(node, wl + wr + node.val);
            W.put(node, Math.max(sl, wl) + Math.max(sr, wr));
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
