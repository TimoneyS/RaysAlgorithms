package com.rays.sort;

import static com.rays.utils.ArrayUtil.*;

import com.rays.utils.Timer;

/**
 * ʲô����ת���飿
 * ���磬ԭʼ����Ϊ[1,2,3,4], ������ת���������[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * �����ת��������򷽷�
 * @author rays1
 *
 */
@SuppressWarnings("rawtypes")
public class RotateSort {
	
	public static void sort(Comparable[] arr) {
		int c = arr.length;
		for (int i = 1; i < arr.length; i ++)
			if (less(arr, i, i-1)) { c = i; break;}
		
		int l = 0,
			r = arr.length-1;
		int num = 0;
		while (c > l && c <= r) {
			if (c<(l+r+2)/2) {
				num = c-l;
				swap(arr, l, c, num);
				l = c;
				c = c+num;
			} else {
				num = r+1-c;
				swap(arr, l, c, num);
				l   = l+num; 
			}
		}
	}
	
	public static void main(String[] args) {
		int size = 20000000;
		
		Integer[] arr = intArrRotate(size, size/3);
		
		Timer.click();
		sort(arr);
		Timer.click();
		
		checkSorted(arr);
		
//		for (int i = 0; i<size; i++) {
//			Integer[] arr = intArrRotate(size, i);
//			sort(arr);
//			checkSorted(arr);
//		}
		
	}
	
}
