package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a non-negative integer `num`, repeatedly add all its digits until the result has only one digit.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      num=38
 *      Output:
 *      2
 *      Explanation:
 *      The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return 2.
 *      
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      num=9
 *      Output:
 *      9
 *      Explanation:
 *      9<10,return 9.
 *      ```
 *
 * 挑战：
 *      Could you do it without any loop/recursion in O(1) runtime?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/add-digits/description
 * @date   2019-07-11 18:34:00
 */
public class L_0569_Add_Digits {

    static class Solution {
        
        public int addDigits(int num) {
            int t = 0;
            while (num > 0) {
                if (num < 10) {
                    num += t;
                    t = 0;
                    if (num < 10) break;
                } else {
                    t += num %10;
                    num /= 10;
                }
            }
            return num;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
