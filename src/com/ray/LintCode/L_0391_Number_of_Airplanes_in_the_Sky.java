package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an list `interval`,  which are taking off and landing time of the flight. How many airplanes are there at most at the same time in the sky?
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [(1, 10), (2, 3), (5, 8), (4, 7)]
 *      Output: 3
 *      Explanation:
 *      The first airplane takes off at 1 and lands at 10.
 *      The second ariplane takes off at 2 and lands at 3.
 *      The third ariplane takes off at 5 and lands at 8.
 *      The forth ariplane takes off at 4 and lands at 7.
 *      During 5 to 6, there are three airplanes in the sky.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [(1, 2), (2, 3), (3, 4)]
 *      Output: 1
 *      Explanation: Landing happen before taking off.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-airplanes-in-the-sky/description
 * @date   2019-07-11 18:32:27
 */
public class L_0391_Number_of_Airplanes_in_the_Sky {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
