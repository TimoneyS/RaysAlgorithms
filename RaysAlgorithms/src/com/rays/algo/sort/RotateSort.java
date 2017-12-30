package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.*;

import com.ray.common.utils.Timer;

/**
 * 什么是旋转数组？
 * 比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * 针对旋转数组的排序方法
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
		// 这段代码 效率低的地方在于 同样的判断进行了两次，但是看起来简洁
		while (c > l && c <= r) {
			num = (c<(l+r+2)/2) ? c-l : r+1-c; 
			swap(arr, l, c, num);
			l 	= l+num;
			if (c<(l+r+2)/2) c 	= c+num;
		}
	}
	
	// 使用大量额外空间的排序方法，效率没有使用单个额外空间的高
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
