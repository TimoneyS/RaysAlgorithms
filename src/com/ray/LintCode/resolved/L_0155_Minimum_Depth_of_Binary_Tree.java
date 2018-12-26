package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 *
 * @author rays1
 *
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
