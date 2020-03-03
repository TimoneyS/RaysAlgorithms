package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Add Two Numbers
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * Example:
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * level : Medium
 *
 * @author ray
 * @link https://leetcode-cn.com/problems/add-two-numbers/
 * @since 2020-02-13 18:44:33
 */
public class L0002_Add_Two_Numbers {
    /**
     * 直接相加
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pile = new ListNode(0);
            ListNode n = pile;
            int r = 0;
            while (l1 != null || l2 != null || r > 0) {
                int num = val(l1) + val(l2) + r;
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
