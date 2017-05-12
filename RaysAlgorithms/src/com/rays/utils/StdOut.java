package com.rays.utils;

/**
 * 自建的简化标准输出的辅助类
 * @author Ray
 *
 */
public class StdOut {
	
	/**
	 * 输入并换行
	 * @param t
	 */
	public static <T> void println(T t) {
		System.out.println(t);
	}
	
	/**
	 * 格式化输出
	 * @param s
	 * @param args
	 */
	public static <T> void printf(String s, Object...args){
		System.out.printf(s, args);
	}
	
	/**
	 * 只打印不换行
	 * @param t
	 */
	public static <T> void print(T t) {
		System.out.print(t);
	}
	
	/**
	 * 打印错误
	 * @param t
	 */
	public static <T> void err(T t) {
		System.err.println(t);
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
		printf(sb.toString());
	}
	
}
