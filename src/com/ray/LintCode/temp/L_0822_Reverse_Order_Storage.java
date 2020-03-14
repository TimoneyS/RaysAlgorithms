package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.leetcode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Give a linked list, and store the values of linked list **in reverse order** into an array.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: 1 -> 2 -> 3 -> null
 *      Output: [3,2,1]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: 4 -> 2 -> 1 -> null
 *      Output: [1,2,4]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-order-storage/description
 * @date   2019-07-11 18:37:13
 */
public class L_0822_Reverse_Order_Storage {

    /**
     * 首递归,自动处理栈关系
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> reverseStore(ListNode head) {
            return helper(new ArrayList<Integer>(), head);
        }
        
        List<Integer> helper(List<Integer> rs, ListNode head) {
            if (head != null)
                helper(rs, head.next);
            rs.add(head.val);
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
