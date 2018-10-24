package com.ray.algorithms.dynamic;

import com.ray.io.Out;

/**
 * 基于接缝裁剪的图像压缩
 * @author rays1
 *
 */
public class SeamCarving {
    
    private static final char R = 'R';
    private static final char G = 'G';
    private static final char B = 'B';
    private static final char N = ' ';
    
    private int[][] memorized;
    private int[][] seamPixe;   // 对应以 纵坐标 为 j 的像素 为首的 接缝，每一行像素的纵坐标
    private int[] result;
    private int[][] d;
    private int m;
    private int n;

    public SeamCarving(char[][] pic) {
        
        m = pic.length;
        n = pic[0].length;
        
        computePixPower(pic);
        seamPixe = new int[m][n];
        
        Out.pf("m=%s, n = %s\n", m, n);
        result = new int[n];
        
        for (int c = 1; c < n-1; c ++) {
            initMemorized();
            result[c] = seamPower(c, m-2, c);
        }
        
        printSeamPixe();
        
    }

    private int seamPower(int start, int i, int j) {
        
        if (memorized[i][j] == -1) {
            
            if (i <= 1) {
                memorized[i][j] = d[i][j];
            } else {
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
                
                if (j > 1)
                    a = seamPower(start, i - 1, j - 1); 
                b = seamPower(start, i-1, j);
                if (j < n-2)
                    c = seamPower(start, i - 1, j + 1);
                
                if (a < b && a < c) {
                    // a 最小
                    seamPixe[i-1][start] = j-1;    
                } else if (b < c && b < a) {
                    // b 最小
                    seamPixe[i-1][start] = j;
                } else {
                    // c 最小
                    seamPixe[i-1][start] = j+1;
                }
                
                memorized[i][j] = d[i][j] + Math.min(Math.min(a, b), c);
            }
        }
        return memorized[i][j];
    }
    
    public void computePixPower(char[][] pic) {
        d = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (i < 1 || j < 1 || i > m-2 || j > n-2) {
                    d[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                char C = pic[i][j];
                int e = 9;
                
                // 上下方两个像素
                if (pic[i-1][j] == C) e --;
                if (pic[i+1][j] == C) e --;
                // 左右两个像素
                if (pic[i][j-1] == C) e --;
                if (pic[i][j+1] == C) e --;
                
                d[i][j] = e;
            }
        }
    }
    
    public void showPixPower() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == Integer.MAX_VALUE)
                    Out.pt("N ");
                else
                    Out.pt(d[i][j] + " ");
            }
            Out.p();
        }
    }
    
    public void initMemorized() {
        memorized = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memorized[i][j] = -1;
            }
        }
    }
    
    public void printSeamPixe() {
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Out.pt(seamPixe[i][j] + " ");
            }
            Out.p();
        }
        
        int minIndex = 1;
        for (int i = 1; i <= n-2; i++) {
            if (result[i] < result[minIndex]) minIndex = i;
        }
        
        Out.pf("delete( %s, %s)\n", m-2, minIndex);
        for (int i = m - 3; i > 0; i --) {
            int j = seamPixe[i][minIndex];
            
            Out.pf("delete( %s, %s)\n", i, j);
            
        }
        
    }
    
    public void showMemorized() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memorized[i][j] == -1)
                    Out.pt(" N ");
                else
                    Out.pf("%2s " , memorized[i][j]);
            }
            Out.p();
        }
        Out.sep();
    }
    
    public static void main(String[] args) {
        
        char[][] pic = {
                { N, N, N, N, N, N, N, N, N },
                { N, R, R, R, R, R, R, R, N },
                { N, R, R, B, R, R, R, R, N },
                { N, R, G, B, G, R, R, R, N },
                { N, G, G, B, G, G, R, R, N },
                { N, R, R, B, R, R, R, R, N },
                { N, N, N, N, N, N, N, N, N }
        };
        
        new SeamCarving(pic);
        
    }
    
}
