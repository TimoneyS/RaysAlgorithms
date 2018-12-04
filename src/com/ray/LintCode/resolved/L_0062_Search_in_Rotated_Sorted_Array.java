package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * <p>
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 * 
 * @author rays1
 *
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