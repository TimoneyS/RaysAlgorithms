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
        dfa[pat.charAt(0)][0] = 1;
        for (int j = 1; j < pat.length(); j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            }
            dfa[pat.charAt(j)][j] = j+1;
            x = dfa[pat.charAt(j)][x];
        }
        
    }
    
    public int seach(String s) {
        int i, j;
        for (i = 0, j = 0; i < s.length() && j < M; i++)
            j = dfa[s.charAt(i)][j];
        return j == M ? i - M : -1;
    }
    
    public static void main(String[] args) {
        KMP s = new KMP("ab");

        String str = "aab";
        
        Out.p(s.seach(str));
    }
    
}
