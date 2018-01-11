package com.rays.algo.sort;

public abstract class Sort<T extends Comparable<?>> {
    
    public void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    
    public abstract void sort(T[] arr, int lo, int hi);
    
}
