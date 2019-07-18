package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Check a positive number is a palindrome or not.
 *      
 *      A palindrome number is that if you reverse the whole number you will get exactly the same number.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:11
 *      Output:true
 *      
 *      ```
 *      Example 2:
 *      ```
 *      Input:1232
 *      Output:false
 *      Explanation:
 *      1232!=2321
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/palindrome-number/description
 * @date   2019-07-11 18:33:31
 */
public class L_0491_Palindrome_Number {

    static class Solution {
        /**
         * @param num a positive number
         * @return true if it's a palindrome or false
         */
        public boolean palindromeNumber(int num) {
            // Write your code here
            byte[] arr = String.valueOf(num).getBytes();
            int l = arr.length;
            for (int i = 0; i < l/2; i++) {
                if (arr[i] != arr[l - i - 1]) { return false; }
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
