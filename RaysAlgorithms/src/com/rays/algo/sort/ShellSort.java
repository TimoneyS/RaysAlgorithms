package com.rays.algo.sort;

import com.ray.common.utils.ArrayUtil;

/**
 * <b>希尔排序</b>
 * <p>
 * 基本思想 :<br/>
 * 使数组中所有相隔h的元素是有序的，即h有序。<br/>
 * 之后逐渐缩小h，创造更小h有序。<br/>
 * 当h缩小为1时，便是数组整体有序。<br/>
 * ...
 * <p>
 * @author rays1
 *
 * @param <T>
 */
public class ShellSort<T extends Comparable<?>> extends Sort<T> {
	
    @Override
    public void sort(T[] arr, int lo, int hi) {
        int h = (hi-lo+1)/3;
        while (h >= 1) {
            for (int i = lo+h; i <= hi; i ++) {
                for (int j = i; (j-lo) >= h && ArrayUtil.less(arr, j, j-h); j -= h) {
                    ArrayUtil.swap(arr, j, j-h);
                }
            }
            h = (h == 2) ? 1 : h/3;
        }
    }
	
}
