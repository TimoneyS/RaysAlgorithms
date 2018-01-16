package com.rays.algo.sort;

import com.ray.common.utils.ArrayUtil;

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
            int mixIndex = ArrayUtil.getIndexOfMin(arr, i, hi);
            ArrayUtil.swap(arr, i, mixIndex);
        }
    }

}
