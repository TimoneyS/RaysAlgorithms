package com.rays.algo.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.common.utils.In;
import com.ray.common.utils.Out;

/**
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
        keyIndexSord(a, 0, 0, a.length-1);
    }
    
    /**
     * @param a
     * @param l
     * @param s
     * @param e
     */
    public void keyIndexSord(String[] a, int l, int s, int e) {
        if (s >= e) return;
        
        int R = 10;
        int[] counts = new int[R + 2];
        
        // ¼üË÷ÒýÅÅÐò
        for (int i = s; i <= e; i++) {
            counts[getChar(a[i], l) + 1] ++;
        }
Out.p(counts);
        for (int i = 0; i < R+1; i++) {
            counts[i+1] += counts[i];
        }
Out.p(counts);
        for (int i = s; i <= e; i++) {
            aux[counts[getChar(a[i], l) + 1]++] = a[i];
        }
        for (int i = s; i <= e; i++) {
            a[i] = aux[i-s];
        }
        
        // °´ÕÕÇÐµãÅÅÐò
        int temp = getChar(a[s], l);
        int s1 = s;
        for (int i = s; i <= e; i++) {
            if (temp != getChar(a[i], l)) {
                keyIndexSord(a, l+1, s1, i-1);
                temp = getChar(a[i], l);
                s1 = i;
            }
        }
        
    }
    
    /**
     * @param s
     * @param i
     * @return
     */
    public int getChar(String s, int i) {
        return (s.length() >i) ? s.charAt(i)-48 : -1; 
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
