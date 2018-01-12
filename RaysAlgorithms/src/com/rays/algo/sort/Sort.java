package com.rays.algo.sort;

public abstract class Sort<T extends Comparable<?>> {
    
    /**
     * ��������
     * @param arr
     */
    public void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    
    /**
     * ��������ֲ�
     * @param arr   ����������
     * @param lo    �ֲ��½�
     * @param hi    �ֲ��Ͻ�
     */
    public abstract void sort(T[] arr, int lo, int hi);
    
}
