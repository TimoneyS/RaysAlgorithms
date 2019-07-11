package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement function `atoi` to convert a string to an integer.
 *      
 *      If no valid conversion could be performed, a _zero_ value is returned. 
 *      
 *      If the correct value is out of the range of representable values, _INT_MAX_ (2147483647) or _INT_MIN_ (-2147483648) is returned.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: "10"
 *      Output: 10
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: "1"
 *      Output: 1
 *      ```
 *      
 *      **Example 3**
 *      
 *      ```plain
 *      Input: "123123123123123"
 *      Output: 2147483647
 *      Explanation: 123123123123123 > INT_MAX, so we return INT_MAX
 *      ```
 *      
 *      **Example 4**
 *      
 *      ```plain
 *      Input: "1.0"
 *      Output: 1
 *      Explanation: We just need to change the first vaild number
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/string-to-integer-atoi/description
 * @date   2019-07-11 18:08:12
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
