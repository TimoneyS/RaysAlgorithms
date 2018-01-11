package com.ray.common.utils;

import java.util.Random;

import com.ray.common.utils.io.Out;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ArrayUtil {
	
	/**
	 * ��ȡ ��������
	 * @param size
	 * @return
	 */
	public static Integer[] intArr(int size) {
		Integer[] arr = new Integer[size]; 
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = i + 1;
		}
		return arr;
	}
	
	/**
	 * ��ȡ������ת���飬����ָ����ת��λ��
	 * @param size			����ߴ�
	 * @param deviation		ƫ����
	 * @return
	 */
	public static Integer[] intArrRotate(int size, int deviation) {
		Integer[] arr = new Integer[size]; 
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = ( i - deviation + size) % size;
		}
		return arr;
	}
	
	/**
     * ��������Ƿ��Ѿ�����
     * @param arr
     */
    public static void checkSorted(Comparable[] arr) {
    	Out.pf("����飬����%s����\n", isSorted(arr) ? "��" : "δ");
    }

    /**
     * �������ֲ��Ƿ��Ѿ�����
     * @param arr
     */
    public static void checkSorted(Comparable[] arr, int lo, int hi) {
        Out.pf("����飬����%s����\n", isSorted(arr, lo, hi) ? "��" : "δ");
    }

    /**
	 * ��������Ƿ��Ѿ�����
	 * @param arr
	 * @return
	 */
	public static boolean isSorted(Comparable[] arr){
	    return isSorted(arr, 0, arr.length - 1);
	}
	
    /**
     * �������ֲ��Ƿ��Ѿ�����
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr, int lo, int hi){
        for(int i = lo; i < hi; i ++)
            if(arr[i].compareTo(arr[i+1]) > 0) return false;
        return true;
    }
	
	/**
	 * �Ƚ�����Ԫ��
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 * true  ��� arr[i] <  arr[j]<br>
	 * false ��� arr[i] >= arr[j]<br>
	 */
	public static boolean less(Comparable[] arr, int i,  int j){
		return arr[i].compareTo(arr[j]) < 0;
	}
	
	/**
	 * ��ӡ����
	 * @param arr
	 */
	public static <T> void show(T[] arr) {
		Out.p(arr);
	}
	
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
	
	/**
	 * �����������������Ҫ�������������û�н��������Ҵ�Сһ�£�
	 * @param arr 	����
	 * @param l1	����1��ʼ�߽�
	 * @param l2	����2��ʼ�߽�
	 * @param size	�����С
	 */
	public static <T> void swap(T[] arr,  int l1, int l2, int size) {
		for (int i = 0; i < size; i ++)
			swap(arr, l1 + i, l2 + i);
	}
	
	
}
