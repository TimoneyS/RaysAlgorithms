package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Reverse Linked List
 * -----------------------------------------------------------------------------
 * Reverse a singly linked list.
 *
 * Example:
 *      Example 1
 *      Input: 1->2->3->4->5->NULL
 *      Output: 5->4->3->2->1->NULL
 *      Follow up:
 *      A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-linked-list/
 * @since   2020-03-09 00:04:01
 */
public class L0206_Reverse_Linked_List {
    /**
     *  prev -> node -> next
     *  prev <- node <- next
     *  // 只需要翻转 node 和 prev 的链接，然后前进一格
     *  node.next = prev;
     *  // 下一次循环会处理下一个链
     *  prev = node
     *  node = next
     */
    static class Solution {
        public ListNode reverseList(ListNode node) {
            ListNode prev = null;
            ListNode next = null;
            while (node != null) {
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
