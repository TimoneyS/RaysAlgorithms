package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Determine whether year `n` is a leap year.return `true` if `n` is a leap year.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : n = 2008
 *      Output : true
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : n = 2018
 *      Output : false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/leap-year/description
 * @date   2019-07-11 18:36:27
 */
public class L_0766_Leap_Year {

    static class Solution {
        /**
         * @param n: a number represent year
         * @return: whether year n is a leap year.
         */
        public boolean isLeapYear(int n) {
            return n % 4 == 0 && n % 100 != 0 || n % 400 == 0;
            // 如果年份可以被 4 整除且不能被 100 整除 或者 可以被 400 整除, 那么这一年为闰年
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
