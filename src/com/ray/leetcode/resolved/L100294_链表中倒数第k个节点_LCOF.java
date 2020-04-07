package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * 链表中倒数第k个节点 LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @since   2020-04-07 22:07:41
 */
public class L100294_链表中倒数第k个节点_LCOF {
    /**
     * 快慢结点
     */
    static class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode slow = head, fast = head;
            while (fast != null) {
                fast = fast.next;
                k --;
                if (k < 0) {
                    slow = slow.next;
                }
            }
            return slow;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
