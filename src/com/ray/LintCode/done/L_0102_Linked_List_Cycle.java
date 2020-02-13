package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一个链表，判断它是否有环。
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/linked-list-cycle/description
 * @since  2019-07-11 18:30:34
 */
public class L_0102_Linked_List_Cycle {
    /**
     * 快慢结点
     */
    static class Solution {
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
        ListNode head = ListNode.parse("{1,2,3}");
        Out.p(new Solution().hasCycle(head));
    }
}