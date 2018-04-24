package com.rays.algo.sort;

import com.ray.util.RArrays;

/**
 * <b>ѡ������</b>
 * <p>
 * ����˼�� :<br/>
 * �ҳ������е���СԪ�غ�����ĵ�һ��Ԫ�ؽ���<br/>
 * �����µ�Ԫ�����ҳ���СԪ�غ�����ڶ���Ԫ�ؽ���<br/>
 * ...
 * <p>
 * �㷨�ص� :<br/>
 * 1.����ʱ��������޹�<br/>
 * 2.���ݵ��ƶ�������<br/>
 * @author Ray
 */
public class SelectionSort<T extends Comparable<?>> extends Sort<T> {

    @Override
    public void sort(T[] arr, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            int minIndex = RArrays.getIndexOfMin(arr, i, hi);
            RArrays.swap(arr, i, minIndex);
        }
    }

}
