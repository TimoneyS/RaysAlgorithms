package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 数组模拟 10 进制加法
 *
 * [1,2,3] 表示 123, 返回 [1,2,4].
 * [9,9,9] 表示 999, 返回 [1,0,0,0].
 * @author rays1
 *
 */
public class L_0407_Plus_One {

    static class Solution {
    
        public int[] plusOne(int[] digits) {
            
            int post = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] + 1 < 10) {
                    digits[i] ++;
                    post = 0;
                } else {
                    digits[i] = 0;
                }
                if (post == 0) break;
            }
            
            if (post == 1) {
                int[] newNum = new int[digits.length + 1];
                newNum[0] = 1;
                for (int i = 1; i < newNum.length; i++) {
                    newNum[i] = digits[i-1];
                }
                return newNum;
            }
            return digits;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] digits = {9};
        Out.p(new Solution().plusOne(digits));
        
    }

}
