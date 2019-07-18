package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: 123
 *      Output: 321
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: -123
 *      Output: -321
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-integer/description
 * @date   2019-07-11 18:32:45
 */
public class L_0413_Reverse_Integer {


    /**
     * 偷懒的解法时用double存储反转后的数字
     * 实际上用int类型也可以，只是处理溢出的方法比较麻烦
     * @author rays1
     *
     */
    static class Solution {
    
        public int reverseInteger(int n) {
            boolean isPos = n > 0;
            if (n < 0) n = -n;
            double d = 0;
            while (n > 0) {
                d = d*10 + n %10;
                n = n / 10;
            }
            d = isPos ? d : -d;
            if (d > Integer.MAX_VALUE || d < Integer.MIN_VALUE) d = 0;
            return (int)d;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 2147483647;
        
        Out.p(new Solution().reverseInteger(n));
        
    }
}
