package com.rays.utils;

import java.util.Random;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ArrayUtil {
	
	/**
	 * 检查数组是否已经排序
	 * @param arr
	 */
	public static void checkSorted(Comparable[] arr) {
		StdOut.pf("经检查，数组%s排序。\n", isSorted(arr) ? "已" : "未");
	}
	
	/**
	 * 获取 整形数组
	 * @param size
	 * @return
	 */
	public static Integer[] intArr(int size){
		Integer[] arr = new Integer[size]; 
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = i + 1;
		}
		return arr;
	}
	
	/**
	 * 检查数组是否已经排序
	 * @param arr
	 * @return
	 */
	public static boolean isSorted(Comparable[] arr){
		for(int i = 1; i < arr.length; i ++)
			if(arr[i-1].compareTo(arr[i]) > 0) return false;
		return true;
	}
	
	/**
	 * 比较数组元素
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 * true  如果 arr[i] <  arr[j]<br>
	 * false 如果 arr[i] >= arr[j]<br>
	 */
	public static boolean less(Comparable[] arr, int i,  int j){
		return arr[i].compareTo(arr[j]) < 0;
	}
	
	/**
	 * 打印数组
	 * @param arr
	 */
	public static <T> void show(T[] arr) {
		StdOut.p(arr);
	}
	
	/**
	 * 打乱数组顺序
	 * @param arr
	 */
	public static <T> void shuffle(T[] arr) {
		Random r = new Random(42);
		for(int i = 0; i < arr.length; i ++)
			swap(arr, i, r.nextInt(arr.length));
	}
	
	/**
	 * 交换数组元素位置
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
}
