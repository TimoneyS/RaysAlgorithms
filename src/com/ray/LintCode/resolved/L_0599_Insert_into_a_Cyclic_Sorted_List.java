package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 
 * 给定一个有序的环形列表，编写函数能够向环形列表插入值，同时保持列表的环形结构不变。
 * 
 * 给定的结点可以是环形列表中任意的一个结点，返回插入后的新结点。
 * 
 * @author rays1
 *
 */
public class L_0599_Insert_into_a_Cyclic_Sorted_List {

    /**
     * 环形链表不需要考虑插入头部或尾部的问题，因为循环总会使得新的结点是插入到两个结点之间
     * 
     * 那么两个结点就有两种情况
     *      1. 增序的两个结点之间
     *          prev - > newNode -> next 
     *      
     *      2. 头尾之间
     *          head - > newNode -> tail
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public ListNode insert(ListNode node, int x) {
            
            if (node  == null) {
                node = new ListNode(x);
                node.next = node;
                return node;
            }
            
            ListNode head = node;
            
            ListNode prev = node;
            node          = node.next;
            while (node != head) {
                if (prev.val <= node.val) {
                    if (prev.val <= x && node.val >= x) break;
                } else {
                    if (prev.val <= x || node.val >= x) break;
                }
                prev = node;
                node = node.next;
            }
            
            ListNode t = new ListNode(x);
            
            prev.next = t;
            t.next = node;
            
            return prev;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
