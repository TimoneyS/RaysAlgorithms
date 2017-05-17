package com.rays.sort;

import com.rays.utils.BinaryHeap;
import com.rays.utils.Timer;

import static com.rays.utils.ArrayUtil.*;

@SuppressWarnings({ "rawtypes", "unchecked"})
public class HeapSort {
	
	public static void sort(Comparable[] arr) {
		BinaryHeap heap = new BinaryHeap(arr.length);
		
		for(Comparable c : arr)
			heap.insert(c);
		
		for(int i = arr.length - 1; i >= 0; i--) {
			arr[i] = heap.delete();
		}
		
	}
	
	public static void main(String[] args) {
		Integer[] arr = intArr(20000);
		
		shuffle(arr);
		
		Timer.click();
		sort(arr);
		Timer.click();
		
		checkSorted(arr);
	}
	
}
