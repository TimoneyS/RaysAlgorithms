package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.checkSorted;
import static com.ray.common.utils.ArrayUtil.intArr;

import com.ray.common.utils.ArrayUtil;
import com.ray.common.utils.Timer;

public class TestSort {
    
    private static <T extends Comparable<?>> void testSort(String name, Sort<T> s, T[] arr) {
        Timer timer = Timer.create(name);
        timer.click();
        s.sort(arr);
        timer.stop();
        checkSorted(arr);
    }

    /**
     * ≤‚ ‘—°‘Ò≈≈–Ú
     */
    public static void testSelectionSort() {
        Integer[] arr = intArr(20);
        ArrayUtil.shuffle(arr);
        testSort("—°‘Ò≈≈–Ú", new SelectionSort<Integer>(), arr);
    }

    /**
     * ≤‚ ‘≤Â»Î≈≈–Ú
     */
    public static void testInsertionSort() {
        Integer[] arr = intArr(20000);
        ArrayUtil.shuffle(arr);
        testSort("≤Â»Î≈≈–Ú", new InsertionSort<Integer>(), arr);
    }
    
    /**
     * ≤‚ ‘œ£∂˚≈≈–Ú
     */
    public static void testShellSort() {
        Integer[] arr = intArr(200000);
        ArrayUtil.shuffle(arr);
        testSort("œ£∂˚≈≈–Ú", new ShellSort<Integer>(), arr);
    }
    
    /**
     * ≤‚ ‘◊‘∂•œÚœ¬µƒπÈ≤¢≈≈–Ú
     */
    public static void testMergeSortU2D() {
        Integer[] arr = intArr(2000000);
        ArrayUtil.shuffle(arr);
        testSort("◊‘∂•œÚœ¬πÈ≤¢≈≈–Ú", new MergeSort.UpToDown<>(), arr);
    }

    public static void main(String[] args) {
        testMergeSortU2D();
    }

}
