package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.*;

/**
 * <b>归并排序</b>
 * <p>
 * 基本思想：<br/>
 * 归并操作 - 将两个有序的数组合并为一个更大的有序数组<br/>
 * 在排序一个数组时，递归的将其拆解为两个数组排序，然后将两个子数组归并起来。<br/>
 * </p>
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
                int mid = (lo + hi) / 2;
                mergeSort(arr, lo, mid, temp);
                mergeSort(arr, mid + 1, hi, temp);
                merge(arr, lo, mid, hi, temp);
            }
        }
		
	}
	
	public static class DownToUp<T extends Comparable<?>> extends Sort<T> {

//	    public static void sort(Comparable<?>[] a){
//			Comparable<?>[] temp = new Comparable[a.length];
//			int N = a.length;
//			// size 表示子数组的长度，也就是每次合并的尺度
//			for(int size = 1; size < N; size = size * 2)
//				for(int l = 0; l < N-size; l = l + size * 2)
//					merge(a, l, l+size-1, Math.min(N-1, l+2*size-1), temp);
//		}

        @Override
        public void sort(T[] arr, int lo, int hi) {
            
            
        }
        
	}
	
	/**
	 * 归并的方法<br>
	 * arr[lo] ~ arr[mid] 是已经排序的数组1<br>
	 * arr[mid+1] ~ arr[hi] 是已经排序的数组2<br>
	 * 归并效果等同从两个独立排序的数组中依次获取较小元素，放入大数组中。<br>
	 * 归并完成后，大数组为自然已排序状态。
	 * @param arr   待排序数组
	 * @param lo	下界
	 * @param mid	中点
	 * @param hi	上界
	 */
	private static void merge(Comparable<?>[] arr, int lo, int mid, int hi, Comparable<?>[] temp){
		
	    for(int i = lo; i <= hi; i++) temp[i] = arr[i];
		
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
