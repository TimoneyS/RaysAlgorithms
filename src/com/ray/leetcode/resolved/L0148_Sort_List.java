package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Sort List
 * -----------------------------------------------------------------------------
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example:
 *      Example 1
 *      Input: 4->2->1->3
 *      Output: 1->2->3->4
 *      Example 2
 *      Input: -1->5->3->4->0
 *      Output: -1->0->3->4->5
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sort-list/
 * @since   2020-03-07 21:09:54
 */
public class L0148_Sort_List {
    /**
     * 在中点处切分链表，然后分别排序后归并。
     */
    static class Solution {
        public ListNode sortList(ListNode head) {
            return sort(head, null);
        }

        private ListNode sort(ListNode head, ListNode tail) {
            if (head == tail || head == null || head.next == null ) return head;

            ListNode t = head;
            ListNode mid = head;

            int l = 0, m = 0;
            while (t != tail) {
                if (m < l / 2) {
                    m = l / 2;
                    mid = mid.next;
                }
                l ++;
                t = t.next;
            }

            t = mid.next;
            mid.next = null;
            ListNode n1 = sort(head, mid);
            ListNode n2 = sort(t, tail);
            return merge(n1, n2);
        }

        /**
         * 归并
         */
        private ListNode merge(ListNode n1, ListNode n2) {
            ListNode pile = new ListNode(0);
            ListNode tail = pile;
            while (true) {
                if (n1 == null) {
                    tail.next = n2;
                    break;
                } else if (n2 == null) {
                    tail.next = n1;
                    break;
                } else {
                    if (n1.val < n2.val) {
                        tail.next = n1;
                        n1 = n1.next;
                    } else {
                        tail.next = n2;
                        n2 = n2.next;
                    }
                }
                tail = tail.next;
            }
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
