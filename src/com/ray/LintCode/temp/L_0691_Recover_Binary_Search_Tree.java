package com.ray.LintCode.temp;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      In a binary search tree, (Only) two nodes are swapped. Find out these nodes and swap them. If there no node swapped, return original root of tree.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: {4,5,2,1,3}
 *      Output: {4,2,5,1,3}
 *      Explanation:
 *      Given a binary search tree:
 *          4
 *         / \
 *        5   2
 *       / \
 *      1   3
 *      return 
 *          4
 *         / \
 *        2   5
 *       / \
 *      1   3
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: {1,2,5,4,3}
 *      Output: {4,2,5,1,3}
 *      Given a binary search tree:
 *          1
 *         / \
 *        2   5
 *       / \
 *      4   3
 *      return 
 *          4
 *         / \
 *        2   5
 *       / \
 *      1   3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/recover-binary-search-tree/description
 * @date   2019-07-11 18:35:31
 */
public class L_0691_Recover_Binary_Search_Tree {


    /**
     * 按照 左 - 中 - 右 ， 的顺序遍历树，这样搜索树的元素会有序输出。
     * 问题可以转变为寻找有序数组中，被调换顺序的两个数字。
     * @author rays1
     *
     */
    static class Solution {
    
        public TreeNode bstSwappedNode(TreeNode root) {
            TreeNode pile = new TreeNode(Integer.MIN_VALUE);
            pile.right = root;
            prev = pile;
            
            help(root);
            if (errorNode != null) {
                int t = errorNode.val;
                errorNode.val = errorNode2.val;
                errorNode2.val = t;
            }
            return root;
        }
        
        TreeNode prev, errorNode, errorNode2;
        
        public void help(TreeNode root) {
            
            if (root == null) return;
            
            help(root.left);

            if (prev.val > root.val) {
                if (errorNode == null) {
                    errorNode = prev;
                    errorNode2 = root;
                } else {
                    errorNode2 = root;
                }
            } else {
                prev = root;
            }
            
            help(root.right);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
