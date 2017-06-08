package com.ray.sort;

import static com.ray.utils.ArrayUtil.*;

import com.ray.utils.Timer;

/**
 * <b>��������</b>
 * <p>
 * ����˼�룺<br>
 * ���ٵ�����Ҳ�ǽ����黮��Ϊ������Ȼ�������㷨�ĺ�������Ѱ�ҷָ�㡣<br>
 * �ָ���������һ��Ԫ�أ�������Ԫ��С�������Ҳ��Ԫ�ش�����<br>
 * Ȼ�����շָ�㻮�������飬�����������Ӧ�÷ָ����ҡ�
 * <br>
 * @author Ray
 *
 */
@SuppressWarnings("rawtypes")
public class QuickSort {
	
	public static void sort(Comparable[] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	public static void sort(Comparable[] arr, int lo, int hi) {
		if (lo>=hi) return;
		int l = lo + 1;
		int r = hi;
		while (true) {
			while (less(arr, l, lo)) { l++; if (l >= r) break; }
			while (less(arr, lo, r)) r--;
			if (l >= r) break;
			swap(arr, l, r);
		}
		swap(arr, lo, r);
		
		sort(arr, lo, r-1);
		sort(arr, r+1, hi);
	}
	
	public static void main(String[] args) {
		Integer[] arr = intArr(10000000);
		
		shuffle(arr);
		
		Timer.click();
		sort(arr);
		Timer.click();
		
		checkSorted(arr);
	}
	
}
