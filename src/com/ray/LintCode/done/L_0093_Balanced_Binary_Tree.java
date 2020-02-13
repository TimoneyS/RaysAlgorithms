package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一颗二叉树，推断其高度是否平衡
 *      一个高度平衡的二叉树中每个节点的两个子树的深度相差不会超过1。
 *
 * 难度： Simple
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/balanced-binary-tree/description
 * @since  2019-07-11 18:30:08
 */
public class L_0093_Balanced_Binary_Tree {

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return maxDeep(root) != -1;
        }
        
        public int maxDeep(TreeNode n) {
            if (n == null) return 0;
            int dl = maxDeep(n.left);
            int dr = maxDeep(n.right);
            return (Math.abs(dr - dl) > 1 || dl == -1 || dr == -1) ? -1 : 1 + Math.max(dl, dr);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("{1,#,3,4,#,5}");
        TreeNode.show(root);
        Out.p(new Solution().isBalanced(root));
    }
}
