package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 *
 *两个正整数 num1 和 num2 用字符串格式存储，返回 num1 和 num2 的乘积
 *
 * @author rays1
 *
 */
public class L_0656_Multiply_Strings {

    static class Solution {
    
        public String multiply(String num1, String num2) {
            int[] rs = new int[num1.length()+num2.length()+2];
            Arrays.fill(rs, 0);
            for (int i = num1.length()-1; i >= 0; i --) {
                int deviation = rs.length - num1.length() + i;
                for (int j = num2.length()-1; j >= 0; j--) {
                    add(rs,   deviation, (num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                    deviation--;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            int start = -1;
            while (start < rs.length-1) if (rs[++start] > 0) break;
            for (int i = start; i < rs.length; i++)
                sb.append(rs[i]);
            
            return sb.toString();
        }

        private void add(int[] rs, int deviation, int num) {
            int prev = num;
            for (int i = deviation; i >= 0; i--) {
                rs[i] += prev;
                if (rs[i] < 10) break;
                prev = rs[i] / 10;
                rs[i] = rs[i]% 10;
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        String num1 =   "0";
        String num2 =   "0";
        
        Out.p(new Solution().multiply(num1, num2));
        
    }

}
