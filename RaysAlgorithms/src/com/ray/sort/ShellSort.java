package com.ray.sort;

import static com.ray.utils.ArrayUtil.*;

import com.ray.utils.Timer;

public class ShellSort {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr) {
		
		int h = arr.length / 3;
		
		while(h >= 1){
			for(int i = h; i < arr.length; i ++) {
				for(int j = i; j >= h && less(arr, j, j-h); j -= h)
					swap(arr, j, j-h);
			}
			h /= 3;
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
