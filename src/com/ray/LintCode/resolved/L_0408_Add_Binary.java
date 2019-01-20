package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 字符串格式的二进制加法
 *
 * @author rays1
 *
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
