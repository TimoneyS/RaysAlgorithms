package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Write an algorithm to determine if a number is *happy*.
 *      
 *      A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:19
 *      Output:true
 *      Explanation:
 *      
 *      19 is a happy number
 *      
 *          1^2 + 9^2 = 82
 *          8^2 + 2^2 = 68
 *          6^2 + 8^2 = 100
 *          1^2 + 0^2 + 0^2 = 1
 *      
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:5
 *      Output:false
 *      Explanation:
 *      
 *      5 is not a happy number
 *      
 *      25->29->85->89->145->42->20->4->16->37->58->89
 *      89 appears again.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/happy-number/description
 * @date   2019-07-11 18:33:30
 */
public class L_0488_Happy_Number {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
