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
        Integer[] arr = intArr(20);
        ArrayUtil.shuffle(arr);
        testSort("ѡ������", new SelectionSort<Integer>(), arr);
    }

    /**
     * ���Բ�������
     */
    public static void testInsertionSort() {
        Integer[] arr = intArr(20000);
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

    public static void main(String[] args) {
        testShellSort();
    }

}
