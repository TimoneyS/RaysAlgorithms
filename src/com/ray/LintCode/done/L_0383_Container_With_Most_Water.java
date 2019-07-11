package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given n non-negative integers a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>n</sub>, where each represents a point at coordinate `(i, ai)`. *n* vertical lines are drawn such that the two endpoints of line *i* is at `(i, ai)` and `(i, 0)`. Find two lines, which together with *x*-axis forms a container, such that the container contains the most water.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [1, 3, 2]
 *      Output: 2
 *      Explanation:
 *      Selecting a1, a2, capacity is 1 * 1 = 1
 *      Selecting a1, a3, capacity is 1 * 2 = 2
 *      Selecting a2, a3, capacity is 2 * 1 = 2
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [1, 3, 2, 2]
 *      Output: 4
 *      Explanation:
 *      Selecting a1, a2, capacity is 1 * 1 = 1
 *      Selecting a1, a3, capacity is 1 * 2 = 2
 *      Selecting a1, a4, capacity is 1 * 3 = 3
 *      Selecting a2, a3, capacity is 2 * 1 = 2
 *      Selecting a2, a4, capacity is 2 * 2 = 4
 *      Selecting a3, a4, capacity is 2 * 1 = 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/container-with-most-water/description
 * @date   2019-07-11 18:32:22
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
        
        Out.p(new Solution());
        
    }

}
