package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Reorder List
 * -----------------------------------------------------------------------------
 * Given a singly linked list L: L0→L1→&hellip;→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→&hellip;
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *      Example 1
 *      Given 1->2->3->4, reorder it to 1->4->2->3.
 *      Example 2
 *      Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reorder-list/
 * @since   2020-03-07 20:56:31
 */
public class L0143_Reorder_List {
    /**
     * 先统计结点的个数是奇数还是偶数，
     *  然后递归处理，每层递归向上层递归返回对应结点，并处理下层递归的返回
     *
     *  递归到 1，向下，此时链表 [1]->2->3->4->5->6
     *      递归到 2，向下，此时链表 1->[2]->3->4->5->6
     *          递归到 3，向下，此时链表 1->2->[3]->4->5->6
     *          此时结点数是偶数，因此3需要和后一个结点链接，返回 5
     *      递归到 2 后处理，2 和返回值链接，返回 5 的下一个结点 6，此时链表 1->2->5->3->4 6
     *  递归到 1 后处理，1 和返回值链接，此时链表 1->6->2->5->3->4
     */
    static class Solution {
        public void reorderList(ListNode head) {
            if (head != null) {
                int l = 0;
                for (ListNode n = head; n != null; n = n.next) {
                    l++;
                }
                reorder(head, l);
            }
        }

        private ListNode reorder(ListNode node, int l) {
            if (l == 1) {
                ListNode t = node.next;
                node.next = null;
                return t;
            } else if (l == 0) {
                return node;
            } else {
                ListNode nextNode = reorder(node.next, l-2);
                ListNode rs = nextNode.next;
                if (nextNode != node.next) {
                    nextNode.next = node.next;
                    node.next = nextNode;
                } else {
                    nextNode.next = null;
                }
                return rs;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
