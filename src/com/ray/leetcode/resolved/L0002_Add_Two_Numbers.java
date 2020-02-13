package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *      Input: (2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
 *      Output: 7 -&gt; 0 -&gt; 8
 *      Explanation: 342 + 465 = 807.
 *
 * level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/add-two-numbers/
 * @since   2020-02-13 18:44:33
 */
public class L0002_Add_Two_Numbers {
    /**
     * 直接相加
     *
     */
     static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pile = new ListNode(0);
            ListNode n = pile;
            int r = 0;
            while (l1 != null || l2 != null || r > 0) {
                int num = val(l1) + val(l2)+r;
                r = num / 10;
                n.next = new ListNode(num % 10);
                n = n.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            return pile.next;
        }

        private int val(ListNode n) {
            return n == null ? 0 : n.val;
        }
    }

    public static void main(String[] args) {

         ListNode l1 = ListNode.parse("{1,2,3,4}");
         ListNode l2 = ListNode.parse("{1,2,3,4}");

        Out.p(new Solution().addTwoNumbers(l1, l2));
    }
}
