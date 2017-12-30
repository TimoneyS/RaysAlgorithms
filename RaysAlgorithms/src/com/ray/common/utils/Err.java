package com.ray.common.utils;

import java.util.Arrays;

public class Err {
    
    /**
     * ��ӡ������
     * @param t
     */
    public static <T> void p(T t) {
        System.err.println(t);
    }
    
    /**
     * ��ӡ���鲢����
     * @param t
     */
    public static <T> void p(T[] t)   { p(Arrays.toString(t)); }
    public static void p(int[] t)     { p(Arrays.toString(t)); }
    public static void p(boolean[] t) { p(Arrays.toString(t)); }
    public static void p(long[] t)    { p(Arrays.toString(t)); }
    
    /**
     * ��ʽ�����
     * @param s
     * @param args
     */
    public static <T> void pf(String s, Object...args){
        System.err.printf(s, args);
    }
    
    /**
     * ֻ��ӡ������
     * @param t
     */
    public static <T> void pt(T t) {
        System.err.print(t);
    }
    
    /**
     * ��ӡ�ָ���
     * 
     */
    public static void sep() {
        sep(100);
    }
    
    /**
     * ��ӡ�ָ���
     * @param size
     */
    public static void sep(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) sb.append("=");
        p(sb.toString());
    }
    
}
