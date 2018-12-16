package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * 
 * 合并 k 个已经排序的链表
 *
 * @author rays1
 *
 */
public class L_0104_Merge_K_Sorted_Lists {

    static class Solution {
        /**
         * @param lists: a list of ListNode
         * @return: The head of one sorted list.
         */
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
        
        List<ListNode> lists = new ArrayList<ListNode>();
        
        lists.add(ListNode.parse("{1,4,6,8,10,12}"));
        lists.add(ListNode.parse("{}"));
        lists.add(ListNode.parse("{2,5,7,9}"));
        lists.add(ListNode.parse("{1,6,7,9}"));
        lists.add(ListNode.parse("{2,5}"));
        
        Out.p(new Solution().mergeKLists(lists));
    }

}
