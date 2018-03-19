package com.rays.algo.sort;

/**
 * <b>������</b>
 * @author rays1
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T>  {
    
    @Override
    public void sort(T[] arr, int lo, int hi) {
        int N = arr.length;
        for (int k = N/2; k >= 1; k --) sink(arr, k, N); // ʹԭ���������
        while (N > 1) {
            swap(arr, 1, N--);                           // �����ڵ����δ���򲿷ֵ�ĩβ������δ���򲿷ֵı߽�
            sink(arr, 1, N);                             // ʹδ���򲿷ֶ�����
        }
    }
    
    /**
     * �³�����
     * @param index
     */
    private void sink(T[] arr, int index, int N) {
        while (index * 2 <= N) {                        // ��ǰ����δ�����߽�
            int j = index*2;                            // �ӽڵ�����
            if(j < N && less(arr, j, j+1)) j ++;        // ѡȡ�ϴ���ӽڵ������
            if(less(arr, index, j)) {                   // �ӽڵ����
                swap(arr, index, j);                      
                index = j;
            } else {                                    // ��ǰԪ�ش����ӽڵ�
                break;
            }
        }
        
    }

    private boolean less(T[] arr, int i, int j) {
        return arr[i-1].compareTo(arr[j-1]) < 0;
    }

    private void swap(T[] arr, int i, int j) {
        T swap = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = swap;        
    }
	
}
