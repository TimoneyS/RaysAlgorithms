package com.ray.algorithms.dynamic;

import java.util.Random;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 最长回文子序列
 * @author rays1
 *
 */
public class MaxPalindrome {
    
    private boolean[] marked;
    private int[][] length;
    
    public MaxPalindrome(String s) {
        
        int n = s.length();
        
        marked = new boolean[n];
        length = new int[n][n];
        
        for (int i = 0; i < marked.length; i++)
            marked[i] = false;
        
        for (int i = 0; i < n; i++ ) {
            for (int j = i; j < n; j++ ) {
                length[i][j] = -1;
            }
        }
        
        palindromeLength(s.toCharArray(), 0, n - 1, 1);
        
        int i = 0;
        int j = n-1; 
        while (true) {
            if (i>j) break; 
            if (length[i][j-1] == length[i][j]) {
                j --;
            } else if (length[i+1][j] == length[i][j]) {
                i ++;
            } else {
                marked[i] = true;
                marked[j] = true;
                i ++;
                j --;
            }
        }
        
    }
    
    public void printPalindrome(String s) {
        for (int k = 0; k < marked.length; k++) {
            if (marked[k])
                Out.pt(s.charAt(k));
        }
        Out.p();
    }
    
    public int palindromeLength(char[] chars, int i, int j, int deepth) {
        
        if (length[i][j] != -1) return length[i][j]; 
        
        if (i == j) {
            return 1;
        }
        if (i >  j) return 0; 
        
        if (chars[i] == chars[j]) {
            length[i][j] = palindromeLength(chars, i+1, j-1, deepth + 1) + 2;
        } else {
            length[i][j] = Math.max(
                    palindromeLength(chars, i+1, j, deepth + 1),
                    palindromeLength(chars, i, j-1, deepth + 1)
                    );
        }
        
        return length[i][j];
    }
    
    public static void main(String[] args) {
        
        int size = 4000;
        
        StringBuilder sb = new StringBuilder();
        Random r = new Random(42);
        
        for (int i = 0; i < size; i++) {
            sb.append((char)(r.nextInt(26) + 97) );
        }
        
        String s = sb.toString();
        
        Timer t = Timer.create();
        
        t.click();
        MaxPalindrome m = new MaxPalindrome(s);
        t.click();
        
        t.show();
        
        m.hashCode();
        
    }
    
}  
