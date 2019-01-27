package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 给定一个链表，交换每两个相邻的结点，并且返回首结点。
 * 
 * 如：1->2->3->4 返回 2->1->4->3
 * 
 * 限定空间复杂度为常量级别
 *
 * @author rays1
 *
 */
public class L_0451_Swap_Nodes_in_Pairs {

    static class Solution {
    
        public ListNode swapPairs(ListNode head) {
            
            ListNode pile = new ListNode(0);
            pile.next = head;
            
            ListNode n = pile;
            
            while ( (n = swap(n)) != null) {}
            
            return pile.next;
        }
        
        /**
         * 交换 pile 之后的两个结点，返回交换后的最后一个结点
         */
        ListNode swap(ListNode pile) {
            
            if (pile == null || pile.next == null || pile.next.next == null) return null;
            
            ListNode n1 = pile.next;
            ListNode n2 = pile.next.next;
            pile.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            
            return n1;
        }
    
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4,5}");
        Out.p(new Solution().swapPairs(head));
        
    }

}
