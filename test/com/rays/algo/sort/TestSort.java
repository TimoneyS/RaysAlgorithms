package com.rays.algo.sort;

import static com.ray.common.util.ArrayUtil.checkSorted;
import static com.ray.common.util.ArrayUtil.intArr;

import com.ray.common.util.ArrayUtil;
import com.ray.common.util.Timer;

public class TestSort {
    
    private static <T extends Comparable<?>> void testSort(String name, Sort<T> s, T[] arr) {
        Timer timer = Timer.create(name);
        timer.click();
        s.sort(arr);
        timer.stop();
        checkSorted(arr);
    }

    /**
     * 测试选择排序
     */
    public static void testSelectionSort() {
        Integer[] arr = intArr(40000);
        ArrayUtil.shuffle(arr);
        testSort("选择排序", new SelectionSort<Integer>(), arr);
    }

    /**
     * 测试插入排序
     */
    public static void testInsertionSort() {
        Integer[] arr = intArr(40000);
        ArrayUtil.shuffle(arr);
        testSort("插入排序", new InsertionSort<Integer>(), arr);
    }
    
    /**
     * 测试希尔排序
     */
    public static void testShellSort() {
        Integer[] arr = intArr(200000);
        ArrayUtil.shuffle(arr);
        testSort("希尔排序", new ShellSort<Integer>(), arr);
    }
    
    /**
     * 测试自顶向下的归并排序
     */
    public static void testMergeSortU2D() {
        Integer[] arr = intArr(1000000);
        ArrayUtil.shuffle(arr);
        testSort("自顶向下归并排序", new MergeSort.UpToDown<>(), arr);
    }
    
    /**
     * 测试自底向上的归并排序
     */
    public static void testMergeSortD2U() {
        Integer[] arr = intArr(1000000);
        ArrayUtil.shuffle(arr);
        testSort("自底向上归并排序", new MergeSort.DownToUp<>(), arr);
    }
    
    /**
     * 测试小数组优化后的自底向上的归并排序
     */
    public static void testMergeSortD2UInsert() {
        Integer[] arr = intArr(1000000);
        ArrayUtil.shuffle(arr);
        testSort("小数组优化自底向上归并排序", new MergeSort.DownToUpInsert<>(), arr);
    }
    
    /**
     * 测试快速排序
     */
    public static void testQuickSort() {
        Integer[] arr = intArr(2000000);
        ArrayUtil.shuffle(arr);
        testSort("快速排序", new QuickSort<>(), arr);
    }
    
    /**
     * 测试堆排序
     */
    public static void testHeapSort() {
        //Integer[] arr = intArr(10);
        String s = "SORTEXAMPLE";
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i);
        }
        testSort("堆排序", new HeapSort<>(), arr);
    }
    
    public static void main(String[] args) {
//        testSelectionSort();
//        testInsertionSort();
//        testMergeSortU2D();
//        testMergeSortD2U();
//        testMergeSortD2UInsert();
        testHeapSort();
    }

}
