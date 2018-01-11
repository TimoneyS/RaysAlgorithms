package com.ray.common.utils.io;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * �Խ��ļ򻯱�׼����ĸ�����
 * @author Ray
 *
 */
public class Log {
	
    private static SimpleDateFormat dateFormater = new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss:ms]");
    
	/**
	 * ��ӡ������
	 * @param t
	 */
	public static <T> void p(T t) {
		System.out.println(tag() + t);
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
		System.out.printf(tag() + s, args);
	}
	
	/**
	 * ֻ��ӡ������
	 * @param t
	 */
	public static <T> void pt(T t) {
		System.out.print(tag() + t);
	}
	
	/**
	 * ��ӡ����
	 * @param t
	 */
	public static <T> void err(T t) {
		System.err.println(tag() + t);
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
	
	private static String tag() {
	    return dateFormater.format(new Date());
	}
	
}
