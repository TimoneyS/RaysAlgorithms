package com.ray.sort;

import static com.ray.utils.ArrayUtil.*;

import com.ray.utils.Timer;

/**
 * <b>�鲢����</b>
 * <p>
 * ����˼�룺<br>
 * <br>
 * @author Ray
 */
@SuppressWarnings("rawtypes")
public class MergeSort {
	
	/**
	 * �Զ����µĵĹ鲢����
	 * @author Ray
	 */
	public static class UpToDown {
		
		public static void sort(Comparable[] arr) {
			Comparable[] temp = new Comparable[arr.length];
			sort(arr, 0, arr.length-1, temp);
		}
		
		public static void sort(Comparable[] arr, int lo, int hi, Comparable[] temp) {
			if(lo < hi) {
				int mid = (hi+lo)/2;
				sort(  arr,    lo,  mid	, temp);
				sort(  arr, mid+1, 	hi	, temp);
				merge( arr,    lo, mid, hi, temp);
			}
		}
		
	}
	
	public static class DownToUp {
		public static void sort(Comparable[] a){
			Comparable[] temp = new Comparable[a.length];
			
			int N = a.length;
			// size ��ʾ������ĳ��ȣ�Ҳ����ÿ�κϲ��ĳ߶�
			for(int size = 1; size < N; size = size * 2)
				for(int l = 0; l < N-size; l = l + size * 2)
					merge(a, l, l+size-1, Math.min(N-1, l+2*size-1), temp);
		}
	}
	
	/**
	 * �鲢�ķ���<br>
	 * arr[lo] 		~ arr[mid] ���Ѿ����������1<br>
	 * arr[mid+1] 	~ arr[hi]  ���Ѿ����������2<br>
	 * @param arr
	 * @param lo	�½�
	 * @param mid	�е�
	 * @param hi	�Ͻ�
	 */
	private static void merge(Comparable[] arr, int lo, int mid,int hi ,Comparable[] temp){
		for(int i = lo; i <= hi; i++) temp[i] = arr[i];
		int l = lo, r = mid+1, i = lo;
		while(l <= mid || r <= hi) {
			if(l > mid) 				arr[i++] = temp[r++];
			else if(r > hi)  			arr[i++] = temp[l++];
			else if(less(temp, l, r)) 	arr[i++] = temp[l++];
			else  						arr[i++] = temp[r++];
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = intArr(20000000);
		shuffle(arr);
		
		Timer.click();
		UpToDown.sort(arr);
		Timer.click();
		
		checkSorted(arr);
	}
	
	
}
