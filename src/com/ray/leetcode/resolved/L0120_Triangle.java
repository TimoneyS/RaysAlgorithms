package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.List;

/**
 * Triangle
 * -----------------------------------------------------------------------------
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/triangle/
 * @since   2020-03-04 21:41:42
 */
public class L0120_Triangle {
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int min = triangle.get(0).get(0);
            for (int i = 1; i < triangle.size(); i++) {
                int n = triangle.get(i).size();
                triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i-1).get(0));
                triangle.get(i).set(n-1, triangle.get(i).get(n-1) + triangle.get(i-1).get(n-2));
                min = Math.min(triangle.get(i).get(0), triangle.get(i).get(n-1));
                for (int j = 1; j < n-1; j++) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
                    min = Math.min(min, triangle.get(i).get(j));
                }
            }
            return min;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
