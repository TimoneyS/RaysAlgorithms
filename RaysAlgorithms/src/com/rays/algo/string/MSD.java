package com.rays.algo.string;

public class MSD {
    
    public void sort(String[] a, int s, int e) {
        
        int w = a[0].length();
        int R = 255;
        int[] counts = new int[R + 1];
        
        // ¼üË÷ÒıÅÅĞò
        for (int i = s; i <= e; i++) {
            counts[a[i].charAt(0) + 1] ++;
        }
        for (int i = 0; i < R; i++) {
            counts[i+1] += counts[i];
        }
        String[] aux = new String[e-s+1];
        for (int i = s; i <= e; i++) {
            aux[counts[a[i].charAt(0)]++] = a[i];
        }
        
    }
    
    public static void main(String[] args) {
        
        
    }
    
}
