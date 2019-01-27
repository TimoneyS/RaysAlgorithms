package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 
 * 反转结点
 * 
 * 给定一个链表，一次反转 k 个结点。返回修改后的链表。
 * 如果剩余的结点不足 k 个，则不做处理。
 * 要求只能通过调换结点，而不是修改结点值得方式来完成。
 * 
 * 空间复杂度要求是常量级。
 * 
 * 如：链表 1->2->3->4->5
 *      k = 2，返回 2->1->4->3->5
 *      k = 3，返回 3->2->1->4->5
 * @author rays1
 *
 */
public class L_0450_Reverse_Nodes_in_k_Group {

    /**
     * 核心思路是边遍历，边翻转 k 个结点
     * 当翻转得结点不足k个时，便反向遍历恢复原顺序。
     * @author rays1
     *
     */
    static class Solution {
    
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode pile = new ListNode(0);
            pile.next = head;
            
            ListNode node = pile;
            while ((node = reverse(node, node.next, k)) != null) {};
            
            return pile.next;
        }
        
        /**
         * 翻转 K 个结点，返回翻转后得 tail 结点，也是下一次翻转的桩结点。
         */
        public ListNode reverse(ListNode pile, ListNode node, int k) {
            if (node == null || node.next == null) return null;
            
            ListNode tail = node;
            ListNode prev = node;
            ListNode next = node.next;
            int i = 1;
            while (i++ < k) {
                node = next;
                next = node.next;
                node.next = prev;
                prev = node;
                
                if (next == null) break;
            }
            
            if (i < k) {
                prev = next;
                next = node.next;
                while (true) {
                    node.next = prev;
                    prev = node;
                    node = next;
                    next = node.next;
                    if (node == pile.next) break;
                }
                return null;
            } else {
                pile.next = node;
                tail.next = next;
                return tail;
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4,5}");
        
        Out.p(new Solution().reverseKGroup(head, 1));
        
    }

}
