package com.ray.LintCode.done;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一个二叉搜索树和一个新的结点，将这个结点插入到树中
 *      保证这个树，还是一个合法的二叉搜索树
 *
 * 用例：
 *      Example 1:
 *      	Input: tree = {2,1,4,3}, node = 6
 *      	Output: {2,1,4,3,6}
 *      	Explanation:
 *      	  2             2
 *      	 / \           / \
 *      	1   4   -->   1   4
 *      	   /             / \ 
 *      	  3             3   6
 *
 * 挑战：
 *      Can you do it without recursion?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/insert-node-in-a-binary-search-tree/description
 * @since  2019-07-11 18:30:01
 */
public class L_0085_Insert_Node_in_a_Binary_Search_Tree {
    static class Solution {
        public TreeNode insertNode(TreeNode root, TreeNode node) {
            if (root == null) return node;
            if (root.val > node.val)
                root.left = insertNode(root.left, node);
            else
                root.right = insertNode(root.right, node);
            return root;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
