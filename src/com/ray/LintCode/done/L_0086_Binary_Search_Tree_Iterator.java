package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      设计一个二叉搜索树，需要遵从如下的规则：
 *          - 元素以顺序访问
 *          - next() 和 hasNext() 需要 O(1) 的时间复杂度
 *
 * 用例：
 *      **Example 1**
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
 *
 *      **Example 2**
 *      Input: {2,1,3}
 *      Output: [1,2,3]
 *      Explanation:
 *      The BST is look like this:
 *        2
 *       / \
 *      1   3
 *      You can return the inorder traversal of a BST tree [1,2,3]
 *
 * 挑战：
 *      Extra memory usage O(h), h is the height of the tree.
 *      **Super Star**: Extra memory usage O(1)
 *
 * 难度： Hard
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/binary-search-tree-iterator/description
 * @since  2019-07-11 18:30:02
 */
public class L_0086_Binary_Search_Tree_Iterator {
    /**
     *
     */
    static class BSTIterator {

        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushToStack(root);
        }
        
        private void pushToStack(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public TreeNode next() {
            TreeNode n = stack.pop();
            if (n.right != null)
                pushToStack(n.right);
            return n;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("{10,1,11,6,12}");
        TreeNode.show(root);
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
           TreeNode node = iterator.next();
           Out.p(node.val);
        } 
    }
}
