package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Example:
 * Input:
 * [
 * &nbsp; 1-&gt;4-&gt;5,
 * &nbsp; 1-&gt;3-&gt;4,
 * &nbsp; 2-&gt;6
 * ]
 * Output: 1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @since   2020-02-24 22:38:29
 */
public class L0023_Merge_k_Sorted_Lists {
    /**
     * 两两归并排序，难点在于分析复杂度
     */
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            while (lists != null && lists.length > 1) {
                ListNode[] list = new ListNode[(lists.length + 1) / 2];
                for (int i = 0; i + 1 < lists.length; i += 2) {
                    list[i/2] = merge(lists[i], lists[i+1]);
                }
                if (lists.length % 2 != 0) {
                    list[list.length - 1] = lists[lists.length-1];
                }
                lists = list;
            }
            return lists == null || lists.length == 0 ? null : lists[0];
        }

        private ListNode merge(ListNode n1, ListNode n2) {
            ListNode pile = new ListNode(0);
            ListNode n = pile;
            while (true) {
                if (n1 == null) {
                    n.next = n2;
                    break;
                } else if(n2 == null) {
                    n.next = n1;
                    break;
                } else if (n1.val < n2.val) {
                    n.next = n1;
                    n1 = n1.next;
                    n = n.next;
                } else {
                    n.next = n2;
                    n2 = n2.next;
                    n = n.next;
                }
            }
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
