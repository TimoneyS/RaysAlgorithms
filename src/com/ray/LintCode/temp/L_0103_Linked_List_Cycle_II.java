package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a linked list, return the node where the cycle begins. 
 *      
 *      If there is no cycle, return `null`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：null,no cycle
 *      Output：no cycle
 *      Explanation：
 *      List is null，so no cycle.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：-21->10->4->5，tail connects to node index 1
 *      Output：10
 *      Explanation：
 *      The last node 5 points to the node whose index is 1, which is 10, so the entrance of the ring is 10
 *      ```
 *
 * 挑战：
 *      Follow up:
 *      
 *      Can you solve it without using extra space?
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/linked-list-cycle-ii/description
 * @date   2019-07-11 18:30:34
 */
public class L_0103_Linked_List_Cycle_II {

    /**
     * 假设
     *      非环部分长度为 x
     *      环的部分长度为 y
     * 则
     *      慢指针遍历长度：x + y1
     *      快指针遍历长度：x + y2
     * 快指针遍历长度为慢指针遍历长度的 2 倍，则有
     *      2*(x+y1) = x + y2
     *      x + 2*y1 = y2
     * 可得 
     *      y2 - y1 = x + y1
     * 同时快指针和慢指针相遇一定时因为快指针沿着环夺走了几圈，因此
     *      x + y2 - x + y1 = y2 - y1 = n * y
     * 则可得
     *      x + y1 = n * y
     *      x = n*y - y1
     *      
     * 假设 z 为慢遍历的终点到环的起点的距离，则
     *      z+y1 = k1*y
     *      y1 = k1*y - z
     *      x = n*y - k1*y + z
     *      x = k*y + z
     *      
     * 表示从起点到环的入口，和从慢遍历的终点到环的入口的距离相差 k 个环的距离
     * 那么从起点开始和从慢遍历的终点开始，依次前进，其相遇的位置即为环的入口
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            
            ListNode slow = head, fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) return null;
                slow = slow.next;
                fast = fast.next.next;
            }
            
            while (head != slow.next) {
                head = head.next;
                slow = slow.next;
            }
            return head;
        }
        
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,1,1,2,3,4,5,6}");
        head.nextVal(6).next = head.nextVal(2);
        
        Out.p(new Solution().detectCycle(head).val);
        
    }

}
