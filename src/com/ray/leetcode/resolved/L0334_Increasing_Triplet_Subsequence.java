package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Increasing Triplet Subsequence
 * -----------------------------------------------------------------------------
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3,4,5]
 *      Output: true
 *      Example 2
 *      Input: [5,4,3,2,1]
 *      Output: false
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * @since   2020-03-14 13:42:54
 */
public class L0334_Increasing_Triplet_Subsequence {
    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            // n1 表示递增 1 的最小尾部值
            // n2 表示递增 2 的最小尾部值
            Integer n1 = null, n2 = null;
            for (int i : nums) {
                if (n1 == null || n1 >= i) n1 = i;
                else if (n2 == null || n2 >= i) n2 = i;
                else return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
