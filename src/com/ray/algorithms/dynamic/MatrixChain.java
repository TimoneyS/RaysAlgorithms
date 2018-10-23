package com.ray.algorithms.dynamic;

import java.util.Random;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 *  矩阵链乘法问题
 *  求最优加括号方案，以得到最小乘积次数。
 * @author rays1
 *
 */
public class MatrixChain {
    
    static class MatrixChainBottomUp {
        
        private int[][] A;
        private int[][] S;
        
        public MatrixChainBottomUp(int[] P) {
            
            int n = P.length-1;
            A = new int[n+1][n+1];
            S = new int[n+1][n+1]; 
            for (int i = 0; i <= n; i++) {
                A[i][i] = 0;
                S[i][i] = i;
            }
            
            for (int l = 2; l <= n; l++) {
                for (int i = 1; i <= n - l + 1; i++) {
                    int j = i + l - 1;
                    A[i][j] = Integer.MAX_VALUE;
                    // 对任意i、j，k在i、j之间。A[i][j]为 所有可能的k中，
                    // 计算 A[i][k] + A[k+1][j] + P[i-1]*P[k]*P[j] 的最小值
                    for (int k = i; k <= j - 1; k++) {
                        int temp = A[i][k] + A[k+1][j] + P[i-1] * P[k] * P[j];
                        if (A[i][j] > temp) {
                            A[i][j] = temp;
                            S[i][j] = k;
                        }
                    }
                }
            }
            
//            partion(1, n);
//            Out.p();
            
        }
        
    }
    
    static class MatrixChainMemorized {
        
        private int[][] A;
        private int[][] S;
        
        public MatrixChainMemorized(int[] P) {
            
            int n = P.length-1;
            A = new int[n+1][n+1];
            S = new int[n+1][n+1];
            
            for (int i = 0; i < A.length; i++) {
                for (int j = i+1; j < A[i].length; j++) {
                    A[i][j] = -1;
                }
            }
            
            for (int i = 0; i <= n; i++) {
                S[i][i] = i;
                A[i][i] = 0;
            }
            
            cacu(P, 1, n);
            
//            partion(1, n);
//            Out.p();
            
        }
        
        public int cacu(int[] P, int i, int j) {
            
            if (A[i][j] != -1)
                return A[i][j];
            else {
                for (int k = i; k < j; k ++) {
                    int l = cacu(P,   i, k);
                    int r = cacu(P, k+1, j);
                    int temp = l + r + P[i-1]*P[k]*P[j];
                    if (A[i][j] == -1 || A[i][j] > temp) {
                        A[i][j] = temp;
                        S[i][j] = k;
                    }
                }
            }
            return A[i][j]; 
            
        }
        
    }
    
    
    /**
     * 矩阵相乘的算法
     * @param A
     * @param B
     * @return
     */
    public int[][] matrixMutiply(int[][] A, int[][] B) {
        
        int ra = A.length;
        int ca = A[0].length;
        
        int rb = B.length;
        int cb = B[0].length;
        
        if (ca != rb) throw new IllegalArgumentException("Matrix cannot mutiply");
        
        int[][] rs = new int[ra][cb];
        
        for (int i = 0; i < rs.length; i++) {
            for (int j = 0; j < rs[i].length; j++) {
                rs[i][j] = 0;
                for (int k = 0; k < ca; k++) {
                    rs[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return rs;
    }
    
    public static void main(String[] args) {
        
        int n = 1250;
        
        int[] P = new int[n+1];
        Random r = new Random(42);
        
        for (int i = 0; i < P.length; i++) {
            P[i] = r.nextInt(5) + 2;
        }
        
        for (int i = 0; i < 10; i++) {
            Timer t = Timer.create();
            t.click();
            new MatrixChainBottomUp(P);
            t.stop();
        }

//        t.click();
//        new MatrixChainMemorized(P);
             
        
    }
    
}
