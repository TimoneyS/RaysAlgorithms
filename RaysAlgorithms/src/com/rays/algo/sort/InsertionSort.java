package com.rays.algo.sort;

import com.ray.common.utils.ArrayUtil;

/**
 * <b>插入排序</b>
 * 
 * <p>
 * 基本思想：<br>
 * 1.插入排序中，当前元素左侧是已经排序的部分，右侧是未排序部分<br>
 * 2.用当前元素和左侧元素比较，如果比左侧元素小则执行交换，直到到达数组首位或左侧元素不再更大。<br>
 * <br>
 * @author Ray
 */
public class InsertionSort<T extends Comparable<?>> extends Sort<T> {

    @Override
    public void sort(T[] arr, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && ArrayUtil.less(arr, j, j-1); j --) {
                ArrayUtil.swap(arr, j, j-1);
            }
        }
    }
	
}
