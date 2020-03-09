package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Palindrome Linked List
 * -----------------------------------------------------------------------------
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example:
 *      Example 1
 *      Input: 1->2
 *      Output: false
 *      Example 2
 *      Input: 1->2->2->1
 *      Output: true
 *      Follow up:
 *      Could you do it in O(n) time and O(1) space?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/palindrome-linked-list/
 * @since   2020-03-09 21:38:07
 */
public class L0234_Palindrome_Linked_List {
    /**
     * 利用快慢结点，慢结点在前进的同时逆转链表。
     */
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head;
            ListNode pprev = null;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                pprev = prev;
                prev  = slow;
                slow  = slow.next;
                fast = fast.next.next;
                prev.next = pprev;
            }
            if (fast != null) {
                slow = slow.next;
            }
            boolean rs = true;
            while (prev != null && slow != null) {
                if (prev.val != slow.val) {
                    rs = false;
                    break;
                }
                prev = prev.next;
                slow = slow.next;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
