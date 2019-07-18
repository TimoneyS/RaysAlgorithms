package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *      
 *      (i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).
 *      
 *      You are given a target value to search. If found in the array return its index, otherwise return -1.
 *      
 *      You may assume no duplicate exists in the array.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: [4, 5, 1, 2, 3] and target=1, 
 *      Output: 2.
 *      ```
 *      Example 2:
 *      ```
 *      Input: [4, 5, 1, 2, 3] and target=0, 
 *      Output: -1.
 *      ```
 *
 * 挑战：
 *      O(logN) time
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-in-rotated-sorted-array/description
 * @date   2019-07-11 18:20:39
 */
public class L_0062_Search_in_Rotated_Sorted_Array {

    static class Solution {
        
        /**
         * @param A: an integer rotated sorted array
         * @param target: an integer to be searched
         * @return: an integer
         */
        public int search(int[] A, int target) {
            
            int l = 0, r = A.length - 1;
            if (r == -1) return -1;
            if (A[0] == target) return 0;
            
            while (l<=r)  {
                int m = (l+r)/2;
                if (A[m] == target) return m;
                if ((A[0] > target) ^ (A[m] >= A[0]) ^ (A[m] > target)) { 
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                
            }
            
            return -1;
        }
        
    }

    public static void main(String[] args) {
        
//        Integer[] arr = ArrayUtil.intArrRotate(20, 10);
//        
//        int[] A = new int[arr.length];
//        for (int i = 0; i < A.length; i++) {
//            A[i] = arr[i];
//        }
        
        int[] A = {1,2,3,4,5};
        int target = 4;
        Out.p(A);
        
       Out.p( new Solution().search(A, target));
        
        
    }

}
