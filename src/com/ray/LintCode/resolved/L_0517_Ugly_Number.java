package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 检测是否是丑数
 *
 * 丑数是正整数，其质因数只包含 2 3 5.
 * 例如:6 8 是丑数，而 14 不是，因为其包含质因数 7 
 *
 * @author rays1
 *
 */
public class L_0517_Ugly_Number {

    static class Solution {
    
        public boolean isUgly(int num) {
            if (num == 0) {
                return false;
            }
            int[] factors = {2, 3, 5};
            for (int factor : factors) 
                while (num % factor == 0) {
                    num /= factor;
                }
            return Arrays.binarySearch(factors, num) >= 0 || num == 1;
        }
        
    }
    
    public static void main(String[] args) {
        
        int num = 0;
        
        Out.p(new Solution().isUgly(num));
        
    }

}
