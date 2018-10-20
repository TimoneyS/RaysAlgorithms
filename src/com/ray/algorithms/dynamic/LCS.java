package com.ray.algorithms.dynamic;

import com.ray.io.Out;
import com.ray.util.Timer;
import com.ray.util.collections.RaysStack;
import com.ray.util.collections.Stack;

/**
 * 
 * 最长公共子序列问题
 * 
 * @author rays1
 *
 */
public class LCS {
    
    /**
     * 表格计算法求取 LCS
     * @author rays1
     *
     * @param <T>
     */
    public static class LCSBottomUp<T extends Comparable<T>> {
        
        public LCSBottomUp(T[] X, T[] Y) {
            
            int m = X.length;
            int n = Y.length;
            
            int[][] c = new int[m+1][n+1];
            
            for (int i = 0; i <= m; i++) c[i][0] = 0;
            for (int i = 0; i <= n; i++) c[0][i] = 0;
            
            for (int i = 1; i <= m; i++) {
                
                for (int j = 1; j <= n; j++) {
                    
                    if (X[i-1].equals(Y[j-1])) {
                        c[i][j] = c[i-1][j-1] + 1;
                    } else if (c[i-1][j] >= c[i][j-1]) {
                        c[i][j] = c[i-1][j];
                    } else {
                        c[i][j] = c[i][j-1];
                    }
                    
                }
                
            }
            
            printLCS(X, Y, c);
            
        }
        
        public void printLCS(T[] X, T[] Y, int[][] c) {
            
            int i = X.length;
            int j = Y.length;
            
            Stack<T> s = new RaysStack<T>();
            
            while (i > 0 && j > 0) {
                
                int l = c[i][j];
                
                if (c[i - 1][j] == l) {
                    i--;
                } else if (c[i][j-1] == l){
                    j--;
                } else {
                    s.push(X[i-1]);
                    i--;
                    j--;
                }
                
            }
            
            while (!s.isEmpty()) {
                Out.pt(s.pop() + ", ");
            }
            Out.p();
            
        }
        
    }
    
    /**
     * 递归求取 LCS
     * @author rays1
     *
     * @param <T>
     */
    public static class LCSMemorized<T extends Comparable<T>> {
        
        private int[][] c;
        
        public LCSMemorized(T[] X, T[] Y) {
            
            int m = X.length;
            int n = Y.length;
            
            c = new int[m][n];
            
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    c[i][j] = -1;
            
            LCS(X, Y, m-1, n-1);
            
            Out.p(c[m-1][n-1]);
            
        }
        
        public int LCS(T[] A, T[] B, int i, int j) {
            
            if (i < 0 || j < 0 ) return 0;
            
            if (c[i][j] != -1) return c[i][j];
            
            if (A[i].equals(B[j])) {
                c[i][j] = LCS(A, B, i - 1, j - 1) + 1;
            } else {
                c[i][j] = Math.max(
                        LCS(A, B, i - 1, j),
                        LCS(A, B, i, j - 1)
                        );
            }
            
            return c[i][j];
            
        }
        
    }
    
    public static void main(String[] args) {
        
        
        Integer[] A = { 1, 2, 3, 4, 5};
        Integer[] B = { 1, 3, 4};
        
//        int size = 2000;
//        Integer[] A = RArrays.integerArr(size);
//        Integer[] B = RArrays.integerArr(size);
//        
//        RArrays.shuffle(A, 1);
        
        Timer t = Timer.create();
        
        t.click();
        new LCSMemorized<>(A, B);
        t.click();
        new LCSBottomUp<>(A, B);
        t.click();
        
        t.show();
        
    }
    
}
