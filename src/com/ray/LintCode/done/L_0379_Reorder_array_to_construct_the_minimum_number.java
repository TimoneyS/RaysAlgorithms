package com.ray.LintCode.done;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      Construct minimum number by reordering a given non-negative integer array. Arrange them such that they form the minimum number.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:[2,1]
 *      Output:[1,2]
 *       Explanation: there are 2 possible numbers can be constructed by reordering the array:
 *                1+2=12
 *                2+1=21
 *      So after reordering, the minimum number is 12, and return it.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:[3, 32, 321]
 *      Output:[321, 32, 3]
 *       Explanation: there are 6 possible numbers can be constructed by reordering the array:
 *      	3+32+321=332321
 *      	3+321+32=332132
 *      	32+3+321=323321
 *      	32+321+3=323213
 *      	321+3+32=321332
 *      	321+32+3=321323
 *      So after reordering, the minimum number is 321323, and return it.
 *      ```
 *
 * 挑战：
 *      Do it in O(nlogn) time complexity.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reorder-array-to-construct-the-minimum-number/description
 * @date   2019-07-11 18:32:19
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
        
        Out.p(new Solution());
        
    }

}
