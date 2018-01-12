package com.rays.algo.sort;

public abstract class Sort<T extends Comparable<?>> {
    
    /**
     * 排序数组
     * @param arr
     */
    public void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    
    /**
     * 排序数组局部
     * @param arr   待排序数组
     * @param lo    局部下界
     * @param hi    局部上界
     */
    public abstract void sort(T[] arr, int lo, int hi);
    
}
