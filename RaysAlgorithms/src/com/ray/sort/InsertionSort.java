package com.ray.sort;

import static com.ray.utils.ArrayUtil.*;

import com.ray.utils.Timer;
/**
 * <b>��������</b>
 * 
 * <p>
 * ����˼�룺<br>
 * 1.���������У���ǰԪ��������Ѿ�����Ĳ��֣��Ҳ���δ���򲿷�<br>
 * 2.�õ�ǰԪ�غ����Ԫ�رȽϣ���������Ԫ��С��ִ�н�����ֱ���������龡ͷ�����Ԫ�ز��ٸ���<br>
 * <br>
 * @author Ray
 */
public class InsertionSort {

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for(int j = i; j > 0 && less(arr, j, j-1); j --) {
				swap(arr, j, j-1);
			}
		}

	}
	
	public static void main(String[] args) {
		Integer[] arr = intArr(20000);
		
		shuffle(arr);
		checkSorted(arr);
		
		Timer.click();
		sort(arr);
		Timer.click();
		
		checkSorted(arr);
	}
	
}
