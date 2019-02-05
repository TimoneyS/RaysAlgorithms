package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 非负整数 num，不断的将每位数字相加，直到只剩下一位数字
 *
 * @author rays1
 *
 */
public class L_0569_Add_Digits {

    static class Solution {
    
        public int addDigits(int num) {
            int t = 0;
            while (num > 0) {
                if (num < 10) {
                    num += t;
                    t = 0;
                    if (num < 10) break;
                } else {
                    t += num %10;
                    num /= 10;
                }
            }
            return num;
        }
    }
    
    public static void main(String[] args) {
        
        int num = 19;
        
        Out.p(new Solution().addDigits(num));
        
    }

}
