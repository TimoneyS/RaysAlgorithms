package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      In the Fibonacci integer sequence, F0 = 0, F1 = 1, and Fn = Fn − 1 + Fn − 2 for n ≥ 2. For example, 
 *      the first ten terms of the Fibonacci sequence are:0,1,1,2,3,5,8,13,21,34,…
 *      An alternative formula for the Fibonacci sequence is:
 *                  |Fn+1  Fn  | = |1 1| ^ n
 *                  |Fn    Fn-1|   |1 0|
 *      Given an integer n, your goal is to compute the last 4 digits of Fn
 *
 * 用例：
 *      **用例1**
 *      输入: n = 9
 *      输出: 34
 *      
 *      **用例2**
 *      输入: n = 30
 *      输出: 2040
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/fibonacci-ii/description
 * @date   2019-07-22 01:11:04
 */
public class L_0949_Fibonacci_II {

    /**
     * 利用矩阵快速幂 参考 L_0947_Matrix_Power_Series
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        int mod;
        
        public String lastFourDigitsOfFn(int n) {
            
            if (n == 0) return "0";
            
            mod = 10000;
            int[][] f = {
                    {1, 1},
                    {1, 0}
            };
            
            f = power(f, n);
            
            return String.format("%04d", f[0][1]);
        }
        
        // 矩阵乘法
        public int[][] mutiply(int[][] a, int[][] b){
            int[][] temp = new int[a.length][a.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    for (int k = 0; k < a.length; k++) {
                        temp[i][j] += (a[i][k] * b[k][j] % mod);
                        temp[i][j] %= mod;
                    }
                }
            }
            return temp;
        }
        
        // 矩阵求幂
        public int[][] power(int[][] mA, int a) {
            int[][] mB = new int[mA.length][mA.length];
            
            for(int i = 0; i < mA.length; ++i) {
                for(int j = 0; j < mA.length; ++j) {
                    mB[i][j] = (i == j ? 1 : 0);
                }
            }
            
            while(a > 0) {
                if((a & 1) == 1) {
                    mB = mutiply(mB, mA);
                }
                mA = mutiply(mA, mA);
                a /= 2;
            }
            return mB;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 9;
        
        Out.p(new Solution().lastFourDigitsOfFn(n));
        
    }

}
