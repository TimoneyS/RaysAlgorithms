package com.ray.sort;

import static com.ray.utils.ArrayUtil.*;

import com.ray.utils.Timer;

/**
 * <b>选择排序</b>
 * <p>
 * 基本思想：<br/>
 * 1.遍历未排序的部分。<br/>
 * 2.找出最小元素，将其和未排序的第一个元素交换，该元素便已排序。<br/>
 * 3.重复 1 2 直到所有元素已排序。
 * <p>
 * 算法特点：<br/>
 * 1.运行时间和输入无关<br/>
 * 2.数据的移动量最少<br/>
 * @author Ray
 */
public class SelectionSort {

	@SuppressWarnings({ "rawtypes" })
	public static void sort(Comparable[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int minIdx = i; 
			for(int j = i;  j < arr.length; j ++) {
				if(less(arr, j, minIdx)) minIdx = j;
			}
			swap(arr, minIdx, i);
		}
		
	}
	
	public static void main(String[] args) {
		
		Integer[] arr = intArr(10); 
//		show(arr);
		
		Timer.click();
		shuffle(arr);
//		show(arr);
		checkSorted(arr);
		
		Timer.click();
		sort(arr);
		Timer.click();
//		show(arr);
		checkSorted(arr);
		
	}

}
