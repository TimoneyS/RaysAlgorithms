package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.*;

/**
 * <b>�鲢����</b>
 * <p>
 * ����˼�룺<br/>
 * �鲢���� - ���������������ϲ�Ϊһ���������������<br/>
 * ������һ������ʱ���ݹ�Ľ�����Ϊ������������Ȼ������������鲢������<br/>
 * </p>
 * @author Ray
 */
public class MergeSort {
	
	/**
	 * �Զ����µĵĹ鲢����<br/>
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
//			// size ��ʾ������ĳ��ȣ�Ҳ����ÿ�κϲ��ĳ߶�
//			for(int size = 1; size < N; size = size * 2)
//				for(int l = 0; l < N-size; l = l + size * 2)
//					merge(a, l, l+size-1, Math.min(N-1, l+2*size-1), temp);
//		}

        @Override
        public void sort(T[] arr, int lo, int hi) {
            
            
        }
        
	}
	
	/**
	 * �鲢�ķ���<br>
	 * arr[lo] ~ arr[mid] ���Ѿ����������1<br>
	 * arr[mid+1] ~ arr[hi] ���Ѿ����������2<br>
	 * �鲢Ч����ͬ������������������������λ�ȡ��СԪ�أ�����������С�<br>
	 * �鲢��ɺ󣬴�����Ϊ��Ȼ������״̬��
	 * @param arr   ����������
	 * @param lo	�½�
	 * @param mid	�е�
	 * @param hi	�Ͻ�
	 */
	private static void merge(Comparable<?>[] arr, int lo, int mid, int hi, Comparable<?>[] temp){
		
	    for(int i = lo; i <= hi; i++) temp[i] = arr[i];
		
	    int i = lo,     // ����������
            l = lo,     // �������������
            r = mid+1;  // �Ҳ�����������
		
		while(l <= mid || r <= hi) {
			if(l > mid) 				arr[i++] = temp[r++];    // ����������Ѿ�ȫ�����
			else if(r > hi)  			arr[i++] = temp[l++];    // �Ҳ��������Ѿ�ȫ�����
			else if(less(temp, l, r)) 	arr[i++] = temp[l++];    // ���������鵱ǰԪ�ظ�С
			else  						arr[i++] = temp[r++];    // �Ҳ�������鵱ǰԪ�ظ�С
		}
		
	}
	
}
