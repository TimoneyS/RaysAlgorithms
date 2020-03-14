package com.ray.LintCode.temp;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. Conversely, there is no node in a full binary tree, which has one child node. More information about full binary trees can be found [here](https://baike.baidu.com/item/%E6%BB%A1%E4%BA%8C%E5%8F%89%E6%A0%91).
 *      
 *      ```
 *      Full Binary Tree
 *            1
 *           / \
 *          2   3
 *         / \
 *        4   5
 *      
 *      Not a Full Binary Tree
 *            1
 *           / \
 *          2   3
 *         / 
 *        4   
 *      ```
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: {1,2,3}
 *      Output: true   
 *      Explanation:
 *            1
 *           / \
 *          2   3
 *      is a full binary tree.
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: {1,2,3,4}
 *      Output: false  
 *      Explanation:
 *            1
 *           / \
 *          2   3
 *         / 
 *        4   
 *      is not a full binary tree
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/check-full-binary-tree/description
 * @date   2019-07-11 18:35:50
 */
public class L_0726_Check_Full_Binary_Tree {

    static class Solution {
    
        public boolean isFullTree(TreeNode root) {
            if (root == null) return true;
            if (root == null || root.left == null && root.right == null || root.left != null && root.right != null) 
                return isFullTree(root.left) && isFullTree(root.right);
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
