package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two non-negative integers `num1` and `num2` represented as string, return the sum of `num1` and `num2`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : num1 = "123", num2 = "45"
 *      Output : "168"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/add-strings/description
 * @date   2019-07-11 18:35:08
 */
public class L_0655_Add_Strings {

    static class Solution {
        
        public String addStrings(String num1, String num2) {
            char[] chars = new char[Math.max(num1.length(), num2.length()) + 1];
            int cursor = chars.length;
            int prev = 0, deviation = '0' * 2;
            
            for (int i1 = num1.length()-1, i2 = num2.length()-1; i1 >= 0 || i2 >= 0; i1 --, i2 --) {
                char c1 = i1 >= 0 ? num1.charAt(i1) : '0';
                char c2 = i2 >= 0 ? num2.charAt(i2) : '0';
                
                int sum = c1 + c2 + prev - deviation;
                chars[--cursor] = (char) (sum % 10 + '0');
                prev = sum / 10;
            }
            if (prev > 0)
                chars[--cursor] = (char) (prev + '0');
            return new String(chars, cursor, chars.length - cursor);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
