package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Implement function atoi to convert a string to an integer.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * If the correct value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * <p>
 * "10" => 10
 * "-1" => -1
 * "123123123123123" => 2147483647
 * "1.0" => 1
 * 
 * @author rays1
 *
 */
public class L_0054_String_to_Integer_atoi {

    static class Solution {
        /**
         * @param str: A string
         * @return: An integer
         */
        public int atoi(String str) {
            
            int rs = 0;
            boolean is_limit = false;
            boolean is_neg = false;
            int i = 0;
            
            while (i < str.length()) {
                char c = str.charAt(i);
                if (c == '+') {
                    i++;
                    break;
                } else if (c == '-') {
                    i++;
                    is_neg = true;
                    break;
                } else if (c > 47 && c < 59) {
                    break;
                } else if (c == ' ') {
                    i++;
                } else {
                    break;
                }
            }
            
            while (i < str.length()) {
                char c = str.charAt(i);
                i++;
                
                if (c < 48 || c > 58) {break;}
                
                if (is_limit) continue;
                
                if (is_neg) {
                    int t = rs * 10 - c + 48;
                    if (t > 0) {
                        rs = Integer.MIN_VALUE;
                        is_limit = true;
                    } else {
                        rs = t;
                    }
                } else {
                    int t = rs * 10+(c-48);
                    if (t < 0) {
                        rs = Integer.MAX_VALUE;
                        is_limit = true;
                    } else {
                        rs = t;
                    }
                }
                
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        String str = " 2147483648";
        
        int rs = new Solution().atoi(str);
        
        Out.p(rs);
        
    }

}
