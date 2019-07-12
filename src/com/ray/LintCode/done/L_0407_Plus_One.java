package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a non-negative number represented as an array of digits, plus one to the number.
 *      
 *      The digits are stored such that the most significant digit is at the head of the list.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: [1,2,3]
 *      Output: [1,2,4]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: [9,9,9]
 *      Output: [1,0,0,0]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/plus-one/description
 * @date   2019-07-11 18:32:37
 */
public class L_0407_Plus_One {

    static class Solution {
        
        public int[] plusOne(int[] digits) {
            
            int post = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] + 1 < 10) {
                    digits[i] ++;
                    post = 0;
                } else {
                    digits[i] = 0;
                }
                if (post == 0) break;
            }
            
            if (post == 1) {
                int[] newNum = new int[digits.length + 1];
                newNum[0] = 1;
                for (int i = 1; i < newNum.length; i++) {
                    newNum[i] = digits[i-1];
                }
                return newNum;
            }
            return digits;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] digits = {9};
        Out.p(new Solution().plusOne(digits));
        
    }

}
