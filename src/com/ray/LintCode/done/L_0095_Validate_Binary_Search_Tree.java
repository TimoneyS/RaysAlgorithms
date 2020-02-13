package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 *      一棵BST定义为：
 *          节点的左子树中的值要严格小于该节点的值。
 *          节点的右子树中的值要严格大于该节点的值。
 *          左右子树也必须是二叉查找树。
 *          一个节点的树也是二叉查找树。
 *
 * 用例：
 *      **Example 1:**
 *      Input:  {-1}
 *      Output：true
 *      Explanation：
 *      For the following binary tree（only one node）:
 *      	      -1
 *      This is a binary search tree.
 *
 *      **Example 2:**
 *      Input:  {2,1,4,#,#,3,5}
 *      Output: true
 *      For the following binary tree:
 *      	  2
 *      	 / \
 *      	1   4
 *      	   / \
 *      	  3   5
 *      This is a binary search tree.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/validate-binary-search-tree/description
 * @since  2019-07-11 18:30:10
 */
public class L_0095_Validate_Binary_Search_Tree {
    /**
     * 直接遍历，记录遍历的前一个结点值
     */
    static class Solution {
        Integer prev = null;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            boolean rs = isValidBST(root.left);
            if (prev != null)
                rs &= (root.val > prev);
            if (rs) {
                prev = root.val;
                rs = isValidBST(root.right);
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{10,5,#,1,6}");
        TreeNode.show(root);

        Out.p(new Solution().isValidBST(root));
        
    }

}
