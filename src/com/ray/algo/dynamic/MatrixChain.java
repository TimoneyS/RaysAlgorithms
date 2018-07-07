package com.ray.algo.dynamic;

import com.ray.io.Out;

/**
 * ������������
 * @author rays1
 *
 */
public class MatrixChain {
    
    public MatrixChain(int[] p) {
        
        int n = p.length-1;
        
        int[][] A = new int[n+1][n+1];  // A[i][j]��ʾ�������У��� A[i] ��  A[j] ����С�������
        int[][] S = new int[n+1][n+1];  // S[i][j]��ʾ�������У��� A[i] ��  A[j] �ĶϿ�λ��
        
        // ��ʼ��
        for (int i = 1; i <= n; i++) A[i][i] = 0;
        
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r +1; i++) {
                
                int j = i + r - 1;
                
                A[i][j] = A[i+1][j] + p[i-1]*p[i]*p[j];
                S[i][j] = i;
                
                for (int k = i+1; k < j; k++) {
                    int t = A[i][k] + A[k+1][j] + p[i-1]*p[k]*p[j];
                    if (t < A[i][j]) {
                        A[i][j] = t;
                        S[i][j] = k;
                    }
                }
                
            }
        }
        
        Out.p(split(S, 1, n));
        
        Out.p(A[1][n]);
        
    }
    
    private String split(int[][] S, int i, int j) {
        if (i == j) return "A" + i;
        
        int k = S[i][j];
        
        String left  = split(S, i, k);
        String right = split(S, k+1, j);        
        
        if (!left.matches("A\\d+")) left = "(" + left + ")";
        if (!right.matches("A\\d+")) right = "(" + right + ")";        
        return left + "*" + right;
    }
    
    /**
     * ����˷�
     * @param a
     * @param b
     * @return
     */
    public int[][] matrixMulyiply(int[][] a, int[][] b) {

        int ra = a.length;
        int ca = a[0].length;

        int rb = b.length;
        int cb = b[0].length;

        if (ca != rb)
            throw new IllegalArgumentException("���󲻿ɳ�");

        int[][] rs = new int[ra][cb];
        
        for (int i = 0; i < ra; i++) {
            for (int j = 0; j < cb; j++) {
                rs[i][j] = 0;
                for (int k = 0; k < rb; k++) {
                    rs[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        
        return rs;
    }

    public static void main(String[] args) {
        
        int[] p = {3,8,2,1,4,8,7,5,1,9,2,8,4,2,4};
        
        new MatrixChain(p);
        
    }

}
