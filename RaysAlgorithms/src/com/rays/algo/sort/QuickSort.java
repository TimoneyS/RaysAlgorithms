package com.rays.algo.sort;

import static com.ray.common.util.ArrayUtil.less;
import static com.ray.common.util.ArrayUtil.swap;

/**
 * <b>快速排序</b>
 * <p>
 * 基本思想：<br>
 * 快速的排序也是将数组划分为子数组然后排序，算法的核心在于寻找分割点。<br>
 * 分割点是数组的一个元素，其左侧的元素小于它，右侧的元素大于它<br>
 * 然后依照分割点划分子数组，对子数组继续应用分割点查找。
 * <br>
 * @author Ray
 *
 */
public class QuickSort<T extends Comparable<?>> extends Sort<T> {

    @Override
    public void sort(T[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j-1);
        sort(arr, j+1, hi);
    }
    
    /**
     * 切分方法
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    private int partition(T[] arr, int lo, int hi) {
        int l = lo + 1;                                 // 左侧索引
        int r = hi;                                     // 右侧索引
        while (true) {
            while (less(arr, lo, r) && r > lo) r --;    // 从右侧寻找一个不大于arr[lo]的元素
            while (less(arr, l, lo) && l < hi) l ++;    // 从左侧寻找一个不小于arr[lo]的元素
            if (r > l) swap(arr, r, l);                 // 将左右侧不符合条件的元素相互交换
            else break;
        }
        swap(arr, r, lo);                               // r所在位置即为切点，将arr[lo]放至切点
        return r;
    }
	
}
