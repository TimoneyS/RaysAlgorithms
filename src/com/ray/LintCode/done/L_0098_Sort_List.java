package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      在 O(n log n) 的时间复杂度内排序一个列表，且额外空间占用为常量
 * 挑战：
 *      分别用归并排序和快速排序做一遍。
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/sort-list/description
 * @since  2019-07-11 18:30:30
 */
public class L_0098_Sort_List {

    /**
     * 在中点处切分链表，然后分别排序后归并。
     */
    static class SolutionMerge {

        public ListNode sortList(ListNode head) {
            return sort(head, null);
        }
        
        private ListNode sort(ListNode head, ListNode tail) {
            if (head == tail || head == null || head.next == null ) return head;
            
            ListNode t = head;
            ListNode mid = head;
            
            int l = 0, m = 0;
            while (t != tail) {
                if (m < l / 2) {
                    m = l / 2;
                    mid = mid.next;
                }
                l ++;
                t = t.next;
            }
            
            t = mid.next;
            mid.next = null;
            ListNode n1 = sort(head, mid);
            ListNode n2 = sort(t, tail);
            return merge(n1, n2);
        }

        /**
         * 归并
         */
        private ListNode merge(ListNode n1, ListNode n2) {
            ListNode pile = new ListNode(0);
            ListNode tail = pile;
            while (true) {
                if (n1 == null) {
                    tail.next = n2;
                    break;
                } else if (n2 == null) {
                    tail.next = n1;
                    break;
                } else {
                    if (n1.val < n2.val) {
                        tail.next = n1;
                        n1 = n1.next;
                    } else {
                        tail.next = n2;
                        n2 = n2.next;
                    }
                }
                tail = tail.next;
            }
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{5,2,6,4,1,7}");
        ListNode rs = new SolutionMerge().sortList(head);
        ListNode.show(rs);
    }
}
