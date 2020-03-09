package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Rectangle Area
 * -----------------------------------------------------------------------------
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Example:
 *      Example 1
 *      Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 *      Output: 45
 *      Note:
 *      Assume that the total area is never beyond the maximum possible value of int.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/rectangle-area/
 * @since   2020-03-09 21:26:55
 */
public class L0223_Rectangle_Area {
    static class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int a = (C - A) * (D - B);
            int b = (G - E) * (H - F);
            int instr =  (A >= G ||C <= E || B >= H || D <= F) ? 0 : (min(C, G) - max(A, E)) * (min(H, D) -  max(B, F));
            return a + b - instr;
        }
        int max (int i, int j) {return  Integer.max(i, j);}
        int min (int i, int j) {return  Integer.min(i, j);}
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
