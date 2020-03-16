package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Self Crossing
 * -----------------------------------------------------------------------------
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north,
 * then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on.
 * In other words, after each move your direction changes counter-clockwise.
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 *
 * Example:
 *      Example 1
 *      ┌───┐
 *      │   │
 *      └───┼──>
 *          │
 *      Input: [2,1,1,2]
 *      Output: true
 *      Example 2
 *      ┌──────┐
 *      │      │
 *      │
 *      │
 *      └────────────>
 *      Input: [1,2,3,4]
 *      Output: false 
 *      Example 3
 *      ┌───┐
 *      │   │
 *      └───┼>
 *      Input: [1,1,1,1]
 *      Output: true 
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/self-crossing/
 * @since   2020-03-14 19:44:17
 */
public class L0335_Self_Crossing {
    /**
     * 可能会相交的情况
     * (0,1) 不会相交
     * (1,2) 不会相交
     * (2,3) 不会相交
     * (3,4) 可能相交 (0,1) (1,2)
     * (4,5) 可能相交 (0,1) (1,2)
     * (5,6) 可能相交 (0,1) (1,2) (2,3)
     * (6,7) 可能相交 (1,2) (2,3) (3,4)
     * 因此可以保存 6 个顶点，每次遇到新的点和之前的比较，如果继续优化的话可能不需要保存点
     */
    static class Solution {
        int[][] DIRS = new int[][] {{ 0, 1}, {-1, 0}, { 0,-1}, { 1, 0}};
        public boolean isSelfCrossing(int[] x) {
            if (x.length < 4) return false;
            int[][] cache = new int[7][2];
            for (int i = 0; i < x.length;i++) {
                cache[(i+1) % 7][0] = cache[i%7][0] + x[i] * DIRS[i % 4][0];
                cache[(i+1) % 7][1] = cache[i%7][1] + x[i] * DIRS[i % 4][1];
                if (i > 2 && isCrossing(cache, i+1, i, i-2, i-3) ||
                    i > 3 && isCrossing(cache, i+1, i, i-3, i-4) ||
                    i > 4 && isCrossing(cache, i+1, i, i-4, i-5)
                ) {
                    return true;
                }
            }
            return false;
        }

        boolean isCrossing(int[][] cache, int a, int b, int c, int d) {
            int[] p1 = cache[a % 7], p2 = cache[b % 7], p3 = cache[c%7], p4 = cache[d%7];
            return Math.min(p1[0], p2[0]) <= Math.max(p3[0], p4[0]) &&
                    Math.max(p1[0], p2[0]) >= Math.min(p3[0], p4[0]) &&
                    Math.min(p1[1], p2[1]) <= Math.max(p3[1], p4[1]) &&
                    Math.max(p1[1], p2[1]) >= Math.min(p3[1], p4[1]);
        }
    }
    
    public static void main(String[] args) {
        int[] x = {1,1,2,1,1};
        Out.p(new Solution().isSelfCrossing(x));
    }
}
