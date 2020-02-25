package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Example:
 *      Example 1
 *      Input: [1,3,5,6], 5
 *      Output: 2
 *      Example 2
 *      Input: [1,3,5,6], 2
 *      Output: 1
 *      Example 3
 *      Input: [1,3,5,6], 7
 *      Output: 4
 *      Example 4
 *      Input: [1,3,5,6], 0
 *      Output: 0
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/search-insert-position/
 * @since   2020-02-25 23:00:23
 */
public class L0035_Search_Insert_Position {
    /**
     * 二分搜索原理
     */
    static class Solution {
        public int searchInsert(int[] A, int target) {
            int l = 0,r = A.length-1;
            if (r==-1) return 0;
            while (l<r) {
                int m = (l+r)/2;
                if (target == A[m]) return m;
                if (target > A[m])      l = m+1;
                else if (target < A[m]) r = m-1;
            }
            return (l>r) ? l : (A[r] >= target) ? r : r+1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
