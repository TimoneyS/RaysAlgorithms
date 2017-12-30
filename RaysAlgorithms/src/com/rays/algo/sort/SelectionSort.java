package com.rays.algo.sort;

import static com.ray.common.utils.ArrayUtil.*;

/**
 * <b>ѡ������</b>
 * <p>
 * ����˼�룺<br/>
 * 1.����δ����Ĳ��֡�<br/>
 * 2.�ҳ���СԪ�أ������δ����ĵ�һ��Ԫ�ؽ�������Ԫ�ر�������<br/>
 * 3.�ظ� 1 2 ֱ������Ԫ��������
 * <p>
 * �㷨�ص㣺<br/>
 * 1.����ʱ��������޹�<br/>
 * 2.���ݵ��ƶ�������<br/>
 * @author Ray
 */
public class SelectionSort {

	@SuppressWarnings({ "rawtypes" })
	public static void sort(Comparable[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int minIdx = i; 
			for(int j = i;  j < arr.length; j ++) {
				if(less(arr, j, minIdx)) minIdx = j;
			}
			swap(arr, minIdx, i);
		}
		
	}

}
