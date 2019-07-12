package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Remove all elements from a linked list of integers that have value `val`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: head = 1->2->3->3->4->5->3->null, val = 3
 *      Output: 1->2->4->5->null
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: head = 1->1->null, val = 1
 *      Output: null
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-linked-list-elements/description
 * @date   2019-07-11 18:33:15
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
        
        Out.p(new Solution());
        
    }

}
