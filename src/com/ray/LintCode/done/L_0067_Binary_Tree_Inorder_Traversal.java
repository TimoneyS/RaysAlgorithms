package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      <p><span style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 30px;">Given a binary tree, return the&nbsp;</span><i style="box-sizing: border-box; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 30px;">inorder</i><span style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 30px;">&nbsp;traversal of its nodes&#39; values.</span></p>
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：{1,2,3}
 *      Output：[2,1,3]
 *      Explanation:
 *         1
 *        / \
 *       2   3
 *      it will be serialized {1,2,3}
 *      Inorder Traversal
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：{1,#,2,3}
 *      Output：[1,3,2]
 *      Explanation:
 *      1
 *       \
 *        2
 *       /
 *      3
 *      it will be serialized {1,#,2,3}
 *      Inorder Traversal
 *      ```
 *
 * 挑战：
 *      <p>Can you do it without recursion?</p>
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-inorder-traversal/description
 * @date   2019-07-11 18:29:44
 */
public class L_0067_Binary_Tree_Inorder_Traversal {

    /**
     * 递归的中序遍历
     */
    static class Solution {
        
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            if (root != null) tree(root, rs);
            return rs;
        }
        
        public void tree(TreeNode node, List<Integer> rs) {
            if (node.left != null) tree(node.left, rs);
            rs.add(node.val);
            if (node.right!= null) tree(node.right, rs);
        }
        
    }
    
    /**
     * 非递归的 中序遍历
     *
     */
    static class Solution2 {
        
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            
            addToStack(root, stack);
            while (!stack.isEmpty()) {
                TreeNode n = stack.pop();
                if (n.right != null) {
                    addToStack(n.right, stack);
                }
                rs.add(n.val);
            }
            return rs;
        }
        
        void addToStack(TreeNode node, Stack<TreeNode> stack) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        Out.p(new Solution2().inorderTraversal(root));
        
    }

}
