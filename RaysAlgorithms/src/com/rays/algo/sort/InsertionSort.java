package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.*;

/**
 * <b>插入排序</b>
 * 
 * <p>
 * 基本思想：<br>
 * 1.插入排序中，当前元素左侧是已经排序的部分，右侧是未排序部分<br>
 * 2.用当前元素和左侧元素比较，如果比左侧元素小则执行交换，直到到达数组尽头或左侧元素不再更大。<br>
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
	
}
