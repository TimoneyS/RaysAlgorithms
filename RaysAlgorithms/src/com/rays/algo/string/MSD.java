package com.rays.algo.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.common.utils.In;
import com.ray.common.utils.Out;

/**
 * ¸ßÎ»ÓÅÏÈµÄ×Ö·û´®ÅÅÐò
 * @author rays1
 *
 */
public class MSD {
    
    String[] aux;
    
    /**
     * @param a
     * @param s
     * @param e
     */
    public void sort(String[] a) {
        aux = new String[a.length];
        keyIndexSord(a, 0, a.length-1, 0);
    }
    
    /**
     * @param a
     * @param d
     * @param lo
     * @param hi
     */
    public void keyIndexSord(String[] a, int lo, int hi, int d) {
        if (lo >= hi) return;
        
        int R = 255;
        int[] counts = new int[R + 2];
        
        // ¼üË÷ÒýÅÅÐò
        for (int i = lo; i <= hi; i++) {
            counts[getChar(a[i], d) + 2] ++;
        }
        for (int i = 0; i < R+1; i++) {
            counts[i+1] += counts[i];
        }
        for (int i = lo; i <= hi; i++) {
            int charIndex = getChar(a[i], d);
            aux[counts[charIndex + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i-lo];
        }
        
        // °´ÕÕÊ××ÖÄ¸µÝ¹é
        for (int i = 0; i < R; i++) {
            keyIndexSord(a, lo+counts[i], lo+counts[i+1]-1, d+1);
        }
        
    }
    
    /**
     * @param s
     * @param i
     * @return
     */
    public int getChar(String s, int i) {
        return (s.length() > i) ? s.charAt(i) : -1; 
    }
    
    public static void main(String[] args) {
        Scanner in = In.getClassPathScanner(MSD.class, "msd.txt");
        List<String> list = new LinkedList<String>();
        while (in.hasNext()) {
            list.add(in.next());
        }
        
        String[] keys = list.toArray(new String[0]);
Out.p(keys);
        new MSD().sort(keys);
for (String s : keys) Out.p(s);

    }
    
}
