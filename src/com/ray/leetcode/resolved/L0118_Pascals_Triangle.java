package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle
 * -----------------------------------------------------------------------------
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *      Example 1
 *      Input: 5
 *      Output:
 *      [
 *           [1],
 *          [1,1],
 *         [1,2,1],
 *        [1,3,3,1],
 *       [1,4,6,4,1]
 *      ]
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/pascals-triangle/
 * @since   2020-03-04 21:40:03
 */
public class L0118_Pascals_Triangle {
    /**
     *      1
     *     1 1
     *    1 2 1
     *   1 3 3 1
     * ---------------
     *   1
     *   1 1
     *   1 2 1
     *   1 3 3 1
     *
     * 每一行的数字数量等于行号
     * a[i][j] = a[i-1][j-1] + a[i-i][j]
     */
    static class Solution {
        public List<List<Integer>> generate(int n) {
            List<List<Integer>> rs = new ArrayList<>();
            if (n != 0) {
                rs.add(Arrays.asList(new Integer[] {1}));
            }

            for (int i = 1; i < n; i++) {
                List<Integer> curr = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    int l = j == 0 ? 0 : rs.get(i-1).get(j-1);
                    int u = j == i ? 0 : rs.get(i-1).get(j);
                    curr.add(l+u);
                }
                rs.add(curr);
            }

            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
