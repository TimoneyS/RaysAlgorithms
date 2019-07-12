package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a integer `c`, your task is to decide whether there're two integers a and b such that `a^2 + b^2 = c`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : n = 5
 *      Output : true
 *      Explanation : 
 *      1 * 1 + 2 * 2 = 5
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : n = -5
 *      Output : false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sum-of-square-numbers/description
 * @date   2019-07-11 18:35:35
 */
public class L_0697_Sum_of_Square_Numbers {


    /**
     * 判断是不是平方数，可以表示为
     * 
     * i = Math.sqrt(n)
     * i*i == n
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean checkSumOfSquareNumbers(int num) {
            for (int i = (int) Math.sqrt(num); i >= 0; i --) {
                int n = num - i*i;
                int t = (int) Math.sqrt(n);
                if (t * t == n) return true;
            }
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
