package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Write a program to check whether a given number is an `ugly` number`.
 *      
 *      `Ugly numbers` are positive numbers whose prime factors only include `2`, `3`, `5`. For example, `6`, `8` are ugly while `14` is not ugly since it includes another prime factor `7`.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: num = 8 
 *      Output: true
 *      Explanation:
 *      8=2*2*2
 *      ```
 *      Example 2:
 *      ```
 *      Input: num = 14 
 *      Output: false
 *      Explanation:
 *      14=2*7 
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/ugly-number/description
 * @date   2019-07-11 18:33:47
 */
public class L_0517_Ugly_Number {

    static class Solution {
        
        public boolean isUgly(int num) {
            if (num == 0) {
                return false;
            }
            int[] factors = {2, 3, 5};
            for (int factor : factors) 
                while (num % factor == 0) {
                    num /= factor;
                }
            return Arrays.binarySearch(factors, num) >= 0 || num == 1;
        }
        
    }
    
    public static void main(String[] args) {
        
        int num = 0;
        
        Out.p(new Solution().isUgly(num));
        
    }

}
