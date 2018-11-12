package com.rays.algo.string.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.io.In;
import com.ray.io.Out;

/**
 * 高位优先的字符串排序
 * @author rays1
 *
 */
public class MSD {
    
    private static int      R = 256; // 基数
    private static String[] aux;     // 缓存数组

    /**
     * 封装获取字符串的字符方法，字符串尾部返回-1
     * @param s
     * @param i
     * @return
     */
    private static int getChar(String s, int i) {
        return (s.length() > i) ? s.charAt(i) : -1; 
    }

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
        
        int[] counts = new int[R + 2];
        
        // 键索引排序
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
        
        // 本次排序同一字母开始的字符串，切分为子数组递归排序
        for (int i = 0; i < R; i++) {
            keyIndexSord(a, lo+counts[i], lo+counts[i+1]-1, d+1);
        }
        
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
