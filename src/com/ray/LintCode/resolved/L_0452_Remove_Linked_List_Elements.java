package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 *
 * 删除链表中值为指定整数的结点
 * 
 * 如： 链表  1->2->3->3->4->5->3, val = 3, 返回 1->2->4->5
 *
 * @author rays1
 *
 */
public class L_0452_Remove_Linked_List_Elements {

    static class Solution {
    
        public ListNode removeElements(ListNode head, int val) {
            ListNode pile  = new ListNode(0);
            pile.next = head;
            
            ListNode prev = pile, node = head;
            while (node != null) {
                
                if (node.val == val) {
                    node = node.next;
                    prev.next = node;
                } else {
                    prev = node;
                    node = node.next;
                }
            }
            
            return pile.next;
        }
    
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{3,2,1,3,3,4,1,3}");
        
        int val = 3;
        
        Out.p(new Solution().removeElements(head, val));
        
    }

}
