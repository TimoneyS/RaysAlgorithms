package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an&nbsp;, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note:&nbsp;You may not slant the container and n is at least 2.
 * &nbsp;
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain&nbsp;is 49. 
 * &nbsp;
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/container-with-most-water/
 * @since   2020-02-23 20:56:41
 */
public class L0011_Container_With_Most_Water {
    /**
     * 左右指针在两端，分别向中间移动，每次计算面积
     * 移动时每次只移动短木板，因为移动长木板一定会使面积不变或变小（木桶效应）。
     *
     * 利用木桶效应，包围解决，每次替换短的木板
     * @author rays1
     *
     */
    static class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length-1, max = 0;
            while (l < r) {
                max = Math.max(Math.min(height[l], height[r]) * ( r - l), max);
                if (height[l] < height[r]) l ++;
                else r --;
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
