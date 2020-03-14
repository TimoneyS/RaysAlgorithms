package com.ray.LintCode.temp;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      For the given binary tree, return a **deep copy** of it.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```plain
 *      Input: {1,2,3,4,5}
 *      Output: {1,2,3,4,5}
 *      Explanation:
 *      The binary tree is look like this:
 *           1
 *         /  \
 *        2    3
 *       / \
 *      4   5
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```plain
 *      Input: {1,2,3}
 *      Output: {1,2,3}
 *      Explanation:
 *      The binary tree is look like this:
 *         1
 *       /  \
 *      2    3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/clone-binary-tree/description
 * @date   2019-07-11 18:32:18
 */
public class L_0375_Clone_Binary_Tree {

    static class Solution {
        public TreeNode cloneTree(TreeNode root) {
            if (root == null) return null;
            TreeNode copy = new TreeNode(root.val);
            copy.left = cloneTree(root.left);
            copy.right = cloneTree(root.left);            
            return copy;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
