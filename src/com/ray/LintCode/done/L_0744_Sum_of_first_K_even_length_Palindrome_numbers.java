package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a integer k, find the sum of first k even-length palindrome numbers.
 *      Even length here refers to the number of digits of a number is even.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:  k = 3
 *      Output: 66
 *      Explanation:
 *      11 + 22 + 33  = 66 (Sum of first three even-length palindrome numbers)
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input:  k = 10
 *      Output: 1496
 *      Explanation:
 *      11 + 22 + 33 + 44 + 55 + 66 + 77 + 88 + 99 + 1001 = 1496
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sum-of-first-k-even-length-palindrome-numbers/description
 * @date   2019-07-11 18:36:00
 */
public class L_0744_Sum_of_first_K_even_length_Palindrome_numbers {

    /**
     * next 方法是从中间开始加 1
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int sumKEven(int k) {
            int sum = 0;
            int n = 11;
            for (int i = 1; i <= k; i ++) {
                sum += n;
                n = next(n);
            }
            return sum;
        }
        
        private int next(int num) {
            num = (int) (num/Math.pow(10, (int) (Math.log10(num) + 1)/2)) + 1;
            int t = num;
            while (t != 0) {
                num = num * 10 + t % 10;
                t /= 10;
            }
            return num;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
