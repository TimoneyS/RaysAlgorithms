package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given string A representative a positive integer which has _N_ digits, remove any _k_ digits of the number, the remaining digits are arranged according to the original order to become a new positive integer.
 *      
 *      Find the **smallest** integer after remove *k* digits.
 *      
 *      _N_ <= 240 and _k_ <= _N_,
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: A = "178542", k = 4
 *      Output:"12"
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: A = "568431", k = 3
 *      Output:"431"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/delete-digits/description
 * @date   2019-07-11 18:31:41
 */
public class L_0182_Delete_Digits {

    static class Solution {
        public String DeleteDigits(String A, int k) {
            
            int N = A.length();
            int C = N - k;
            
            StringBuilder sb = new StringBuilder();
            
            int start = 0, end = k;
            for (int i = 0;  i < C; i++) {
                int min = start;
                for (int j = start; j <= end; j ++) {
                    if (A.charAt(min) > A.charAt(j)) {
                        min = j;
                    }
                }
                if (sb.length() != 0 || sb.length() == 0 && A.charAt(min) != '0')
                sb.append(A.charAt(min));
                end ++;
                start = min + 1;
            }
            
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        
        String A = "18728490081378924794978133901201029120111111292221983981398198391";
        int    k = 14;
        
        Out.p(new Solution().DeleteDigits(A, k));
        
    }

}
