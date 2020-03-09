package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Delete Node in a Linked List
 * -----------------------------------------------------------------------------
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 * Example:
 *      Example 1
 *      Input: head = [4,5,1,9], node = 5
 *      Output: [4,1,9]
 *      Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 *      Example 2
 *      Input: head = [4,5,1,9], node = 1
 *      Output: [4,5,9]
 *      Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *      Note:
 *      	The linked list will have at least two elements.
 *      	All of the nodes' values will be unique.
 *      	The given node will not be the tail and it will always be a valid node of the linked list.
 *      	Do not return anything from your function.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @since   2020-03-09 21:40:36
 */
public class L0237_Delete_Node_in_a_Linked_List {
    /**
     * 用下个结点的值，覆盖当前结点，然后删除下个结点
     */
    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
