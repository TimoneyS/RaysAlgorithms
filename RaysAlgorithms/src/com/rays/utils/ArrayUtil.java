package com.rays.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {
	
	/**
	 * ��������˳��
	 * @param arr
	 */
	public static <T> void shuffle(T[] arr) {
		Random r = new Random(42);
		for(int i = 0; i < arr.length; i ++)
			swap(arr, i, r.nextInt(arr.length));
	}
	
	/**
	 * ��������Ԫ��λ��
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean checkSort(Comparable[] arr) {
		boolean result = true;
		for(int i = 1; i < arr.length; i ++)
			if(arr[i-1].compareTo(arr[i]) > 0) result = false;
		
		StdOut.printf("����飬����%s����\n", result ? "��" : "δ");
		
		return result;
	}
	
	/**
	 * ��ȡ ��������
	 * @param size
	 * @return
	 */
	public static Integer[] intArr(int size){
		Integer[] arr = new Integer[size]; 
//		Random r = new Random(42);
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = i + 1;
//			arr[i] = r.nextInt(size*size);
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		
		Integer[] arr = new Integer[]{1,4,2,3};
		
		shuffle(arr);
		StdOut.pl(Arrays.toString(arr));
		
		shuffle(arr);
		StdOut.pl(Arrays.toString(arr));
		
		shuffle(arr);
		StdOut.pl(Arrays.toString(arr));
		
	}
	
}
