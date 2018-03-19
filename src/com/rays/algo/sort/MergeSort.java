package com.rays.algo.sort;

import static com.ray.common.util.ArrayUtil.*;

/**
 * <b>归并排序</b>
 * <p>
 * 基本思想：<br/>
 * 归并操作 - 将两个有序的数组合并为一个更大的有序数组<br/>
 * 在排序一个数组时，递归的将其拆解为两个数组排序，然后将两个子数组归并起来。<br/>
 * </p>·
 * @author Ray
 */
public class MergeSort {
	
	/**
	 * 自顶向下的的归并排序<br/>
	 * @author Ray
	 */
	public static class UpToDown<T extends Comparable<?>> extends Sort<T> {
		
        @Override
        public void sort(T[] arr, int lo, int hi) {
            Comparable<?>[] temp = new Comparable<?>[hi-lo+1];
            mergeSort(arr, lo, hi, temp);
        }
        
        private void mergeSort(T[] arr, int lo, int hi, Comparable<?>[] temp) {
            if (lo < hi) {
                int mid = (lo + hi) / 2;            // 计算中点
                mergeSort(arr, lo, mid, temp);      // 排序左侧子数组
                mergeSort(arr, mid + 1, hi, temp);  // 排序右侧子数组
                merge(arr, lo, mid, hi, temp);      // 归并
            }
        }
		
	}
	
	/**
	 * 自底向上的归并排序
	 * @author rays1
	 *
	 * @param <T>
	 */
	public static class DownToUp<T extends Comparable<?>> extends Sort<T> {

        @Override
        public void sort(T[] arr, int lo, int hi) {
            Comparable<?>[] temp = new Comparable<?>[hi-lo+1];
            int N = hi - lo + 1;
            for (int size = 1; size < N; size *= 2) {                            // 幂次递增的归并尺寸
                for (int l = lo; l < N-size; l += size*2 ) {                     // 循环处理每一对待归并的子数组
                    merge(arr, l, (l+size-1), Math.min( l+size*2-1, hi), temp);  // 归并起点为l长度为size的两个相邻的子数组
                }
            }
        }
        
	}
	
	/**
	 * 小数组采用插入排序的自底向上归并排序
	 * @author rays1
	 *
	 * @param <T>
	 */
	public static class DownToUpInsert<T extends Comparable<?>> extends Sort<T>  {
        @Override
        public void sort(T[] arr, int lo, int hi) {
            Comparable<?>[] temp = new Comparable<?>[hi-lo+1];
            Sort<T> s = new InsertionSort<>();
            int optiSize = 16;  // 切换选择排序和归并排序的尺寸
            
            int N = hi - lo + 1;
            for (int i = 0; i < N-optiSize; i += optiSize)
                s.sort(arr, i, Math.min(i+optiSize-1, hi));

            for (int size = optiSize; size < N; size *= 2) {                     // 幂次递增的归并尺寸
                for (int l = lo; l < N-size; l += size*2 ) {                     // 循环处理每一对待归并的子数组
                    merge(arr, l, (l+size-1), Math.min( l+size*2-1, hi), temp);  // 归并起点为l长度为size的两个相邻的子数组
                }
            }
        }
	}
	
	/**
	 * 归并的方法<br>
	 * arr[lo] ~ arr[mid] 是已经排序的数组1<br>
	 * arr[mid+1] ~ arr[hi] 是已经排序的数组2<br>
	 * 归并效果等同从两个独立排序的数组中依次获取较小元素，放入大数组中。<br>
	 * 归并完成后，大数组为自然已排序状态。
	 * @param arr   待排序数组 
	 * @param mid	中点
	 * @param hi	上界
	 */
	private static void merge(Comparable<?>[] arr, int lo, int mid, int hi, Comparable<?>[] temp){
		
	    for(int i = lo; i <= hi; i++) temp[i] = arr[i];    // 缓存
		
	    int i = lo,     // 大数组索引
            l = lo,     // 左侧子数组索引
            r = mid+1;  // 右侧子数组索引
		
		while(l <= mid || r <= hi) {
			if(l > mid) 				arr[i++] = temp[r++];    // 左侧子数组已经全部添加
			else if(r > hi)  			arr[i++] = temp[l++];    // 右侧子数组已经全部添加
			else if(less(temp, l, r)) 	arr[i++] = temp[l++];    // 左侧的子数组当前元素更小
			else  						arr[i++] = temp[r++];    // 右侧的子数组当前元素更小
		}
		
	}
	
}
