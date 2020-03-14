package com.ray.LintCode.temp;

import com.ray.leetcode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Count how many nodes in a linked list.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  1->3->5->null
 *      	Output: 3
 *      	
 *      	Explanation: 
 *      	return the length of the list.
 *      
 *      Example 2:
 *      	Input:  null
 *      	Output: 0
 *      	
 *      	Explanation: 
 *      	return the length of list.
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Native
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/count-linked-list-nodes/description
 * @date   2019-07-11 18:33:22
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
