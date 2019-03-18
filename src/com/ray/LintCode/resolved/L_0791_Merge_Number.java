package com.ray.LintCode.resolved;

import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 给定 n 个数字，现在需要将 n 个数字合并为 1 个。每次只能选择两个数字 a、b来合并，合并需要消耗的能量为 a+b
 * 
 * 输出一共需要的最小的能量。
 * 
 * n 在  [ 2, 50000] 之间
 * 
 * @author rays1
 *
 */
public class L_0791_Merge_Number {

    /**
     * 每次选择最小的两个数字合并，合并后的结果加入原本的数字中
     * 如此循环
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int mergeNumber(int[] numbers) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int n : numbers) pq.add(n);
            
            int rs = 0;
            while (pq.size() >= 2) {
                int n1 = pq.poll();
                int n2 = pq.poll();
                pq.add(n1+n2);
                rs += n1 + n2;
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {1,2,3,4};
        Out.p(new Solution().mergeNumber(numbers));
        
    }

}
