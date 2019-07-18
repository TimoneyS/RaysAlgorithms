package com.ray.LintCode.temp;

import java.util.Stack;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Design an iterator over a binary search tree with the following rules:
 *      
 *      - Elements are visited in ascending order (i.e. an in-order traversal)
 *      - `next()` and `hasNext()` queries run in O(*1*) time in **average**.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```
 *      Input:  {10,1,11,#,6,#,12}
 *      Output:  [1, 6, 10, 11, 12]
 *      Explanation:
 *      The BST is look like this:
 *        10
 *        /\
 *       1 11
 *        \  \
 *         6  12
 *      You can return the inorder traversal of a BST [1, 6, 10, 11, 12]
 *      ```
 *      
 *      **Example 2**
 *      
 *      ``` plain
 *      Input: {2,1,3}
 *      Output: [1,2,3]
 *      Explanation:
 *      The BST is look like this:
 *        2
 *       / \
 *      1   3
 *      You can return the inorder traversal of a BST tree [1,2,3]
 *      ```
 *
 * 挑战：
 *      Extra memory usage O(h), h is the height of the tree.
 *      
 *      **Super Star**: Extra memory usage O(1)
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-search-tree-iterator/description
 * @date   2019-07-11 18:30:02
 */
public class L_0086_Binary_Search_Tree_Iterator {

    static class BSTIterator {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        /*
        * @param root: The root of binary tree.
        */
        public BSTIterator(TreeNode root) {
            pushToStack(root);
        }
        
        private void pushToStack(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /*
         * @return: True if there has next node, or false
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /*
         * @return: return next node
         */
        public TreeNode next() {
            TreeNode n = stack.pop();
            if (n.right != null)
                pushToStack(n.right);
            return n;
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(10);
        
        root.left = new TreeNode(1);
        root.right = new TreeNode(11);
        
        root.left.right = new TreeNode(6);        
        root.right.right = new TreeNode(12);
        
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
           TreeNode node = iterator.next();
           Out.p(node.val);
        } 
        
    }

}
