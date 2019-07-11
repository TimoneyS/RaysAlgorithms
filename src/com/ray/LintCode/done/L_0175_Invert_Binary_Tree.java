package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;

/**
 * 描述：
 *      Invert a binary tree.Left and right subtrees exchange.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {1,3,#}
 *      Output: {1,#,3}
 *      Explanation:
 *      	  1    1
 *      	 /  =>  \
 *      	3        3
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: {1,2,3,#,#,4}
 *      Output: {1,3,2,#,4}
 *      Explanation: 
 *      	
 *            1         1
 *           / \       / \
 *          2   3  => 3   2
 *             /       \
 *            4         4
 *      ```
 *
 * 挑战：
 *      Do it in recursion is acceptable, can you do it without recursion?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/invert-binary-tree/description
 * @date   2019-07-11 18:31:35
 */
public class L_0175_Invert_Binary_Tree {


    static class Solution {
        public void invertBinaryTree(TreeNode root) {
            
            if (root == null) return;
            
            TreeNode l = root.left;
            TreeNode r = root.right;
            
            invertBinaryTree(l);
            invertBinaryTree(r);
            
            root.right = l;
            root.left  = r;
            
        }
    }
    
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,2,3,4}");
        TreeNode.show(root);
        
        new Solution().invertBinaryTree(root);
        
        TreeNode.show(root);
    }

}
