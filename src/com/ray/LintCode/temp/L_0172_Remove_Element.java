package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array and a value, remove all occurrences of that value in place and return the new length.
 *      
 *      The order of elements can be changed, and the elements after the new length don't matter.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: [], value = 0
 *      	Output: 0
 *      
 *      
 *      Example 2:
 *      	Input:  [0,4,4,0,0,2,4,4], value = 4
 *      	Output: 4
 *      	
 *      	Explanation: 
 *      	the array after remove is [0,0,0,2]
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-element/description
 * @date   2019-07-11 18:31:32
 */
public class L_0172_Remove_Element {

    static class Solution {
        public int removeElement(int[] A, int elem) {
            int n = A.length;
            
            int i = 0;
            for (int num : A) {
                if (num != elem) {
                    A[i++] = num;
                } else {
                    n --;
                }
            }
            return n;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
