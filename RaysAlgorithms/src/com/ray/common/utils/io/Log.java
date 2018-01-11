package com.ray.common.utils.io;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 自建的简化标准输出的辅助类
 * @author Ray
 *
 */
public class Log {
	
    private static SimpleDateFormat dateFormater = new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss:ms]");
    
	/**
	 * 打印并换行
	 * @param t
	 */
	public static <T> void p(T t) {
		System.out.println(tag() + t);
	}
	
	/**
	 * 打印数组并换行
	 * @param t
	 */
	public static <T> void p(T[] t)   { p(Arrays.toString(t)); }
	public static void p(int[] t)     { p(Arrays.toString(t)); }
    public static void p(boolean[] t) { p(Arrays.toString(t)); }
    public static void p(long[] t)    { p(Arrays.toString(t)); }
	
	/**
	 * 格式化输出
	 * @param s
	 * @param args
	 */
	public static <T> void pf(String s, Object...args){
		System.out.printf(tag() + s, args);
	}
	
	/**
	 * 只打印不换行
	 * @param t
	 */
	public static <T> void pt(T t) {
		System.out.print(tag() + t);
	}
	
	/**
	 * 打印错误
	 * @param t
	 */
	public static <T> void err(T t) {
		System.err.println(tag() + t);
	}
	
	/**
	 * 打印分割线
	 * 
	 */
	public static void sep() {
		sep(100);
	}
	
	/**
	 * 打印分割线
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
