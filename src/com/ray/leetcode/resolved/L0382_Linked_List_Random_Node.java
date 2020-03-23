package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Linked List Random Node
 * -----------------------------------------------------------------------------
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * Example:
 *      Example 1
 *      // Init a singly linked list [1,2,3].
 *      ListNode head = new ListNode(1);
 *      head.next = new ListNode(2);
 *      head.next.next = new ListNode(3);
 *      Solution solution = new Solution(head);
 *      // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 *      solution.getRandom();
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/linked-list-random-node/
 * @since   2020-03-23 21:57:51
 */
public class L0382_Linked_List_Random_Node {
    static class Solution {
        private ListNode h;

        public Solution(ListNode head) {
            h = head;
        }

        public int getRandom() {
            ListNode c = h;
            int r = c.val;
            int stat = 1;
            while (c != null) {
                if (((int) (stat * Math.random())) == 0)
                    r = c.val;
                c = c.next;
                stat ++;
            }
            return r;
        }
    }
    
    public static void main(String[] args) {
    }
}
