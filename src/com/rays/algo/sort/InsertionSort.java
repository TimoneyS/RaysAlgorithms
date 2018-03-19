package com.rays.algo.sort;

import com.ray.common.util.ArrayUtil;

/**
 * <b>��������</b>
 * 
 * <p>
 * ����˼�룺<br>
 * 1.���������У���ǰԪ��������Ѿ�����Ĳ��֣��Ҳ���δ���򲿷�<br>
 * 2.�õ�ǰԪ�غ����Ԫ�رȽϣ���������Ԫ��С��ִ�н�����ֱ������������λ�����Ԫ�ز��ٸ���<br>
 * <br>
 * @author Ray
 */
public class InsertionSort<T extends Comparable<?>> extends Sort<T> {

    @Override
    public void sort(T[] arr, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {                                     // ѭ������Ԫ��
            for (int j = i; j > lo && ArrayUtil.less(arr, j, j-1); j --) {   // ��ǰԪ������Ƚ�
                ArrayUtil.swap(arr, j, j-1);
            }
        }
    }
	
}
