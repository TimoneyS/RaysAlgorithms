package com.ray.LintCode.resolved;

import com.ray.LintCode.help.ListNode;
import com.ray.io.Out;

/**
 * 寻找倒数第n个结点
 *
 * @author rays1
 *
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
