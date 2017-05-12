package com.rays.utils;

/**
 * �Խ��ļ򻯱�׼����ĸ�����
 * @author Ray
 *
 */
public class StdOut {
	
	/**
	 * ���벢����
	 * @param t
	 */
	public static <T> void println(T t) {
		System.out.println(t);
	}
	
	/**
	 * ��ʽ�����
	 * @param s
	 * @param args
	 */
	public static <T> void printf(String s, Object...args){
		System.out.printf(s, args);
	}
	
	/**
	 * ֻ��ӡ������
	 * @param t
	 */
	public static <T> void print(T t) {
		System.out.print(t);
	}
	
	/**
	 * ��ӡ����
	 * @param t
	 */
	public static <T> void err(T t) {
		System.err.println(t);
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
		printf(sb.toString());
	}
	
}
