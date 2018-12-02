package com.ray.LintCode;

import com.ray.io.Out;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0063_Search_in_Rotated_Sorted_Array_II {

    static class Solution {
        /**
         * @param A: an integer ratated sorted array and duplicates are allowed
         * @param target: An integer
         * @return: a boolean 
         */
        public boolean search(int[] A, int target) {
            
            int l = 0, r = A.length - 1;
            if (r == -1) return false;
            if (A[0] == target) return true;
            
            int border = A[0]+1;
            while (l<=r)  {
                int m = (l+r)/2;
                if (A[m] == target) return true;
                
                if ((border > target) ^ (A[m] >= border) ^ (A[m] > target)) { 
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                
            }
            
            l = 0;
            r = A.length - 1;
            border = A[0];
            while (l<=r)  {
                int m = (l+r)/2;
                if (A[m] == target) return true;
                
                if ((border > target) ^ (A[m] >= border) ^ (A[m] > target)) { 
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                
            }
            
            return false;
        }
    }
    
    public static void main(String[] args) {

        //int[] A = { 9,5,6,7,8,9,9,9,9,9,9};
        int[] A = {9, 9, 9, 9, 9, 9, 5, 6, 7, 8, 9};
        
        int target = 8;
        Out.p(A);

        Out.p(new Solution().search(A, target));

    }

}
