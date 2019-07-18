package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given *n* non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it is able to trap after raining.
 *      
 *      ![Trapping Rain Water](https://lintcode-media.s3.amazonaws.com/problem/rainwatertrap.png "Trapping Rain Water I")
 *  |——|
 *  |  |ww ww ww|——| 
 *  |  |——|ww ww|  |
 *  |  |  |——|——|  |
 *  ————————————————————
 *  如图所示 数组为 [4, 2, 1, 1, 3], 返回 5
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: [0,1,0]
 *      Output: 0
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 *      Output: 6
 *      ```
 *
 * 挑战：
 *      O(n) time and O(1) memory
 *      
 *      O(n) time and O(n) memory is also acceptable.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/trapping-rain-water/description
 * @date   2019-07-11 18:32:09
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
