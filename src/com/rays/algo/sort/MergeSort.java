package com.rays.algo.sort;

import static com.ray.common.util.ArrayUtil.*;

/**
 * <b>�鲢����</b>
 * <p>
 * ����˼�룺<br/>
 * �鲢���� - ���������������ϲ�Ϊһ���������������<br/>
 * ������һ������ʱ���ݹ�Ľ�����Ϊ������������Ȼ������������鲢������<br/>
 * </p>��
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
                int mid = (lo + hi) / 2;            // �����е�
                mergeSort(arr, lo, mid, temp);      // �������������
                mergeSort(arr, mid + 1, hi, temp);  // �����Ҳ�������
                merge(arr, lo, mid, hi, temp);      // �鲢
            }
        }
		
	}
	
	/**
	 * �Ե����ϵĹ鲢����
	 * @author rays1
	 *
	 * @param <T>
	 */
	public static class DownToUp<T extends Comparable<?>> extends Sort<T> {

        @Override
        public void sort(T[] arr, int lo, int hi) {
            Comparable<?>[] temp = new Comparable<?>[hi-lo+1];
            int N = hi - lo + 1;
            for (int size = 1; size < N; size *= 2) {                            // �ݴε����Ĺ鲢�ߴ�
                for (int l = lo; l < N-size; l += size*2 ) {                     // ѭ������ÿһ�Դ��鲢��������
                    merge(arr, l, (l+size-1), Math.min( l+size*2-1, hi), temp);  // �鲢���Ϊl����Ϊsize���������ڵ�������
                }
            }
        }
        
	}
	
	/**
	 * С������ò���������Ե����Ϲ鲢����
	 * @author rays1
	 *
	 * @param <T>
	 */
	public static class DownToUpInsert<T extends Comparable<?>> extends Sort<T>  {
        @Override
        public void sort(T[] arr, int lo, int hi) {
            Comparable<?>[] temp = new Comparable<?>[hi-lo+1];
            Sort<T> s = new InsertionSort<>();
            int optiSize = 16;  // �л�ѡ������͹鲢����ĳߴ�
            
            int N = hi - lo + 1;
            for (int i = 0; i < N-optiSize; i += optiSize)
                s.sort(arr, i, Math.min(i+optiSize-1, hi));

            for (int size = optiSize; size < N; size *= 2) {                     // �ݴε����Ĺ鲢�ߴ�
                for (int l = lo; l < N-size; l += size*2 ) {                     // ѭ������ÿһ�Դ��鲢��������
                    merge(arr, l, (l+size-1), Math.min( l+size*2-1, hi), temp);  // �鲢���Ϊl����Ϊsize���������ڵ�������
                }
            }
        }
	}
	
	/**
	 * �鲢�ķ���<br>
	 * arr[lo] ~ arr[mid] ���Ѿ����������1<br>
	 * arr[mid+1] ~ arr[hi] ���Ѿ����������2<br>
	 * �鲢Ч����ͬ������������������������λ�ȡ��СԪ�أ�����������С�<br>
	 * �鲢��ɺ󣬴�����Ϊ��Ȼ������״̬��
	 * @param arr   ���������� 
	 * @param mid	�е�
	 * @param hi	�Ͻ�
	 */
	private static void merge(Comparable<?>[] arr, int lo, int mid, int hi, Comparable<?>[] temp){
		
	    for(int i = lo; i <= hi; i++) temp[i] = arr[i];    // ����
		
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
