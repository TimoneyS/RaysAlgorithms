package com.rays.algo.sort;

/**
 * <b>选择排序</b>
 * <p>
 * 基本思想 :<br/>
 * 找出数组中的最小元素和数组的第一个元素交换<br/>
 * 在余下的元素中找出最小数组和第二个元素交换<br/>
 * ...
 * <p>
 * 算法特点 :<br/>
 * 1.运行时间和输入无关<br/>
 * 2.数据的移动量最少<br/>
 * @author Ray
 */
public class SelectionSort<T extends Comparable<?>> extends Sort<T> {

//	public void sort(Comparable[] arr) {
//		
//		for(int i = 0; i < arr.length; i++) {
//			int minIdx = i; 
//			for(int j = i;  j < arr.length; j ++) {
//				if(less(arr, j, minIdx)) minIdx = j;
//			}
//			swap(arr, minIdx, i);
//		}
//		
//	}

    @Override
    public void sort(T[] arr, int lo, int hi) {
        
        
    }

}
