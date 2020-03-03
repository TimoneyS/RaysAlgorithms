package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Reverse Linked List II
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *      Example 1
 *      Input: 1->2->3->4->5->NULL, m = 2, n = 4
 *      Output: 1->4->3->2->5->NULL
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @since   2020-03-03 22:22:09
 */
public class L0092_Reverse_Linked_List_II {
    /**
     * 先遍历找到中断点
     *      翻转部分会有 head -> ... -> tail
     *
     * 完全翻转后，需要将中断点链接新链的head
     * 中新链的尾部需要链接原链的后续部分。
     */
    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) return head;

            int index = 0;
            ListNode oldHead  = head;
            ListNode cut  = null;   // 开始翻转的中断点
            ListNode tail = null;
            ListNode prev = null;
            ListNode next = null;

            while (index < m) {
                index ++;

                tail = head;
                cut  = prev;

                next = head.next;
                prev = head;
                head = next;
            }

            while (index < n) {
                index ++;
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            tail.next = head;

            if (cut == null) {
                return prev;
            } else {
                cut.next = prev;
                return oldHead;
            }
        }
    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
