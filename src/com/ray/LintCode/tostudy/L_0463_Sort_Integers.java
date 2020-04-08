package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n<sup>2</sup>) algorithm.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  [3, 2, 1, 4, 5]
 *      	Output: [1, 2, 3, 4, 5]
 *      	
 *      	Explanation: 
 *      	return the sorted array.
 *      
 *      Example 2:
 *      	Input:  [1, 1, 2, 1, 1]
 *      	Output: [1, 1, 1, 1, 2]
 *      	
 *      	Explanation: 
 *      	return the sorted array.
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Native
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sort-integers/description
 * @date   2019-07-11 18:33:20
 */
public class L_0463_Sort_Integers {

    static class Solution {
        public void sortIntegers(int[] A) {
            for (int i = 0; i < A.length; i++) {
                for(int j = A.length - 1; j > i; j--)
                    if(A[j] < A[j-1]) swap(A, j, j-1);
            }
        }
        
        public void swap(int[] arr, int i, int j) {
            if (i==j) return;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
