package com.rays.algo.sort;

public interface Sort<T extends Comparable<?>> {
    
    public void sort(T[] arr);
    
    public void sort(T[] arr, int lo, int hi);
    
}
