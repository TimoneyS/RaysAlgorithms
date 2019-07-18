package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array, sort it in ascending order in place. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
 *
 * 用例：
 *      **Example1:**
 *      ```
 *      Input: [3, 2, 1, 4, 5], 
 *      Output: [1, 2, 3, 4, 5].
 *      ```
 *      **Example2:**
 *      ```
 *      Input: [2, 3, 1], 
 *      Output: [1, 2, 3].
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sort-integers-ii/description
 * @date   2019-07-11 18:33:21
 */
public class L_0464_Sort_Integers_II {

    static class Solution {
        /**
         * @param A an integer array
         * @return void
         */
        public void sortIntegers2(int[] A) {
            int[] temp = new int[A.length];
            sort(A, 0, A.length-1, temp);
        }
        
        public void sort(int[] arr, int lo, int hi, int[] temp) {
                if(lo < hi) {
                    int mid = (hi+lo)/2;
                    sort(  arr,    lo,  mid , temp);
                    sort(  arr, mid+1,  hi  , temp);
                    merge( arr,    lo, mid, hi, temp);
                }
        }
        
        private void merge(int[] arr, int lo, int mid,int hi ,int[] temp){
            for(int i = lo; i <= hi; i++) temp[i] = arr[i];
            int l = lo, r = mid+1, i = lo;
            while(l <= mid || r <= hi) {
                if(l > mid)                 arr[i++] = temp[r++];
                else if(r > hi)             arr[i++] = temp[l++];
                else if(temp[l] < temp[r])  arr[i++] = temp[l++];
                else                        arr[i++] = temp[r++];
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
