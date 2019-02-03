package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 小偷又发现了新的盗窃场所，这个区域只有一个入口，称为“根”。
 * 除了根，每个房子只有一个父的房子。搜寻一番之后，聪明的小偷意识到“这个地方的所有房屋都形成了一棵二叉树”。
 * 如果两个直接连接的房子在同一个晚上被闯入，它将自动联系警方。
 * 确定小偷今晚可以抢劫的最大金额而不惊动警察。
 * 
 * 例如：
 *       [3]
 *       / \
 *      2   3
 *       \   \ 
 *       [3] [1]
 *  最大可以盗取的金额为  3 + 3 + 1 = 7
 * 
 *         3
 *        / \
 *      [4] [5]
 *      / \   \ 
 *     1   3   1
 *  最大可以盗取的金额为 4 + 5 = 9.
 * 
 * @author rays1
 *
 */
public class L_0535_House_Robber_III {

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
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int houseRobber3(TreeNode root) {
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
        
        TreeNode root = TreeNode.parse("{1,2,3,5,4}");
        
        Out.p(new Solution().houseRobber3(root));
        
    }

}
