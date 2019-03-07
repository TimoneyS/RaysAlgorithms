package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 给一个连续的数据流，返回终止数字到达时的第一个唯一数字（包括终止数字），如果在终止数字前无唯一数字或者找不到这个终止数字, 返回 -1.
 *
 * @author rays1
 *
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
        
        int[] nums = {3,4,3,4,2,6};
        int number = 2;
        
        Out.p(new Solution().firstUniqueNumber(nums, number));
        
    }

}
