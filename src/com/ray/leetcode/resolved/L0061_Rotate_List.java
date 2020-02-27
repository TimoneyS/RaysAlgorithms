package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Rotate List
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example:
 *      Example 1
 *      Input: 1->2->3->4->5->NULL, k = 2
 *      Output: 4->5->1->2->3->NULL
 *      Explanation:
 *      rotate 1 steps to the right: 5->1->2->3->4->NULL
 *      rotate 2 steps to the right: 4->5->1->2->3->NULL
 *      Example 2
 *      Input: 0->1->2->NULL, k = 4
 *      Output: 2->0->1->NULL
 *      Explanation:
 *      rotate 1 steps to the right: 2->0->1->NULL
 *      rotate 2 steps to the right: 1->2->0->NULL
 *      rotate 3 steps to the right: 0->1->2->NULL
 *      rotate 4 steps to the right: 2->0->1->NULL
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/rotate-list/
 * @since   2020-02-27 22:35:52
 */
public class L0061_Rotate_List {
    /**
     * 用前后相距k的两个结点begin, front，在链表上前进。
     * 当 front到达尾部时，则表明需要从 begin 之后截断链表，将之后的部分移动到 head 之前。
     */
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode behind = head, front = head;

            for (int i = 1; i <= k; i++) {
                front = front.next;
                if (front == null) {
                    front = head;
                }
            }

            while (front.next != null) {
                behind = behind.next;
                front = front.next;
            }

            front.next = head;
            head = behind.next;
            behind.next = null;

            return head;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
