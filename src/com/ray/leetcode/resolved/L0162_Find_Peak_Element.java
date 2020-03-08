package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Find Peak Element
 * -----------------------------------------------------------------------------
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] &ne; nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -&infin;.
 *
 * Example:
 *      Example 1
 *      Input: nums = [1,2,3,1]
 *      Output: 2
 *      Explanation: 3 is a peak element and your function should return the index number 2.
 *      Example 2
 *      Input: nums = [1,2,1,3,5,6,4]
 *      Output: 1 or 5 
 *      Explanation: Your function can return either index number 1 where the peak element is 2, 
 *                   or index number 5 where the peak element is 6.
 *      Note:
 *      Your solution should be in logarithmic complexity.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-peak-element/
 * @since   2020-03-07 21:37:30
 */
public class L0162_Find_Peak_Element {
    static class Solution {
        public int findPeakElement(int[] A) {
            if (A.length < 2 || A[0] > A[1]) {
                return 0;
            }
            if (A[A.length-1] > A[A.length-2]) {
                return A.length - 1;
            }
            int l = 1, r = A.length - 2; // 1.答案在之间，2.不会出界
            while (l + 1 < r) {
                int m = (l + r) / 2;
                if (A[m] < A[m + 1]) {
                    l = m;
                } else {
                    r = m;
                }
            }
            if (A[l] < A[r]) {
                return r;
            } else {
                return l;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        Out.p(new Solution().findPeakElement(A));
    }
}
