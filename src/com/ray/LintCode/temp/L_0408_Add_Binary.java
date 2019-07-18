package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two binary strings, return their sum (also a binary string).
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      a = "0", b = "0"
 *      Output:
 *      "0"
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:
 *      a = "11", b = "1"
 *      Output:
 *      "100"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/add-binary/description
 * @date   2019-07-11 18:32:38
 */
public class L_0408_Add_Binary {


    static class Solution {
        
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            
            int s1 = a.length()-1, s2 = b.length()-1;
            
            char prev = '0';
            while (s1 >= 0 || s2 >= 0) {
                
                char c1 = s1 >= 0 ? a.charAt(s1--) : '0';
                char c2 = s2 >= 0 ? b.charAt(s2--) : '0';                
                
                char rs = '0';
                if (c1 == c2) {
                    rs = prev;
                    prev = c1;
                } else {
                    rs = (prev == '0') ? '1' : '0'; 
                }
                sb.insert(0, rs);
            }
            
            if (prev == '1')
                sb.insert(0, prev);
            
            return sb.toString();
        
        }
    
    }
    
    public static void main(String[] args) {
        
        String a = "111";
        String b = "11";
        
        Out.p(new Solution().addBinary(a, b));
        
    }


}
