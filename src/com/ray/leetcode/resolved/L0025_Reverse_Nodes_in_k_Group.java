package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * Note:
 * 	Only constant extra memory is allowed.
 * 	You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @since   2020-02-26 19:08:48
 */
public class L0025_Reverse_Nodes_in_k_Group {
    /**
     * 边遍历，边翻转 k 个结点
     * 当翻转得结点不足k个时，便反向遍历恢复原顺序。
     */
    static class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode pile = new ListNode(0);
            pile.next = head;
            ListNode node = pile;
            while ((node = reverse(node, node.next, k)) != null);
            return pile.next;
        }

        /**
         * 翻转 K 个结点，返回翻转后得 tail 结点，也是下一次翻转的桩结点。
         */
        private ListNode reverse(ListNode pile, ListNode node, int k) {
            if (node == null || node.next == null) return null;
            ListNode tail = node;
            ListNode prev = node;
            ListNode next = node.next;
            int i = 1;
            while (i++ < k) {
                node = next;
                next = node.next;
                node.next = prev;
                prev = node;
                if (next == null) break;
            }
            if (i < k) {
                prev = next;
                next = node.next;
                do {
                    node.next = prev;
                    prev = node;
                    node = next;
                    next = node.next;
                } while (node != pile.next);
                return null;
            } else {
                pile.next = node;
                tail.next = next;
                return tail;
            }
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
