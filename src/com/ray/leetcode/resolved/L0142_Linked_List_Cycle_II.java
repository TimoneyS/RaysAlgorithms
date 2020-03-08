package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Linked List Cycle II
 * -----------------------------------------------------------------------------
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Note: Do not modify the linked list.
 *
 * Example:
 *      Example 1
 *      Input: head = [3,2,0,-4], pos = 1
 *      Output: tail connects to node index 1
 *      Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *      Example 2
 *      Input: head = [1,2], pos = 0
 *      Output: tail connects to node index 0
 *      Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *      Example 3
 *      Input: head = [1], pos = -1
 *      Output: no cycle
 *      Explanation: There is no cycle in the linked list.
 *      Follow-up:
 *      Can you solve it without using extra space?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @since   2020-03-07 20:54:10
 */
public class L0142_Linked_List_Cycle_II {
    /**
     * 假设
     *      非环部分长度为 x，环的部分长度为 y
     *      慢结点遍历长度：x + y1
     *      快结点遍历长度：x + y2
     * 慢结点一次前进 1， 快结点一次前进 2，当二者相遇时，快结点的路程是慢结点的两倍
     *      2*(x+y1) = x + y2
     * 则
     *      y2 - y1 = x + y1
     * 同时快指针和慢指针相遇一定时因为快指针沿着环夺走了几圈，因此
     *      n * y = x + y2 - x + y1 = y2 - y1 = x + y1
     * 则可得
     *      x = n*y - y1 = n*y + (y-y1)
     * y1 是慢结点在链上停留的位置
     * 可知 x 到环的入口距离为 x
     * y1 到环的入口的距离为 (y-y1)
     *
     * 那么从起点开始和从慢遍历的终点开始，依次前进，其相遇的位置必然为环的入口
     */
    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            ListNode slow = head, fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) return null;
                slow = slow.next;
                fast = fast.next.next;
            }

            while (head != slow.next) {
                head = head.next;
                slow = slow.next;
            }
            return head;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
