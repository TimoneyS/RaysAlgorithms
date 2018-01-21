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
     * ����ѡ������
     */
    public static void testSelectionSort() {
        Integer[] arr = intArr(40000);
        ArrayUtil.shuffle(arr);
        testSort("ѡ������", new SelectionSort<Integer>(), arr);
    }

    /**
     * ���Բ�������
     */
    public static void testInsertionSort() {
        Integer[] arr = intArr(40000);
        ArrayUtil.shuffle(arr);
        testSort("��������", new InsertionSort<Integer>(), arr);
    }
    
    /**
     * ����ϣ������
     */
    public static void testShellSort() {
        Integer[] arr = intArr(200000);
        ArrayUtil.shuffle(arr);
        testSort("ϣ������", new ShellSort<Integer>(), arr);
    }
    
    /**
     * �����Զ����µĹ鲢����
     */
    public static void testMergeSortU2D() {
        Integer[] arr = intArr(1000000);
        ArrayUtil.shuffle(arr);
        testSort("�Զ����¹鲢����", new MergeSort.UpToDown<>(), arr);
    }
    
    /**
     * �����Ե����ϵĹ鲢����
     */
    public static void testMergeSortD2U() {
        Integer[] arr = intArr(1000000);
        ArrayUtil.shuffle(arr);
        testSort("�Ե����Ϲ鲢����", new MergeSort.DownToUp<>(), arr);
    }
    
    /**
     * ����С�����Ż�����Ե����ϵĹ鲢����
     */
    public static void testMergeSortD2UInsert() {
        Integer[] arr = intArr(1000000);
        ArrayUtil.shuffle(arr);
        testSort("С�����Ż��Ե����Ϲ鲢����", new MergeSort.DownToUpInsert<>(), arr);
    }
    
    /**
     * ���Կ�������
     */
    public static void testQuickSort() {
        Integer[] arr = intArr(2000000);
        ArrayUtil.shuffle(arr);
        testSort("��������", new QuickSort<>(), arr);
    }

    public static void main(String[] args) {
//        testSelectionSort();
//        testInsertionSort();
//        testMergeSortU2D();
//        testMergeSortD2U();
//        testMergeSortD2UInsert();
        testQuickSort();
    }

}
