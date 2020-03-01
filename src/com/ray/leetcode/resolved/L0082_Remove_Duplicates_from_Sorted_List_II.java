package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example:
 *      Example 1
 *      Input: 1->2->3->3->4->4->5
 *      Output: 1->2->5
 *      Example 2
 *      Input: 1->1->1->2->3
 *      Output: 2->3
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @since   2020-03-01 22:57:23
 */
public class L0082_Remove_Duplicates_from_Sorted_List_II {
    /**
     * Definition for singly-linked list.
     * public static class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pile = new ListNode(Integer.MIN_VALUE);

            pile.next = head;

            head = pile;
            ListNode.show(head);
            while (head.next != null) {
                if (head.next == null || head.next.next == null)
                    break;

                if (head.next.next.next!= null && head.next.val == head.next.next.next.val) {
                    head.next = head.next.next;
                } else if (head.next.val == head.next.next.val) {
                    head.next = head.next.next.next;
                } else {
                    head = head.next;
                }
            }

            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
