package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一个二叉树，找出其最大深度。
 *      二叉树的深度为根节点到最远叶子节点的距离。
 * 难度： Simple
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/maximum-depth-of-binary-tree/description
 * @since  2019-07-11 18:30:29
 */
public class L_0097_Maximum_Depth_of_Binary_Tree {
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;        
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
