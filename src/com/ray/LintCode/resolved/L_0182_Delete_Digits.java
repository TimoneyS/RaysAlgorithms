package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 字符串 A 表示一个正整数，从中任意删除k个数字，剩下的数字可以构成一个新的数字。
 * 返回最小的删除数字后的最小的新数字
 * N <= 240 and k <= N,
 *
 * 如 A = "178542", k = 4 返回 12 "12"
 *
 * @author rays1
 *
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
