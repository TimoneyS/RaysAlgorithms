package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.leetcode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 * 用例：
 *      Example 1:
 *      	Input:   [2->4->null,null,-1->null]
 *      	Output:  -1->2->4->null
 *      Example 2:
 *      	Input: [2->6->null,5->null,7->null]
 *      	Output:  2->5->6->7->null
 * 难度： Medium
 *
 * @author rays1
 * @link   https://www.lintcode.cn/problem/merge-k-sorted-lists/description
 * @since  2019-07-11 18:30:35
 */
public class L_0104_Merge_K_Sorted_Lists {

    static class Solution2 {
        public ListNode mergeKLists(List<ListNode> lists) {
            while (lists != null && lists.size() > 1) {
                lists = merge(lists);
            }
            return lists == null ? null : lists.get(0);
        }

        private List<ListNode> merge(List<ListNode> lists) {
            List<ListNode> list = new ArrayList<>();
            for (int i = 0; i + 1 < lists.size(); i += 2) {
                ListNode n = merge(lists.get(i), lists.get(i+1));
                list.add(n);
            }
            if (lists.size() % 2 != 0) {
                list.add(lists.get(lists.size()-1));
            }
            return list;
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

    static class Solution {
        public ListNode mergeKLists(List<ListNode> lists) {
            if (lists == null) return null;

            ListNode pile = new ListNode(0);
            ListNode head = pile;
            int c = 0;

            while (true) {
                if (c < lists.size() - 1)
                    c = 0;
                ListNode min = null;
                int idx = 0;
                int midx = 0;
                for (ListNode n : lists) {
                    if (n == null) {
                        c++;
                    } else if (c == lists.size()-1) {
                        min = n;
                        break;
                    } else if (min == null || min.val > n.val ) {
                        min = n;
                        midx = idx;
                    }
                    idx ++;
                }
                if (c == lists.size()) break;
                lists.set(midx, min.next);
                head.next = min;
                head = head.next;
                if (c == lists.size() - 1) {
                    break;
                }
            }
            return pile.next;
        }
    }

    public static void main(String[] args) {
        List<ListNode> lists = new ArrayList<>();
        lists.add(ListNode.parse("{1,4,6,8,10,12}"));
        lists.add(ListNode.parse("{}"));
        lists.add(ListNode.parse("{2,5,7,9}"));
        lists.add(ListNode.parse("{1,6,7,9}"));
        lists.add(ListNode.parse("{2,5}"));
        Out.p(new Solution2().mergeKLists(lists));
    }
}