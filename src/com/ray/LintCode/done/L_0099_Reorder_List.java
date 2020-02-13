package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一个单链表L: L0→L1→…→Ln-1→Ln,
 *      重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 *      必须在不改变节点值的情况下进行原地操作。
 * 用例：
 *      Example 1:
 *      	Input:  1->2->3->4->5->6->7->8->null
 *      	Output: 1->8->2->7->3->6->4->5->null
 * 挑战：
 *      你能在不改变节点值的情况下原地完成吗？
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/reorder-list/description
 * @since  2019-07-11 18:30:31
 */
public class L_0099_Reorder_List {
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
     *
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
        ListNode head1 = ListNode.parse("{1,2,3,4,5}");
        new Solution().reorderList(head1);
        ListNode.show(head1);
    }
}
