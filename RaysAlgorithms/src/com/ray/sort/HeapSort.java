package com.ray.sort;

import com.ray.utils.collections.BinaryHeap;

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
	
}
