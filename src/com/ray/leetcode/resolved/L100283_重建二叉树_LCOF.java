package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * 重建二叉树 LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @since   2020-04-08 22:02:46
 */
public class L100283_重建二叉树_LCOF {
    static class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (inorder.length == 0)
                return null;
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
            if (r2 < l2 || r1 < l1)
                return null;

            TreeNode node = new TreeNode(preorder[l1]);

            if (r2 == l2)
                return node;

            int i = l2;
            while (i <= r2) {
                if (inorder[i] == preorder[l1])
                    break;
                i++;
            }

            node.left =  buildTree(preorder, inorder, l1+1,       l1-l2+i,   l2,     i-1);
            node.right = buildTree(preorder, inorder, l1-l2+i+1,  r1,         i+1,   r2);

            return node;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
