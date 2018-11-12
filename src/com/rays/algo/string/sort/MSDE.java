package com.rays.algo.string.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ray.io.In;
import com.ray.io.Out;

/**
 * 高位优先的字符串排序
 * @author rays1
 *
 */
public class MSDE {
    
    static class Element<T> {
        String key;
        T value;
        public Element(String key, T value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return String.format("(%s,%s)", key, value);
        }
    }
    
    private static int      R = 256; // 基数
    private static Element<?>[] aux;     // 缓存数组

    /**
     * 封装获取字符串的字符方法，字符串尾部返回-1
     * @param s
     * @param i
     * @return
     */
    private static int getChar(Element<?> s, int i) {
        return (s.key.length() > i) ? s.key.charAt(i) : -1; 
    }

    /**
     * @param a
     * @param s
     * @param e
     */
    public void sort(Element<?>[] a) {
        aux = new Element[a.length];
        keyIndexSord(a, 0, a.length-1, 0);
    }
    
    /**
     * @param a
     * @param d
     * @param lo
     * @param hi
     */
    public void keyIndexSord(Element<?>[] a, int lo, int hi, int d) {
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
        Pattern ptn = Pattern.compile(".+infoType=\"(\\d+)\".+name=\"(\\w+)\".+");
        
        Scanner in = In.getClassPathScanner(MSDE.class, "msde.txt");
        List<Element<String>> list = new LinkedList<Element<String>>();
        while (in.hasNext()) {
            String line = in.nextLine();
            
            if (line.matches("\\s*<class infoType.+")) {
                Matcher m = ptn.matcher(line);
                m.matches();
                Element<String> el = new Element<String>(m.group(2) + m.group(1), line);
                list.add(el);
            }
            
            // list.add(in.next());
        }
        
        Element<?>[] keys = list.toArray(new Element[0]);
Out.p(keys);
        new MSDE().sort(keys);
for (Element<?> s : keys) Out.p(s.value);

    }
    
}
