package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @since   2020-02-24 22:36:23
 */
public class L0021_Merge_Two_Sorted_Lists {
    /**
     * 类似归并排序
     */
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode pile = new ListNode(0);
            ListNode n = pile;
            while (true) {
                if (l1 == null) {
                    n.next = l2;
                    break;
                } else if (l2 == null) {
                    n.next = l1;
                    break;
                } else if (l1.val < l2.val) {
                    n.next = l1;
                    n = n.next;
                    l1 = l1.next;
                    n.next = null;
                } else {
                    n.next = l2;
                    n = n.next;
                    l2 = l2.next;
                    n.next = null;
                }
            }
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
