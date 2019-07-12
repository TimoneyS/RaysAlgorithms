package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a positive integer `num`, write a function which returns `True` if num is a perfect square else `False`.
 *
 * 用例：
 *      **Example1:**
 *      
 *      ```
 *      Input: num = 16
 *      Output: True
 *      Explanation:
 *      sqrt(16) = 4
 *      ```
 *      
 *      **Example2:**
 *      
 *      ```
 *      Input: num = 15
 *      Output: False
 *      Explanation:
 *      sqrt(15) = 3.87
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-perfect-square/description
 * @date   2019-07-11 18:36:36
 */
public class L_0777_Valid_Perfect_Square {

    static class Solution {
        /**
         * @param num: a positive integer
         * @return: if num is a perfect square else False
         */
        public boolean isPerfectSquare(int num) {
            // write your code here
            int t =  (int) Math.sqrt(num);
            return t*t == num;
            
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
