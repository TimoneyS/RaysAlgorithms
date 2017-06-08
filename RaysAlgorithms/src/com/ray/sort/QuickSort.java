package com.ray.sort;

import static com.ray.utils.ArrayUtil.*;

import com.ray.utils.Timer;

/**
 * <b>快速排序</b>
 * <p>
 * 基本思想：<br>
 * 快速的排序也是将数组划分为子数组然后排序，算法的核心在于寻找分割点。<br>
 * 分割点是数组的一个元素，其左侧的元素小于它，右侧的元素大于它<br>
 * 然后依照分割点划分子数组，对子数组继续应用分割点查找。
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
