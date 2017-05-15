package com.rays.sort;

import static com.rays.utils.ArrayUtil.*;
import com.rays.utils.Timer;
import static com.rays.utils.CompareUtil.*;

/**
 * ѡ������Ļ���˼���ǣ�<br/>
 * 1.����δ����Ĳ��֡�<br/>
 * 2.�ҳ���СԪ�أ������δ����ĵ�һ��Ԫ�ؽ�������Ԫ�ر�������<br/>
 * 3.�ظ� 1 2 ֱ������Ԫ��������
 * @author Ray
 */
public class SelectionSort {

	@SuppressWarnings({ "rawtypes" })
	public static void sort(Comparable[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int minIdx = i; 
			for(int j = i;  j < arr.length; j ++) {
				if(less(arr[minIdx], arr[j])) minIdx = j;
			}
			swap(arr, minIdx, i);
		}
		
	}
	
	public static void main(String[] args) {
		
		Integer[] arr = intArr(10000); 
//		p(arr);
		
		Timer.click();
		shuffle(arr);
//		p(arr);
		checkSort(arr);
		
		Timer.click();
		sort(arr);
		Timer.click();
//		p(arr);
		checkSort(arr);
		
	}

}
