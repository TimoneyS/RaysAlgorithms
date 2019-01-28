package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 统计链表中的结点数。
 *
 * @author rays1
 *
 */
public class L_0466_Count_Linked_List_Nodes {

    static class Solution {
    
        public int countNodes(ListNode head) {
            int i = 0;
            while (head != null) {
                i ++;
                head = head.next;
            }
            return i;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
