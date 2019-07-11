package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 向有序的链表中插入新结点
 *
 * @author rays1
 *
 */
public class L_0219_Insert_Node_in_Sorted_Linked_List {

    /**
     * 增加一个桩，寻找第一个下一个结点大于val的结点。
     * @author rays1
     *
     */
    static class Solution {
    
        public ListNode insertNode(ListNode head, int val) {
            ListNode pile = new ListNode(Integer.MIN_VALUE);
            pile.next = head;
            
            ListNode node = pile;
            while (node != null && node.next != null) {
                if (node.next.val < val) node = node.next;
                else break;
            }
            
            ListNode t = new ListNode(val);
            t.next = node.next;
            node.next = t;
            
            return pile.next;
        }
    
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4}");
        int val = 5;
        
        Out.p(head);
        Out.p(new Solution().insertNode(head, val));
        
    }

}
