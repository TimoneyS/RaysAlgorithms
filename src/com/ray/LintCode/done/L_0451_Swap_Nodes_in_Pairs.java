package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a linked list, swap every two adjacent nodes and return its head.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: 1->2->3->4->null
 *      Output: 2->1->4->3->null
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: 5->null
 *      Output: 5->null
 *      ```
 *
 * 挑战：
 *      Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/swap-nodes-in-pairs/description
 * @date   2019-07-11 18:33:14
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
        
        Out.p(new Solution());
        
    }

}
