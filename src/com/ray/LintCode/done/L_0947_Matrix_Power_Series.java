package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a n × n matrix A and a positive integer k and a positive integer m, find the sum S = A + A^2 + A^3 + … + A^k,
 *      return the elements of S modulo m
 *      
 *      给定一个 n*n 的矩阵 A ，正整数 k 和正整数 m ，求 S = ∑ A ^ i，返回 S 中的元素 mod m 之后的矩阵
 *
 * 用例：
 *      **用例 1:**
 *      ```
 *      输入:
 *      [[0,1],[1,1]]
 *      2
 *      4
 *      输出:
 *      [[1,2],[3,4]]
 *      
 *      **用例 2:**
 *      输入:
 *      [[1,1],[1,1]]
 *      7
 *      10
 *      输出:
 *      [[7,7],[7,7]]
 *      
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/matrix-power-series/description
 * @date   2019-07-21 23:47:07
 */
public class L_0947_Matrix_Power_Series {

    /**
     * 
     *  |1 A| x |1 A|  =  |1 A^2+A|
     *  |0 A|   |0 A|     |0 A^2  |
     *  
     *  |1 A^2+A| x |1 A| = |1 A^3 + A^2 + A|
     *  |0 A^2  |   |0 A|   |0 A^3          |
     * 
     * 设 
     *      S = |1 A| T = |A 0|
     *          |0 A|     |A 0|
     * 
     *      S * T = |A^2+A, 0| 
     *              |  A^2, 0|
     * 因此
     *  A + A^2 + ... + A^i = S ^ i {右上角部分} 
     *                      = S ^ (i-1) * T (左上角部分)
     * @author rays1
     *
     */
    static class Solution {
    
        int mod;
        
        public int[][] matrixPowerSeries(int[][] A, int k, int m) {
            
            mod = m;
            int n = A.length;
            int l = 2*n;
            int[][] S = new int[l][l];
            int[][] T = new int[l][l];
            
            buildS(A, S);
            buildT(A, T);
            S = mutiply( power(S,k-1), T);
            
            int[][] ret = new int[n][n];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    ret[i][j] = S[i][j];
                }
            }
            return ret;
        }
        
        private void buildT(int[][] A, int[][] T) {
            for(int i = 0;i<A.length;i++){
                for(int j = 0;j<A.length;j++){
                    T[i][j] = A[i][j];
                    T[A.length+i][j] = A[i][j];

                }
            }
        }

        public void buildS(int[][] A, int[][] S) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (i == j) {
                        S[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    S[i][A.length + j] = A[i][j];
                    S[A.length + i][A.length + j] = A[i][j];
                }
            }
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
    
    /**
     *      输入:
     *      [[0,1],[1,1]]
     *      2
     *      4
     *      输出:
     *      [[1,2],[3,4]]
     *      
     *      **用例 2:**
     *      输入:
     *      [[1,1],[1,1]]
     *      7
     *      10
     *      输出:
     *      [[7,7],[7,7]]
     * @param args
     */
    public static void main(String[] args) {
        int[][] A = {
                {1, 1},
                {1, 1}
        };
        int k = 2;
        int m = 10;
        
        Out.p(new Solution().matrixPowerSeries(A, k, m), "%s ");
        
    }

}
