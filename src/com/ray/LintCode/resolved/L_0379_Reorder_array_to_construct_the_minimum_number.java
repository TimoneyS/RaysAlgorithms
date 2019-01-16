package com.ray.LintCode.resolved;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 通过重新排序给定的非负整数数组来构造最小数字。
 * 
 * 如数组 [3, 32, 321]， 有 6 种可能的排列再组成数字
 *  
 *  [3, 32, 321] = 332321 
 *  [3, 321, 32] = 332132
 *  [32, 3, 321] = 323321
 *  [32, 321, 3] = 323213
 *  [321, 3, 32] = 321332
 *  [321, 32, 3] = 321323
 *  
 *  其中最小排序方式为 [321, 32, 3]的数字为 321323 
 *  
 * @author rays1
 *
 */
public class L_0379_Reorder_array_to_construct_the_minimum_number {
    
    
    /**
     * 数字按照以下逻辑排序
     *      3  和 321 比较则等同 333 和 321 比较
     *      32 和 321 比较等同 322 和 321 比较
     *      
     * 即从左侧开始比较每个数字的第一个数的大小，如果位数不够，则用最后一位的数字补位
     * 如此排序的结果，直接组合即可。
     * @author rays1
     *
     */
   static class Solution {
        public String minNumber(int[] nums) {
            PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int i1 = 0, i2 = 0;
                    while (o1.charAt(i1) == o2.charAt(i2) ) {
                        if (i1 < o1.length() - 1) i1 ++;
                        if (i2 < o2.length() - 1) i2 ++;
                        if (i1 == o1.length()-1 && i2 == o2.length()-1) break;
                    }
                    return Character.compare(o1.charAt(i1), o2.charAt(i2));
                }
            });
            
            for (int num : nums) {
                pq.add(String.valueOf(num));
            }
            
            StringBuilder sb = new StringBuilder();
            
            while (!pq.isEmpty()) {
                sb.append(pq.poll());
            }
            
            Out.p(1);
            
            while (sb.charAt(0) == '0' && sb.length() != 1) sb.deleteCharAt(0);
            
            return sb.toString();
        }
    }
    
   
   public static void main(String[] args) {
       
       int[] nums = {0, 0, 0, 0};
       
       Out.p(new Solution().minNumber(nums));
   }
}
