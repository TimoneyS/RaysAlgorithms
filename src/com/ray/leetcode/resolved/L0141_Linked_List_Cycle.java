package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Linked List Cycle
 * -----------------------------------------------------------------------------
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Example:
 *      Example 1
 *      Input: head = [3,2,0,-4], pos = 1
 *      Output: true
 *      Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *      Example 2
 *      Input: head = [1,2], pos = 0
 *      Output: true
 *      Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *      Example 3
 *      Input: head = [1], pos = -1
 *      Output: false
 *      Explanation: There is no cycle in the linked list.
 *      Follow up:
 *      Can you solve it using O(1) (i.e. constant) memory?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/linked-list-cycle/
 * @since   2020-03-07 20:52:57
 */
public class L0141_Linked_List_Cycle {
    /**
     * 快慢结点
     */
    public static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (!(slow == null || fast == null || fast.next == null)) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast || fast != null && slow == fast.next) return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
