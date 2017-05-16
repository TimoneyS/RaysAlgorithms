package com.rays.sort;

import static com.rays.utils.ArrayUtil.*;

import com.rays.utils.Timer;

/**
 * <b>归并排序</b>
 * <p>
 * 基本思想：<br>
 * <br>
 * @author Ray
 */
@SuppressWarnings("rawtypes")
public class MergeSort {
	
	/**
	 * 自顶向下的的归并排序
	 * @author Ray
	 */
	public static class UpToDown {
		
		public static void sort(Comparable[] arr) {
			Comparable[] temp = new Comparable[arr.length];
			sort(arr, 0, arr.length-1, temp);
		}
		
		public static void sort(Comparable[] arr, int lo, int hi, Comparable[] temp) {
			if(lo < hi) {
				int mid = (hi+lo)/2;
				sort(  arr,    lo,  mid	, temp);
				sort(  arr, mid+1, 	hi	, temp);
				merge( arr,    lo, mid, hi, temp);
			}
		}
		
	}
	
	/**
	 * 归并的方法<br>
	 * arr[lo] 		~ arr[mid] 是已经排序的数组1<br>
	 * arr[mid+1] 	~ arr[hi]  是已经排序的数组2<br>
	 * @param arr
	 * @param lo	下界
	 * @param mid	中点
	 * @param hi	上界
	 */
	private static void merge(Comparable[] arr, int lo, int mid,int hi ,Comparable[] temp){
		for(int i = lo; i <= hi; i++) temp[i] = arr[i];
		int l = lo, r = mid+1, i = lo;
		while(l <= mid || r <= hi) {
			if(l > mid) 				arr[i++] = temp[r++];
			else if(r > hi)  			arr[i++] = temp[l++];
			else if(less(temp, l, r)) 	arr[i++] = temp[l++];
			else  						arr[i++] = temp[r++];
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = intArr(10000);
		shuffle(arr);
		
		Timer.click();
		UpToDown.sort(arr);
		Timer.click();
		
		checkSorted(arr);
	}
	
	
}
