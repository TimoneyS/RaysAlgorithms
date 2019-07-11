package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：{1,2,3}
 *      Output：[1,2,3]
 *      Explanation:
 *         1
 *        / \
 *       2   3
 *      it will be serialized {1,2,3}
 *      Preorder traversal
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：{1,#,2,3}
 *      Output：[1,2,3]
 *      Explanation:
 *      1
 *       \
 *        2
 *       /
 *      3
 *      it will be serialized {1,#,2,3}
 *      Preorder traversal
 *      ```
 *
 * 挑战：
 *      Can you do it without recursion?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-preorder-traversal/description
 * @date   2019-07-11 18:29:43
 */
public class L_0066_Binary_Tree_Preorder_Traversal {

    static class Solution {
        /**
         * @param root: A Tree
         * @return: Preorder in ArrayList which contains node values.
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            
            List<Integer> rs = new ArrayList<>();
            Stack<TreeNode> stack =  new Stack<>();
            
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) continue;
                rs.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        Out.p(new Solution().preorderTraversal(root));
        
    }

}
