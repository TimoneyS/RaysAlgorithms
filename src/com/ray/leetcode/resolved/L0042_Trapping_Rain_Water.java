package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/trapping-rain-water/
 * @since   2020-02-26 23:01:21
 */
public class L0042_Trapping_Rain_Water {
    /**
     * 从左到右计算到每个点的最大高度，结果得到每个点往左的最大高度
     * 从右到做计算到每个点的最大高度，结果得到每个点往右的最大高度
     *
     * 对于每个点，   水深 = min(左边最大高度，右边最大高度)
     * 然后计算          该点的储水量 = Max(0, 水深 - 高度)
     *
     * 算法复杂度为 O(n)
     */
    static class Solution {
        public int trap(int[] heights) {
            int[] left = new int[heights.length];
            int[] right = new int[heights.length];

            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                left[i] = (max = Math.max(max, heights[i]));
            }

            max = 0;
            for (int i = heights.length-1; i >= 0; i--) {
                right[i] = (max = Math.max(max, heights[i]));
            }

            int sum = 0;
            for (int i = 0; i < heights.length; i++ ) {
                int t = Math.min(left[i], right[i]) - heights[i];
                if (t > 0) sum += t;
            }
            return sum;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
