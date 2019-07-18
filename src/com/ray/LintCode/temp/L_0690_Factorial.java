package com.ray.LintCode.temp;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a number n, return the factorial of the number as a string.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: 0
 *      Output: "1"
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: 20
 *      Output: "2432902008176640000"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/factorial/description
 * @date   2019-07-11 18:35:31
 */
public class L_0690_Factorial {


    /**
     * 参考了 L_0656_Multiply_Strings 的 字符串相乘
     * 
     * 理论上来说这里的复杂度是平方级别，可优化空间较大
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String factorial(int n) {
            
            if (n == 0) return "1";
            
            String prev = n+"";
            while (--n > 1) {
                prev = multiply(prev, (n)+"");
            }
            
            
            return prev;
        }
        
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
