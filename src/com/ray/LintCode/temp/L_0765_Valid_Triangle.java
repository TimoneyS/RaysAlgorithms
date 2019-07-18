package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given three integers `a`, `b`, `c`, return `true` if they can form a triangle.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : a = 2, b = 3, c = 4
 *      Output : true
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : a = 1, b = 2, c = 3
 *      Output : false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-triangle/description
 * @date   2019-07-11 18:36:26
 */
public class L_0765_Valid_Triangle {

    static class Solution {
        /**
         * @param a: a integer represent the length of one edge
         * @param b: a integer represent the length of one edge
         * @param c: a integer represent the length of one edge
         * @return: whether three edges can form a triangle
         */
        public boolean isValidTriangle(int a, int b, int c) {
            // write your code here
                        return !(a+b<=c||a+c<=b||b+c<=a);
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
