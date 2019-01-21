package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 反转整数的数字。 反转整数溢出时返回0（带符号的32位整数）。
 *
 *
 * @author rays1
 *
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
