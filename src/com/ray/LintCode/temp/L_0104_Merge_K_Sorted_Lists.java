package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Merge *k* sorted linked lists and return it as one sorted list.
 *      
 *      Analyze and describe its complexity.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:   [2->4->null,null,-1->null]
 *      	Output:  -1->2->4->null
 *      
 *      Example 2:
 *      	Input: [2->6->null,5->null,7->null]
 *      	Output:  2->5->6->7->null
 *      	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/merge-k-sorted-lists/description
 * @date   2019-07-11 18:30:35
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
