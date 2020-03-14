package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.ray.leetcode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      To give a continuous stream of data, write a function that returns the first unique number (including the terminating number) when the terminating number arrives. If the terminating number is not found, return `-1`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 
 *      [1, 2, 2, 1, 3, 4, 4, 5, 6]
 *      5
 *      Output: 3
 *      ```
 *      **Example2**
 *      ```
 *      Input: 
 *      [1, 2, 2, 1, 3, 4, 4, 5, 6]
 *      7
 *      Output: -1
 *      ```
 *      **Example3**
 *      ```
 *      Input: 
 *      [1, 2, 2, 1, 3, 4]
 *      3
 *      Output: 3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/first-unique-number-in-data-stream/description
 * @date   2019-07-11 18:35:28
 */
public class L_0685_First_Unique_Number_in_Data_Stream {

    /**
     * 维护主要两个结构
     *      至今未有重复的数字列表 lu
     *      有重复的数字列表            ld
     *      
     * 依次添加数字
     *      1. 如果数字在 ld 中，不处理
     *      2. 如果数字在 lu 中，将数字从 lu 移动到 ld 中
     *      3. 如果数字不在 lu 和 ld 中说明数字是唯一数字，加入 ld 的末尾
     *      
     * 需要查询 lu 和 ld，要求lu 和 ld 具有查询高效率的查询方法
     * lu 的添加和删除需要按照添加时间保持顺序
     * 
     * 标准解答给出的解答方案是
     * 
     * lu 使用链表保存，用 map 映射数字和其前置结点。查询效率O(1), 删除新增效率 O(1)
     * ld 使用 set 保存， 添加效率 O(1), 查询效率O(1)
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public int firstUniqueNumber(int[] nums, int number) {
            
            HashSet<Integer> dup                    = new HashSet<Integer>();
            Map<Integer, ListNode> prevMap          = new HashMap<>();
            ListNode head = new ListNode(0), tail   = head;
            
            boolean flag = false;
            for (int n : nums) {
                tail = add(dup, prevMap, tail, n);
                if (n == number) {
                    flag = true;
                    break;
                }
            }
            
            return flag && head.next != null ? head.next.val : -1;
        }

        private ListNode add(HashSet<Integer> dup, Map<Integer, ListNode> prevMap, ListNode tail, int n) {
            
            if (dup.contains(n)) return tail;
            if (prevMap.containsKey(n)) {
                // 搬迁
                dup.add(n);
                ListNode node = prevMap.remove(n);
                node.next = node.next.next;
                if (node.next != null)
                    prevMap.put(node.next.val, node);
                else
                    tail = node;
            } else {
                prevMap.put(n, tail);
                tail.next = new ListNode(n);
                tail = tail.next;
            }
            return tail;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
