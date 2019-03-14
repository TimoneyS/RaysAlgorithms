package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给出两个数 A 和 B，其中 B >= A，F = B! / A! ( 1 <= A, B <= 10^18, A 和 B 非常大)
 * 计算结果 F 的最后一位数
 * @author rays1
 *
 */
public class L_0729_Last_Digit_By_Factorial_Divide {

    /**
     * 
     * F = (A+1) * (A + 2) * ... * B
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int computeLastDigit(long A, long B) {
            if (B-A>4) return 0;
            int rs = 1;
            while (++A<=B) {
                rs *= (int) (A % 10);
            }
            return rs % 10;
        }
    
    }
    
    public static void main(String[] args) {
        
        int A = 107;
        int B = 109;
        Out.p(new Solution().computeLastDigit(A, B));
        
    }

}
