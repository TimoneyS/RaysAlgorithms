package com.rays.sort;

import static com.rays.utils.ArrayUtil.*;
import com.rays.utils.Timer;
import static com.rays.utils.CompareUtil.*;

/**
 * 选择排序的基本思想是：<br/>
 * 1.遍历未排序的部分。<br/>
 * 2.找出最小元素，将其和未排序的第一个元素交换，该元素便已排序。<br/>
 * 3.重复 1 2 直到所有元素已排序。
 * @author Ray
 */
public class SelectionSort {

	@SuppressWarnings({ "rawtypes" })
	public static void sort(Comparable[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int minIdx = i; 
			for(int j = i;  j < arr.length; j ++) {
				if(less(arr[minIdx], arr[j])) minIdx = j;
			}
			swap(arr, minIdx, i);
		}
		
	}
	
	public static void main(String[] args) {
		
		Integer[] arr = intArr(10000); 
//		p(arr);
		
		Timer.click();
		shuffle(arr);
//		p(arr);
		checkSort(arr);
		
		Timer.click();
		sort(arr);
		Timer.click();
//		p(arr);
		checkSort(arr);
		
	}

}
