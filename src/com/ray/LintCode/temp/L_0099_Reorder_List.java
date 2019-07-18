package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      Given a singly linked list L: L<sub>0</sub> → L<sub>1</sub> → … → L<sub>n-1</sub> → L<sub>n</sub>
 *      
 *      reorder it to: L<sub>0</sub> → L<sub>n</sub> → L<sub>1</sub> → L<sub>n-1</sub> → L<sub>2</sub> → L<sub>n-2</sub> → …
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  1->2->3->4->null
 *      	Output: 1->4->2->3->null
 *      
 *      Example 2:
 *      	Input: 1->2->3->4->5->null
 *      	Output: 1->5->2->4->3->null
 *      	
 *      ```
 *
 * 挑战：
 *      Can you do this *in-place* without altering the nodes' values?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reorder-list/description
 * @date   2019-07-11 18:30:31
 */
public class L_0099_Reorder_List {

    static class Solution {
        /**
         * @param head: The head of linked list.
         * @return: nothing
         */
        public void reorderList(ListNode head) {
            if (head == null) return;
            
            int l = 0;
            ListNode t = head;
            while (t !=null) {
                l ++;
                t = t.next;
            }
            r (head, 1, l);
            
            return;
        }
        
        public ListNode r (ListNode head, int l, int r) {
            ListNode rs = null;
            ListNode t = null;
            if (r-l == 1) {
                rs = head.next;
                t = rs.next;
                rs.next = null;
            } else if (r == l) {
                rs = head;
                t = rs.next;
                rs.next = null;
            } else {
                rs = r(head.next, l+1, r-1);
                t = rs.next;
                rs.next = head.next;
                head.next = rs;
            }
            return t;
        }
        
    }

    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4,5,6}");
        
        new Solution().reorderList(head);
        
        ListNode.show(head);
    }

}
