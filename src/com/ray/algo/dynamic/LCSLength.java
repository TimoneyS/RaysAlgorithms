package com.ray.algo.dynamic;

import java.util.Random;

import com.ray.util.Timer;

/**
 * 最大公共子序列问题
 * @author rays1
 *
 */
public class LCSLength {
    
    private int[][] C;
    private int m,n;
    private int[] LCS;
    
    public LCSLength(int[] X, int Y[]) {
        
        m = X.length;
        n = Y.length;
        
        C = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) { C[i][0] = 0; }
        for (int i = 1; i <= n; i++) { C[0][i] = 0; }        
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i-1] == Y[j-1]) {
                    C[i][j] = C[i-1][j-1] +1;
                } else {
                    C[i][j] = C[i-1][j];
                    if (C[i][j] < C[i][j-1])
                        C[i][j] = C[i][j-1];
                }
            }
        }
        
//        LCS(X, Y);
        
//        for (int[] is : C) {
//            for (int i : is) {
//                Out.pt(i + " ");
//            }
//            Out.p();
//        }
        
//        Out.p(Arrays.toString(LCS));
        
    }

    public void LCS(int[] X, int Y[]) {
        
        int[] temp = new int[n];
        int cursor = 0;
        
        for (int i = 1; i <= n; i++) { 
            if (C[m-1][i] != C[m-1][i-1]) {
                temp[cursor ++] = Y[i-1];
            }
        }
        LCS = new int[cursor];
        for (int i = 0; i < cursor; i++) {
            LCS[i] = temp[i];
        }
    }
    
    public static void main(String[] args) {
        
        int m = 10000;
        int n = 2000;
        
        int[] X = new int[m];
        int[] Y = new int[n];
        
        Random r = new Random(42);
        for (int i = 0; i < m; i++) {
            X[i] = r.nextInt(10);
        }
        
        for (int i = 0; i < n; i++) {
            Y[i] = r.nextInt(10);
        }
        
//        int[] X = { 1,2,3,4,5,6,7,8,9};
//        int[] Y = { 2,4,3,2,5,7,4,5,6 };
        Timer t = Timer.create();
        
        t.click();
        new LCSLength(X, Y);
        t.stop();
    }
    
    
}
