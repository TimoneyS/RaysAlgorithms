package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, find its maximum depth.
 *      
 *      The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * 用例：
 *      **Example  1:**
 *       
 *      ```
 *      Input: tree = {}
 *      Output: 0
 *      Explanation: The height of empty tree is 0.
 *      ```
 *      **Example  2:**
 *      
 *      ```
 *      Input: tree = {1,2,3,#,#,4,5}
 *      Output: 3	
 *      Explanation: Like this:
 *         1
 *        / \                
 *       2   3                
 *          / \                
 *         4   5
 *      it will be serialized {1,2,3,#,#,4,5}
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-depth-of-binary-tree/description
 * @date   2019-07-11 18:30:29
 */
public class L_0097_Maximum_Depth_of_Binary_Tree {

    static class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: An integer
         */
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;        
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
