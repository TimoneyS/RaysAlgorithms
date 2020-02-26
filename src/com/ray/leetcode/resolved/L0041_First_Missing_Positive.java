package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,0]
 *      Output: 3
 *      Example 2
 *      Input: [3,4,-1,1]
 *      Output: 2
 *      Example 3
 *      Input: [7,8,9,11,12]
 *      Output: 1
 *      Note:
 *      Your algorithm should run in O(n) time and uses constant extra space.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/first-missing-positive/
 * @since   2020-02-26 19:25:06
 */
public class L0041_First_Missing_Positive {
    /**
     * 建立映射
     */
    static class Solution {
        public int firstMissingPositive(int[] A) {
            if (A == null) return 1;

            for (int i = 0; i < A.length; i++) {
                while (A[i] > 0 && A[i] <= A.length && A[i] != (i + 1)) {
                    int tmp = A[A[i] - 1];
                    if (tmp == A[i]) {
                        break;
                    }
                    A[A[i] - 1] = A[i];
                    A[i] = tmp;
                }
            }

            for (int i = 0; i < A.length; i++)
                if (A[i] != i + 1) return i + 1;

            return A.length + 1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
