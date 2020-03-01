package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example:
 *      Example 1
 *      Input: 1->1->2
 *      Output: 1->2
 *      Example 2
 *      Input: 1->1->2->3->3
 *      Output: 1->2->3
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @since   2020-03-01 22:55:28
 */
public class L0083_Remove_Duplicates_from_Sorted_List {
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
            while (head.next != null) {
                if (head.val == head.next.val) {
                    head.next = head.next.next;
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
