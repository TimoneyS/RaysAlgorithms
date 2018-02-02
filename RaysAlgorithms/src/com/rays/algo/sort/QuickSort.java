package com.rays.algo.sort;

import static com.ray.common.util.ArrayUtil.less;
import static com.ray.common.util.ArrayUtil.swap;

/**
 * <b>��������</b>
 * <p>
 * ����˼�룺<br>
 * ���ٵ�����Ҳ�ǽ����黮��Ϊ������Ȼ�������㷨�ĺ�������Ѱ�ҷָ�㡣<br>
 * �ָ���������һ��Ԫ�أ�������Ԫ��С�������Ҳ��Ԫ�ش�����<br>
 * Ȼ�����շָ�㻮�������飬�����������Ӧ�÷ָ����ҡ�
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
     * �зַ���
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    private int partition(T[] arr, int lo, int hi) {
        int l = lo + 1;                                 // �������
        int r = hi;                                     // �Ҳ�����
        while (true) {
            while (less(arr, lo, r) && r > lo) r --;    // ���Ҳ�Ѱ��һ��������arr[lo]��Ԫ��
            while (less(arr, l, lo) && l < hi) l ++;    // �����Ѱ��һ����С��arr[lo]��Ԫ��
            if (r > l) swap(arr, r, l);                 // �����Ҳ಻����������Ԫ���໥����
            else break;
        }
        swap(arr, r, lo);                               // r����λ�ü�Ϊ�е㣬��arr[lo]�����е�
        return r;
    }
	
}
