package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Find the second max number in a given array.
 *
 * 用例：
 *      Example1:
 *      ```
 *      Input: [1,3,2,4]
 *      Output: 3
 *      ```
 *      Example2:
 *      ```
 *      Input: [1,1,2,2]
 *      Output: 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/second-max-of-array/description
 * @date   2019-07-11 18:33:27
 */
public class L_0479_Second_Max_of_Array {


    static class Solution {
    
        public int secondMax(int[] nums) {
            
            int max = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE;
            
            for (int num : nums) {
               if (num >= max) {
                   secMax = max;
                   max = num;
               } else if (num >= secMax) {
                   secMax = num;
               }
            }
            
            return secMax;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
