package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 两个正整数 num1 和 num2 用字符串格式存储，返回 num1 和 num2 的和
 * 
 * @author rays1
 *
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
        
        String num1 = "123";
        String num2 = "45";
        
        Out.p(new Solution().addStrings(num1, num2));
        
    }

}
