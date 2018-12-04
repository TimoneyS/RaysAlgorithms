package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * There is an integer array which has the following features: The numbers in
 * adjacent positions are different. A[0] < A[1] && A[A.length - 2] > A[A.length
 * - 1].
 * 
 * We define a position P is a peak if: A[P] > A[P-1] && A[P] > A[P+1]
 * 
 * Find a peak element in this array. Return the index of the peak.
 * 
 * <P>
 * Given [1, 2, 1, 3, 4, 5, 7, 6] Return index 1 (which is number 2) or 6 (which
 * is number 7)
 * 
 * @author rays1
 *
 */
public class L_0075_Find_Peak_Element {

    static class Solution {
        /**
         * @param A:
         *            An integers array.
         * @return: return any of peek positions.
         */
        public int findPeak(int[] A) {
            // write your code here
            int start = 1, end = A.length - 2; // 1.答案在之间，2.不会出界
            while (start + 1 < end) {
                int mid = (start + end) / 2;
                if (A[mid] < A[mid - 1]) {
                    end = mid;
                } else if (A[mid] < A[mid + 1]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (A[start] < A[end]) {
                return end;
            } else {
                return start;
            }
        }
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,2,1,2,1,2,3,4,5,6,7,8,9,8};
        
        Out.p(new Solution().findPeak(A));
        
    }

}
