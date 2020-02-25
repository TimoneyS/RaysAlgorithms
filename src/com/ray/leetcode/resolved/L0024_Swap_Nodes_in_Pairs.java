package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @since   2020-02-24 23:27:42
 */
public class L0024_Swap_Nodes_in_Pairs {
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode pile = new ListNode(0);
            pile.next = head;
            ListNode n = pile;
            while ((n = swap(n)) != null);
            return pile.next;
        }

        /**
         * 交换 pile 之后的两个结点，返回交换后的最后一个结点
         */
        ListNode swap(ListNode pile) {
            if (pile == null || pile.next == null || pile.next.next == null) return null;
            ListNode n1 = pile.next;
            ListNode n2 = pile.next.next;
            pile.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            return n1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
