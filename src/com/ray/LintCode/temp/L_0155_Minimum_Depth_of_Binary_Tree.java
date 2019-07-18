package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.LintCode.util.TreeNode;

/**
 * 描述：
 *      Given a binary tree, find its minimum depth.
 *      
 *      The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {}
 *      Output: 0
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  {1,#,2,3}
 *      Output: 3	
 *      Explanation:
 *      	1
 *      	 \ 
 *      	  2
 *      	 /
 *      	3    
 *      it will be serialized {1,#,2,3}
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input:  {1,2,3,#,#,4,5}
 *      Output: 2	
 *      Explanation: 
 *            1
 *           / \ 
 *          2   3
 *             / \
 *            4   5  
 *      it will be serialized {1,2,3,#,#,4,5}
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-depth-of-binary-tree/description
 * @date   2019-07-11 18:31:18
 */
public class L_0155_Minimum_Depth_of_Binary_Tree {

    static class Solution {
        /**
         * @param root: The root of binary tree
         * @return: An integer
         */
        public int minDepth(TreeNode root) {
            int deepth = 1;
            if (root == null) return 0;
            
            Queue<TreeNode> currQueue = new ArrayDeque<>();
            Queue<TreeNode> nextQueue = new ArrayDeque<>();
            
            currQueue.add(root);
            while (!currQueue.isEmpty()) {
                TreeNode node = currQueue.poll();
                
                if (node.left == null && node.right == null) {
                    break;
                }
                
                if (node.left != null) nextQueue.add(node.left);
                if (node.right != null) nextQueue.add(node.right);                
                
                if (currQueue.isEmpty()) {
                    Queue<TreeNode> temp = currQueue;
                    currQueue = nextQueue;
                    nextQueue = temp;
                    deepth ++;
                }
                
            }
            
            return deepth;

        }
        
    }

}
