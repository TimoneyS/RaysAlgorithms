package com.ray.LintCode.temp;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary search tree ([See Definition](http://www.lintcode.com/problem/validate-binary-search-tree/ "BST")) and a node in it, find the in-order successor of that node in the BST.
 *      
 *      If the given node has no in-order successor in the tree, return `null`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {1,#,2}, node with value 1
 *      Output: 2
 *      Explanation:
 *        1
 *         \
 *          2
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: {2,1,3}, node with value 1
 *      Output: 2
 *      Explanation: 
 *          2
 *         / \
 *        1   3
 *      ```
 *      
 *      [Binary Tree Representation](https://www.lintcode.com/help/binary-tree-representation/)
 *
 * 挑战：
 *      O(h), where h is the height of the BST.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/inorder-successor-in-bst/description
 * @date   2019-07-11 18:33:12
 */
public class L_0448_Inorder_Successor_in_BST {

    /**
     * 设树为 root，给定的结点为 p
     * 
     * 中序遍历的顺序是 左 - 中 - 右
     * 实验 1，使用中序遍历进行遍历，访问到结点p时，再进行一次遍历则结束。
     * 
     * 实验 2，考察具体情况
     *      存在更简便的解法，不需要完整的遍历树，以后研究
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        TreeNode rs, prev;
        
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            tree(root, p);
            return rs;
        }
        
        public void tree(TreeNode root, TreeNode p) {
            if (rs != null || root == null) return;
            tree(root.left, p);
            if (prev == p) {
                Out.p(root.val + " ");
                rs = root;
                prev = root;
            } else {
                prev = root;
                tree(root.right, p);
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
