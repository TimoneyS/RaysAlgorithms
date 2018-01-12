package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.checkSorted;
import static com.ray.common.utils.ArrayUtil.intArr;
import static com.ray.common.utils.ArrayUtil.shuffle;

import com.ray.common.utils.ArrayUtil;
import com.ray.common.utils.Timer;
import com.ray.common.utils.io.Out;

public class TestSort {
	
	interface Case {public void run(Comparable<?>[] arr);}

   public static void testInsertionSort() {
        Integer[] arr = intArr(20);
        ArrayUtil.shuffle(arr);
        Out.p(arr);
        testSort("—°‘Ò≈≈–Ú", new InsertionSort<Integer>(), arr);
        Out.p(arr);
    }
	
	public static void testSelectionSort() {
	    Integer[] arr = intArr(20);
	    ArrayUtil.shuffle(arr);
	    Out.p(arr);
	    testSort("—°‘Ò≈≈–Ú", new SelectionSort<Integer>(), arr);
	    Out.p(arr);
	}
	
	public static void main(String[] args) {
	    testInsertionSort();
    }
	
	private static <T extends Comparable<?>> void testSort(String name, Sort<T> s, T[] arr) {
	    s.sort(arr);
        checkSorted(arr);
	}
	
}
