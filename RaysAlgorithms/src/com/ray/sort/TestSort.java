package com.ray.sort;

import static com.ray.utils.ArrayUtil.checkSorted;
import static com.ray.utils.ArrayUtil.intArr;
import static com.ray.utils.ArrayUtil.shuffle;

import com.ray.utils.Timer;

public class TestSort {
	
	interface Case {public void run(Comparable<?>[] arr);}
	
	public static void testSort(Comparable<?>[] arr, Case t) {
		shuffle(arr);
		Timer.click();
		t.run(arr);
		Timer.stop();
		checkSorted(arr);
	}
	
	public static void main(String[] args) {
		Integer[] arr = intArr(20000);
		
		testSort(arr, (a) -> HeapSort.sort(a));
		testSort(arr, (a) -> InsertionSort.sort(a));
		testSort(arr, (a) -> MergeSort.DownToUp.sort(a));
		testSort(arr, (a) -> QuickSort.sort(a));
		testSort(arr, (a) -> SelectionSort.sort(a));
		testSort(arr, (a) -> ShellSort.sort(a));
		
	}
	
}
