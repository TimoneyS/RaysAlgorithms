package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1-&gt;2-&gt;3-&gt;4-&gt;5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1-&gt;2-&gt;3-&gt;5.
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @since   2020-02-24 21:06:38
 */
public class L0019_Remove_Nth_Node_From_End_of_List {
    /**
     * 同两个结点，以前以后，保持 n 的距离，当前面的结点到终点，后面的结点正好到要删除的结点
     * 实际操作时，保证后一个结点正好到要删除的前一位，更方便删除
     */
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode front = head, behind = new ListNode(0);
            ListNode pile = behind;
            behind.next = head;
            for (int i = 0; i < n; i++) {
                front = front.next;
            }
            while (front != null) {
                behind = behind.next;
                front = front.next;
            }
            if (behind.next != null)
                behind.next = behind.next.next;
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
