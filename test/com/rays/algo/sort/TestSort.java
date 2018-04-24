package com.rays.algo.sort;

import static com.ray.util.RArrays.checkSorted;
import static com.ray.util.RArrays.integerArr;

import com.ray.util.RArrays;
import com.ray.util.Timer;

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
        Integer[] arr = integerArr(40000);
        RArrays.shuffle(arr);
        testSort("ѡ������", new SelectionSort<Integer>(), arr);
    }

    /**
     * ���Բ�������
     */
    public static void testInsertionSort() {
        Integer[] arr = integerArr(40000);
        RArrays.shuffle(arr);
        testSort("��������", new InsertionSort<Integer>(), arr);
    }
    
    /**
     * ����ϣ������
     */
    public static void testShellSort() {
        Integer[] arr = integerArr(200000);
        RArrays.shuffle(arr);
        testSort("ϣ������", new ShellSort<Integer>(), arr);
    }
    
    /**
     * �����Զ����µĹ鲢����
     */
    public static void testMergeSortU2D() {
        Integer[] arr = integerArr(1000000);
        RArrays.shuffle(arr);
        testSort("�Զ����¹鲢����", new MergeSort.UpToDown<>(), arr);
    }
    
    /**
     * �����Ե����ϵĹ鲢����
     */
    public static void testMergeSortD2U() {
        Integer[] arr = integerArr(1000000);
        RArrays.shuffle(arr);
        testSort("�Ե����Ϲ鲢����", new MergeSort.DownToUp<>(), arr);
    }
    
    /**
     * ����С�����Ż�����Ե����ϵĹ鲢����
     */
    public static void testMergeSortD2UInsert() {
        Integer[] arr = integerArr(1000000);
        RArrays.shuffle(arr);
        testSort("С�����Ż��Ե����Ϲ鲢����", new MergeSort.DownToUpInsert<>(), arr);
    }
    
    /**
     * ���Կ�������
     */
    public static void testQuickSort() {
        Integer[] arr = integerArr(2000000);
        RArrays.shuffle(arr);
        testSort("��������", new QuickSort<>(), arr);
    }
    
    /**
     * ���Զ�����
     */
    public static void testHeapSort() {
        //Integer[] arr = integerArr(10);
        String s = "SORTEXAMPLE";
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i);
        }
        testSort("������", new HeapSort<>(), arr);
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
