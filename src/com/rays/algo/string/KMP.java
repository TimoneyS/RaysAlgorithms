package com.rays.algo.string;

import com.ray.io.Out;

/**
 * KMP 算法
 * @author rays1
 *
 */
public class KMP {
    
    private int[][] dfa;
    private int M;
    
    public KMP(String pat) {
        this(pat, 255);
    }
    
    public KMP(String pat, int R) {
        this.M = pat.length();
        this.dfa = new int[R][pat.length()];
        
        int x = 0;
        
        dfa[0][0] = 1;
        for (int j = 1; j < pat.length(); j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            }
            dfa[pat.charAt(j)-65][j] = j+1;
            
            x = dfa[pat.charAt(j)-65][x];
        }
        
    }
    
    public int seach(String s) {
        
        int N = s.length();
        
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[s.charAt(i)-65][j];
        
        if (j == M)
            return i - M;
        else
            return N;
    }
    
    public static void main(String[] args) {
        KMP s = new KMP("ABABAC", 3);

        Out.p(s.dfa, "%2d ");
        String str = "AAAABAAAAABABACACABAAAABBC";
        
        Out.p(s.seach(str));
    }
    
}
