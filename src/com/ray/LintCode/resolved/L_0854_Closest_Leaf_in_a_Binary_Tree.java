package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * Given a binary tree where every node has a unique value, and a target key k.
    Find the value of the nearest leaf node to target k in the tree. If there are multiple cases, you should follow these priorities:
The leaf node is in the left subtree of the node with k;
The leaf node is in the right subtree of the node with k;
The leaf node is not in the subtree of the node with k.
 *
 *
 * @author rays1
 *
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
        
        TreeNode root = TreeNode.parse("{1,2,3,4,5,6,7}");
        int k = 1;
        TreeNode.show(root);
        
        
        Out.p(new Solution().findClosestLeaf(root, k));
        
    }

}
