package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      <p style="line-height: 30px;">Given a linked list, determine if it has a cycle in it.</p><p style="line-height: 30px;"><br></p>
 *
 * 用例：
 *      ```
 *      	Example 1:
 *      		Input: 21->10->4->5,  then tail connects to node index 1(value 10).
 *      		Output: true
 *      		
 *      	Example 2:
 *      		Input: 21->10->4->5->null
 *      		Output: false
 *      	
 *      	```
 *
 * 挑战：
 *      <p><span style="line-height: 30px;">Follow up:</span><br style="line-height: 30px;"><span style="line-height: 30px;">Can you solve it without using extra space?</span><br></p>
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/linked-list-cycle/description
 * @date   2019-07-11 18:30:34
 */
public class L_0102_Linked_List_Cycle {

    static class Solution {
        
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (true) {
                if (slow == null || fast == null || fast.next == null) return false;
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
        }
        
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,2,3}");
        
        Out.p(new Solution().hasCycle(head));
    }

}
