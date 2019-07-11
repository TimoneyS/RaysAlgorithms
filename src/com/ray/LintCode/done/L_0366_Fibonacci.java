package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Find the *N*th number in Fibonacci sequence.
 *      
 *      A Fibonacci sequence is defined as follow:
 *      
 *      - The first two numbers are 0 and 1.
 *      - The *i* th number is the sum of *i*-1 th number and *i*-2 th number.
 *      
 *      The first ten numbers in Fibonacci sequence is:
 *      
 *      `0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...`
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  1
 *      	Output: 0
 *      	
 *      	Explanation: 
 *      	return the first number in  Fibonacci sequence .
 *      
 *      Example 2:
 *      	Input:  2
 *      	Output: 1
 *      	
 *      	Explanation: 
 *      	return the second number in  Fibonacci sequence .
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Native
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/fibonacci/description
 * @date   2019-07-11 18:32:11
 */
public class L_0366_Fibonacci {

    static class Solution {
        
        public int fibonacci(int n) {
            int[] record = new int[n+1];
            return fib(n, record);
        }
        
        public int fib(int n, int[] record) {
            if(n<=2) return n-1;
                
            if (record[n] == 0) record[n] = fib(n-1, record) + fib(n-2, record);
                
            return record[n];
        }
        
    }

    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
