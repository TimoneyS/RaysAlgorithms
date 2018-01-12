package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.checkSorted;
import static com.ray.common.utils.ArrayUtil.intArr;
import static com.ray.common.utils.ArrayUtil.shuffle;

import com.ray.common.utils.ArrayUtil;
import com.ray.common.utils.Timer;
import com.ray.common.utils.io.Out;

public class TestSort {
	
	interface Case {public void run(Comparable<?>[] arr);}
	
	public static void testSelectionSort() {
	    Integer[] arr = intArr(20);
	    ArrayUtil.shuffle(arr);
	    Out.p(arr);
	    testSort("—°‘Ò≈≈–Ú", new SelectionSort<Integer>(), arr);
	    
	    Out.p(arr);
	}
	
	public static void main(String[] args) {
	    testSelectionSort();
//        runcase(arr, (a) -> HeapSort.sort(a));
//        runcase(arr, (a) -> InsertionSort.sort(a));
//        runcase(arr, (a) -> MergeSort.DownToUp.sort(a));
//        runcase(arr, (a) -> QuickSort.sort(a));
//        runcase(arr, (a) -> ShellSort.sort(a));
        
    }
	
	private static <T extends Comparable<?>> void testSort(String name, Sort<T> s, T[] arr) {
	    s.sort(arr);
        checkSorted(arr);
	}
	
	public static void runcase(Comparable<?>[] arr, Case t) {
        Timer timer = Timer.create();
		shuffle(arr);
		timer.click();
		t.run(arr);
		timer.stop();
		checkSorted(arr);
	}
	
}
