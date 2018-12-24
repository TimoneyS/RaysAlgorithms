package com.rays.algo.string;

import com.ray.io.Out;

/**
 * Boyer - Moore 字符串查找算法
 * @author rays1
 *
 */
public class BoyerMoore {
    
    private int[] right;
    private int M;
    private String pat;
    
    public BoyerMoore(String pat) {
        M = pat.length();
        this.pat = pat;
        
        right = new int[255];
        for (int i = 0; i < right.length; i++) right[i] = -1;
        for (int i = 0; i < M; i++) right[pat.charAt(i)] = i;
    }
    
    public int search(String txt) {
        
        int N = txt.length();
        int step;
        
        for (int i = 0; i <= N-M; i += step) {
            step = 0;
            for (int j = M-1; j >= 0; j --) {
                if (pat.charAt(j) != txt.charAt(i+j)) {
                    step = j - right[txt.charAt(i+j)];
                    step = Math.max(1, step);
                    break;
                }
            }
            if (step == 0) return i;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {

        String txt = "ABABACABACAD";
        String pat = "ABACAD";
        
        BoyerMoore bm = new BoyerMoore(pat);
        
        Out.p(bm.search(txt));
        
    }
    
}
