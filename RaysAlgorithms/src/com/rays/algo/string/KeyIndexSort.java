package com.rays.algo.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * @author rays1
 *
 */
public class KeyIndexSort {
    
    static class Element<T> {
        int key;
        T value;
        public Element(int key, T value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return String.format("(%s,%s)", key, value);
        }
    }
    
    /**
     * @param a
     */
    public void sort(Element<?>[] a, int R) {
        int[] counts = new int[R+1];
        
        // 频率统计
        for (int i = 0; i < a.length; i++) {
            counts[a[i].key + 1]++; 
        }
        
        // 频率转换为索引
        for (int i = 0; i < R; i++) {
            counts[i + 1]+= counts[i];
        }
        
        // 数据分类
        Element<?>[] aux = new Element[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[counts[a[i].key]++] = a[i];
        }
        
        // 数据回填
        for (int i = 0; i < aux.length; i++) {
            a[i] = aux[i];
        }
        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int R = 5;
        Random r = new Random(47);
        
        Scanner in = In.getClassPathScanner(KeyIndexSort.class, "keyIndex.txt");
        List<Element<String>> list = new LinkedList<Element<String>>();
        while(in.hasNext()) {
            String value = in.next();
            list.add(new Element<String>(r.nextInt(R), value));
        }
        Element<?>[] a = list.toArray(new Element[0]);
        
Out.p(a);
        new KeyIndexSort().sort(a, R);
Out.p(a);

    }

}
