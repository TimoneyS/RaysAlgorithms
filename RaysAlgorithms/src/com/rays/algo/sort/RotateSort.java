package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.*;

import com.ray.common.utils.Timer;

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
		// ��δ��� Ч�ʵ͵ĵط����� ͬ�����жϽ��������Σ����ǿ��������
		while (c > l && c <= r) {
			num = (c<(l+r+2)/2) ? c-l : r+1-c; 
			swap(arr, l, c, num);
			l 	= l+num;
			if (c<(l+r+2)/2) c 	= c+num;
		}
	}
	
	// ʹ�ô�������ռ�����򷽷���Ч��û��ʹ�õ�������ռ�ĸ�
	public static void sortLargeSpace (Comparable[] arr) {
		Comparable[] temp = new Comparable[arr.length];
		
		int c = arr.length;
		for (int i = 0; i < arr.length; i ++) {
			if (i>0 && less(arr, i, i-1)) c = i;
			temp[i] = arr[i];
		}
		
		for (int i = 0; i < arr.length; i ++)
			arr[i] = temp[(i+c)%arr.length];
	}
	
	public static void main(String[] args) {
		int size = 20000000;
		
		Integer[] arr = intArrRotate(size, size/3);
		
		Timer.click();
		sortLargeSpace(arr);
		Timer.click();
		
		checkSorted(arr);
	}
	
}
