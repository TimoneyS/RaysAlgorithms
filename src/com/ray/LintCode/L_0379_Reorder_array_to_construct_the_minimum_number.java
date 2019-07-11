package com.ray.LintCode;

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

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
