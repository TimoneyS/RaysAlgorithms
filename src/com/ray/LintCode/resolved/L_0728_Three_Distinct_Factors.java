package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个正整数 n (1 <= n <= 10^18)。检查数字是否只有三个不同的因子。
 *
 * 示例
 *      输入
 *          n = 9
 *          9 只有三个因子 1 3 9 返回 true
 *
 * @author rays1
 *
 */
public class L_0728_Three_Distinct_Factors {

    /**
     * 数字是平方数，且根为质数
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isThreeDisctFactors(long n) {
            if (n <= 1) return false;
            long fac = (long) Math.sqrt(n);
            return fac * fac == n && isPrim(fac);
        }
        
        public boolean isPrim(long n) {
            if (n == 2) return true;
            
            for (long i = 3; i < n/2; i++) {
                if (n%i == 0) return false;
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 216;
        Out.p(new Solution().isThreeDisctFactors(n));
        
    }

}
