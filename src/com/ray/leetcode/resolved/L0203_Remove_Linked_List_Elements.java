package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Remove Linked List Elements
 * -----------------------------------------------------------------------------
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *      Example 1
 *      Input:  1->2->6->3->4->5->6, val = 6
 *      Output: 1->2->3->4->5
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @since   2020-03-08 23:31:36
 */
public class L0203_Remove_Linked_List_Elements {
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode pile  = new ListNode(0);
            pile.next = head;
            head = pile;
            while (head != null && head.next != null) {
                if (head.next.val == val) head.next = head.next.next;
                else head = head.next;
            }
            return pile.next;
        }
    }
    
    public static void main(String[] args) {

        ListNode head = ListNode.parse("{5,5}");
        int val = 5;
        Out.p(new Solution().removeElements(head, val));
    }
}
