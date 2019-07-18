package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `3*n + 1` non-negative integer, every numbers occurs triple times except one, find it.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:  [1,1,2,3,3,3,2,2,4,1]
 *      Output:  4
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [2,1,2,2]
 *      Output:  1	
 *      ```
 *
 * 挑战：
 *      One-pass, constant extra space.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/single-number-ii/description
 * @date   2019-07-11 18:29:59
 */
public class L_0083_Single_Number_II {

    static class Solution {
        /**
         * @param A: An integer array
         * @return: An integer
         */
        public int singleNumberII(int[] A) {
            
            int[] num = new int[32];
            
            for (int i : A) {
                Out.p(i);
                int j = 0;
                while (i != 0) {
                    num [j] += i % 2;
                    if (num[j] == 3 || num[j] == -3) num[j] = 0;

                    j ++;
                    i = i / 2;
                }
                Out.p(num);
                
            }
            
            int n = 0;
            for (int i = 0; i < num.length; i++) {
                if (num[i] == 1)
                    n += Math.pow(2, i);
            }
            
            return n;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
