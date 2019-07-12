package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string containing uppercase alphabets and integer digits (from `0` to `9`), write a function to return the alphabets in the order followed by the sum of digits.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : str = "AC2BEW3"
 *      Output : "ABCEW5"
 *      Explanation : 
 *      Alphabets in the lexicographic order, followed by the sum of integers(2 and 3).
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rearrange-a-string-with-integers/description
 * @date   2019-07-11 18:35:46
 */
public class L_0720_Rearrange_a_String_With_Integers {

    static class Solution {
        
        public String rearrange(String str) {
            byte[] bytes = str.getBytes();
            Arrays.sort(bytes);
            int cursor = 0, rs = 0;
            while (cursor < bytes.length) {
                if (bytes[cursor] > '9') break;
                rs += bytes[cursor] - '0';
                cursor++;
            }
            
            StringBuilder sb = new StringBuilder();
            while (cursor < bytes.length) {
                sb.append((char)bytes[cursor++]);
            }
            if(str.length() > 0) sb.append(rs);
            
            return sb.toString();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
