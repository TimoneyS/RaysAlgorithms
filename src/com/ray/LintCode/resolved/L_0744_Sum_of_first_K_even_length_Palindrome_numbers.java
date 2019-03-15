package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个整数 k, 得出前 k 个偶数长度的回文数和. 这里的偶数长度是指一个数字的位数为偶数.
 *
 * 如 k = 3 返回 11 + 22 + 33 = 66
 *
 * @author rays1
 *
 */
public class L_0744_Sum_of_first_K_even_length_Palindrome_numbers {

    /**
     * next 方法是从中间开始加 1
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int sumKEven(int k) {
            int sum = 0;
            int n = 11;
            for (int i = 1; i <= k; i ++) {
                sum += n;
                n = next(n);
            }
            return sum;
        }
        
        private int next(int num) {
            num = (int) (num/Math.pow(10, (int) (Math.log10(num) + 1)/2)) + 1;
            int t = num;
            while (t != 0) {
                num = num * 10 + t % 10;
                t /= 10;
            }
            return num;
        }
    
    }
    
    public static void main(String[] args) {
        int num = 10;
//        Out.p(new Solution().next(99));
        Out.p(new Solution().sumKEven(num));
    }

}
