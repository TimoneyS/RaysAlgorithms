package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle II
 * -----------------------------------------------------------------------------
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *      Example 1
 *      Input: 3
 *      Output: [1,3,3,1]
 *      Follow up:
 *      Could you optimize your algorithm to use only O(k) extra space?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @since   2020-03-04 21:41:11
 */
public class L0119_Pascals_Triangle_II {
    /**
     * 类似于Dijkstra算法思想
     */
    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            rowIndex ++;
            Integer[] arr = new Integer[rowIndex];
            Arrays.fill(arr, 0);
            arr[0] = 1;
            for (int i = 0; i < rowIndex; i++) {
                for (int j = i; j > 0; j--) {
                    arr[j] += arr[j-1];
                }
            }
            return Arrays.asList(arr);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
