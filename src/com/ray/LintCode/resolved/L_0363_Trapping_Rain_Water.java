package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定n个非负整数表示每个条的宽度为1的高程图，计算下雨后能够捕获多少水。
 * 
 *  |——|
 *  |  |ww ww ww|——| 
 *  |  |——|ww ww|  |
 *  |  |  |——|——|  |
 *  ————————————————————
 *  如图所示 数组为 [4, 2, 1, 1, 3], 返回 5
 *  
 * @author rays1
 *
 */
public class L_0363_Trapping_Rain_Water {

    /**
     * 从左到右计算到每个点的最大高度，结果得到每个点往左的最大高度
     * 从右到做计算到每个点的最大高度，结果得到每个点往右的最大高度
     * 
     * 对于每个点，   水深 = min(左边最大高度，右边最大高度)
     * 然后计算          该点的储水量 = Max(0, 水深 - 高度)
     * 
     * 算法复杂度为 O(n)
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int trapRainWater(int[] heights) {
            
            int[] left = new int[heights.length];
            int[] right = new int[heights.length];
            
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                max = Math.max(max, heights[i]);
                left[i] = max;
            }
            
            max = 0;
            for (int i = heights.length-1; i >= 0; i--) {
                max = Math.max(max, heights[i]);
                right[i] = max;
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
        
        int[] heights = {4, 2, 1, 1, 3};
        
//        int[] heights = ArrayUtil.intArr(10);
//        ArrayUtil.shuffle(heights);
//        Out.p(heights);
        
        Out.p(new Solution().trapRainWater(heights));
    }

}
