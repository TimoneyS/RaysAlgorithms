package com.ray.LintCode.resolved;

import com.ray.LintCode.help.ListNode;

/**
 * 编写程序以找到两个单链表的交汇结点
 *
 * 如：
 * A:       a1 → a2
 *                  ↘
 *                   c1 → c2 → c3
 *                  ↗            
 * B:   b1 → b2 → b3
 *
 * 交汇的结点为 c1
 *
 * @author rays1
 *
 */
public class L_0380_Intersection_of_Two_Linked_Lists {

    /**
     * 过河拆桥的解法，先用一个结点再遍历的过程中，将所有的节点都指向桩节点
     * 第二个结点遍历时，发现的第一个指向桩的结点，就是交汇的结点。
     * 如果没有发现此类结点，则说明无交汇结点。
     * @author rays1
     *
     */
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode rs = null;
            
            ListNode pile = new ListNode(Integer.MAX_VALUE);
            ListNode prev = headA;
            while ((prev = headA) != null) {
                headA = headA.next;
                prev.next = pile;
            }
            
            while (headB != null && headB.next != null) {
                if (headB.next.val == pile.val) {
                    rs = headB;
                    break;
                }
                headB = headB.next;
            }
            
            return rs;
        }
    }

}
