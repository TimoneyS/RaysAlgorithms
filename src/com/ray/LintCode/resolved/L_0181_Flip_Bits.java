package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Determine the number of bits required to flip if you want to convert integer n to integer m.
 *
 * 推断将 n 翻转为 m 所需翻转的位数。
 * n = 31 (11111), m = 14 (01110), 返回 2.
 *
 * @author rays1
 *
 */
public class L_0181_Flip_Bits {

    static class Solution {
        public int bitSwapRequired(int a, int b) {
            int c = 0;
            String s = Integer.toBinaryString(a^b);
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '1') c ++;
            return c;
        }
    }

    public static void main(String[] args) {
        
        int a = 31;
        int b = 14;
        
        Out.p(new Solution().bitSwapRequired(a, b));
        
    }
    
}
