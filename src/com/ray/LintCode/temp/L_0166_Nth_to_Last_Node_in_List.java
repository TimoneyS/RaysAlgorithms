package com.ray.LintCode.temp;

import com.ray.leetcode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      <p>Find the nth to last element of a singly linked list.&nbsp;</p><p>The minimum number of nodes in list is n.<br></p>
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: list = 3->2->1->5->null, n = 2
 *      	Output: 1
 *      
 *      
 *      Example 2:
 *      	Input: list  = 1->2->3->null, n = 3
 *      	Output: 1
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/nth-to-last-node-in-list/description
 * @date   2019-07-11 18:31:27
 */
public class L_0166_Nth_to_Last_Node_in_List {

    static class Solution {
        public ListNode nthToLast(ListNode head, int n) {
            
            ListNode n1 = null, n2;
            
            int dist = 0;
            n2 = head;
            while (true) {
                if (dist == n) {
                    n1 = head;
                    break;
                }
                n2 = n2.next;
                dist++;
            }
            
            while (n1 != null && n2 != null) {
                n1 = n1.next;
                n2 = n2.next;
            }
            
            return n1;
        }
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1}");
        Solution sol = new Solution();
        ListNode node = sol.nthToLast(head, 1);
        
        Out.p(node.val);
    }

}
