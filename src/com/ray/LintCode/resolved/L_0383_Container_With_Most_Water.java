package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * n 个正整数 [ a1, a2, ... , an ] ，每个数字表示一个点，坐标为 (i, ai)
 * 每个点到x轴都存在一条垂线，两个垂线和x轴可以构成一个容器的形状。
 * 寻找可以使得容器盛水最多的两个垂线，返回可以容器的水量。
 * 
 * 如 [1,3,2]，返回 2
 *
 * @author rays1
 *
 */
public class L_0383_Container_With_Most_Water {

    /**
     * 左右指针在两端，分别向中间移动，每次计算面积
     * 移动时每次只移动短木板，因为移动长木板一定会使面积不便或变小（木桶效应）。
     * 
     * 利用木桶效应，包围解决，每次替换短的木板
     * @author rays1
     *
     */
    static class Solution {
    
        public int maxArea(int[] heights) {
            int l = 0, r = heights.length-1, max = 0;
            while (l < r) {
                max = Math.max(Math.min(heights[l], heights[r]) * ( r - l), max);
                if (heights[l] < heights[r]) l ++;
                else r --;
            }
            return max;
            
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] heights = {2,3,10,5,7,8,9};
        Solution sol = new Solution();
        Out.p(sol.maxArea(heights));
        
    }

}
