package com.ray.LintCode.temp;

import com.ray.leetcode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a linked list and two values `v1` and `v2`. Swap the two nodes in the linked list with values `v1` and `v2`. It's guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list, do nothing.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 1->2->3->4->null, v1 = 2, v2 = 4
 *      Output: 1->4->3->2->null
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 1->null, v1 = 2, v2 = 1
 *      Output: 1->null
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/swap-two-nodes-in-linked-list/description
 * @date   2019-07-11 18:33:42
 */
public class L_0511_Swap_Two_Nodes_in_Linked_List {

    /**
     * 需要考虑交换的结点相邻的情况
     * @author rays1
     *
     */
    static class Solution {
    
        public ListNode swapNodes(ListNode head, int v1, int v2) {
            
            ListNode pile = new ListNode(0);
            pile.next = head;
            
            ListNode pv1 = null, pv2 = null;
            
            ListNode prev = pile;
            while (prev.next != null) {
                if (prev.next.val == v1)      { pv1 = prev; }
                else if (prev.next.val == v2) { pv2 = prev; }
                prev = prev.next;
            }
            

            
            if (pv1 != null && pv2 != null && pv1.next != null && pv2.next != null) {
                
                if (pv2.next == pv1) {
                    ListNode t = pv2;
                    pv2 = pv1;
                    pv1 = t;
                }
                
               ListNode n1 = pv1.next, n2 = pv2.next;
                
                if (pv1.next == pv2) {
                    pv2.next = n2.next;
                    n2.next = n1;
                    pv1.next = n2;
                } else {
                    pv1.next = n1.next;
                    n1.next  = n2.next;
                    pv2.next = n1;
                    n2.next  = pv1.next;
                    pv1.next = n2;
                }

            }
            
            return pile.next;
        }
    
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4,5,6}");
        int v1 = 1;
        int v2 = 2;
        
        Out.p(head);
        Out.p(new Solution().swapNodes(head, v1, v2));
        
    }

}
