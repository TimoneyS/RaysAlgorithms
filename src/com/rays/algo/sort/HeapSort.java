package com.rays.algo.sort;

/**
 * <b>堆排序</b>
 * @author rays1
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T>  {
    
    @Override
    public void sort(T[] arr, int lo, int hi) {
        int N = arr.length;
        for (int k = N/2; k >= 1; k --) sink(arr, k, N); // 使原数组堆有序
        while (N > 1) {
            swap(arr, 1, N--);                           // 将根节点放至未排序部分的末尾，修正未排序部分的边界
            sink(arr, 1, N);                             // 使未排序部分堆有序
        }
    }
    
    /**
     * 下沉操作
     * @param index
     */
    private void sink(T[] arr, int index, int N) {
        while (index * 2 <= N) {                        // 当前索引未超过边界
            int j = index*2;                            // 子节点索引
            if(j < N && less(arr, j, j+1)) j ++;        // 选取较大的子节点的索引
            if(less(arr, index, j)) {                   // 子节点更大
                swap(arr, index, j);                      
                index = j;
            } else {                                    // 当前元素大于子节点
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
