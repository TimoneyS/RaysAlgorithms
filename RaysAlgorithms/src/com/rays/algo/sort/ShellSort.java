package com.rays.algo.sort;

import com.ray.common.utils.ArrayUtil;

/**
 * <b>ϣ������</b>
 * <p>
 * ����˼�� :<br/>
 * ʹ�������������h��Ԫ��������ģ���h����<br/>
 * ֮������Сh�������Сh����<br/>
 * ��h��СΪ1ʱ������������������<br/>
 * ...
 * <p>
 * @author rays1
 *
 * @param <T>
 */
public class ShellSort<T extends Comparable<?>> extends Sort<T> {
	
    @Override
    public void sort(T[] arr, int lo, int hi) {
        int h = (hi-lo+1)/3;
        while (h >= 1) {
            for (int i = lo+h; i <= hi; i ++) {
                for (int j = i; (j-lo) >= h && ArrayUtil.less(arr, j, j-h); j -= h) {
                    ArrayUtil.swap(arr, j, j-h);
                }
            }
            h = (h == 2) ? 1 : h/3;
        }
    }
	
}
