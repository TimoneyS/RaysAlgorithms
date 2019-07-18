package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *      
 *      If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *      
 *      You may not alter the values in the nodes, only nodes itself may be changed.
 *      Only constant memory is allowed.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      list = 1->2->3->4->5->null
 *      k = 2
 *      Output:
 *      2->1->4->3->5
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      list = 1->2->3->4->5->null
 *      k = 3
 *      Output:
 *      3->2->1->4->5
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-nodes-in-k-group/description
 * @date   2019-07-11 18:33:13
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
        
        Out.p(new Solution());
        
    }

}
