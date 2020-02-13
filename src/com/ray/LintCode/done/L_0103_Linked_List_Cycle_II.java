package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null。
 * 挑战：
 *      不使用额外的空间
 * 难度： Hard
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/linked-list-cycle-ii/description
 * @since  2019-07-11 18:30:34
 */
public class L_0103_Linked_List_Cycle_II {

    /**
     * 假设
     *      非环部分长度为 x，环的部分长度为 y
     *      慢结点遍历长度：x + y1
     *      快结点遍历长度：x + y2
     * 慢结点一次前进 1， 快结点一次前进 2，当二者相遇时，快结点的路程是慢结点的两倍
     *      2*(x+y1) = x + y2
     * 则
     *      y2 - y1 = x + y1
     * 同时快指针和慢指针相遇一定时因为快指针沿着环夺走了几圈，因此
     *      n * y = x + y2 - x + y1 = y2 - y1 = x + y1
     * 则可得
     *      x = n*y - y1 = n*y + (y-y1)
     * y1 是慢结点在链上停留的位置
     * 可知 x 到环的入口距离为 x
     * y1 到环的入口的距离为 (y-y1)
     *
     * 那么从起点开始和从慢遍历的终点开始，依次前进，其相遇的位置必然为环的入口
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