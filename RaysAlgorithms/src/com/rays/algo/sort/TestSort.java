package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.checkSorted;
import static com.ray.common.utils.ArrayUtil.intArr;
import static com.ray.common.utils.ArrayUtil.shuffle;

import com.ray.common.utils.Timer;

public class TestSort {
	
	interface Case {public void run(Comparable<?>[] arr);}
	
	public static void runcase(Comparable<?>[] arr, Case t) {
		shuffle(arr);
		Timer.click();
		t.run(arr);
		Timer.stop();
		checkSorted(arr);
	}
	
	public static void main(String[] args) {
		Integer[] arr = intArr(20000);
		
		runcase(arr, (a) -> HeapSort.sort(a));
		runcase(arr, (a) -> InsertionSort.sort(a));
		runcase(arr, (a) -> MergeSort.DownToUp.sort(a));
		runcase(arr, (a) -> QuickSort.sort(a));
		runcase(arr, (a) -> SelectionSort.sort(a));
		runcase(arr, (a) -> ShellSort.sort(a));
		
	}
	
}
