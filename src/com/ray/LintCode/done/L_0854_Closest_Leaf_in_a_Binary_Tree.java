package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree **where every node has a unique value**, and a target key `k`. 
 *      
 *      Find the value of the nearest leaf node to target `k` in the tree. If there are multiple cases, you should follow these priorities:
 *      
 *      1. The leaf node is in the left subtree of the node with `k`;
 *      2. The leaf node is in the right subtree of the node with `k`;
 *      3. The leaf node is not in the subtree of the node with `k`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {1, 3, 2}, k = 1
 *      Output: 3
 *      Explanation:
 *          1
 *         / \
 *        3   2
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: {1}, k = 1
 *      Output: 1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/closest-leaf-in-a-binary-tree/description
 * @date   2019-07-11 18:37:38
 */
public class L_0854_Closest_Leaf_in_a_Binary_Tree {


    static class Solution {

        public int findClosestLeaf(TreeNode root, int k) {
            Map<TreeNode, TreeNode> backMap = new HashMap<>();  // store all edges that trace node back to its parent
            Queue<TreeNode> queue = new LinkedList<>();         // the queue used in BFS
            Set<TreeNode> visited = new HashSet<>();            // store all visited nodes
            
            // DFS: search for node whoes val == k
            TreeNode kNode = dfs(root, k, backMap);
            queue.add(kNode);
            visited.add(kNode);

            // BFS: find the shortest path
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return curr.val;
                }
                if (curr.left != null && visited.add(curr.left)) {
                    queue.add(curr.left);
                }
                if (curr.right != null && visited.add(curr.right)) {
                    queue.add(curr.right);
                }
                if (backMap.containsKey(curr) && visited.add(backMap.get(curr))) { // go alone the back edge
                    queue.add(backMap.get(curr));
                }
            }
            return -1; // never hit
        }

        private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
            if (root.val == k) return root;
            
            TreeNode node;
            if (root.left != null) {
                backMap.put(root.left, root); // add back edge
                if ((node = dfs(root.left, k, backMap)) != null) return node;
            }
            
            if (root.right != null) {
                backMap.put(root.right, root); // add back edge
                if ((node = dfs(root.right, k, backMap)) != null) return node;
            }
            return null;
        }

    }
    
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
