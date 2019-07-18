package com.ray.LintCode.temp;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      "123"
 *      "45"
 *      Output:
 *      "5535"
 *      Explanation:
 *      123 x 45 = 5535
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      "0"
 *      "0"
 *      Output:
 *      "0"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/multiply-strings/description
 * @date   2019-07-11 18:35:09
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
        
        Out.p(new Solution());
        
    }

}
