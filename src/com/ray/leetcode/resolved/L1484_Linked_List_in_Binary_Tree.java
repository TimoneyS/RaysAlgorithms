package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;
import com.ray.leetcode.util.TreeNode;

/**
 * Linked List in Binary Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree root and a linked list with head as the first node. 
 * Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
 * In this context downward path means a path that starts at some node and goes downwards.
 *
 * Example:
 *      Example 1
 *      Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 *      Output: true
 *      Explanation: Nodes in blue form a subpath in the binary Tree.  
 *      Example 2
 *      Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 *      Output: true
 *      Example 3
 *      Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 *      Output: false
 *      Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
 *      Constraints:
 *      	1 <= node.val <= 100 for each node in the linked list and binary tree.
 *      	The given linked list will contain between 1 and 100 nodes.
 *      	The given binary tree will contain between 1 and 2500 nodes.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 * @since   2020-04-01 22:12:37
 */
public class L1484_Linked_List_in_Binary_Tree {
    static class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            return dfs(head, root) || root != null && (isSubPath(head, root.left) || isSubPath(head, root.right));
        }

        public boolean dfs(ListNode head, TreeNode root) {
            if (head == null) return true;
            if (root == null || head.val != root.val) return false;
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
