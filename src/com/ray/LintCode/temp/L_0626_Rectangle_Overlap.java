package com.ray.LintCode.temp;

import com.ray.LintCode.util.Point;
import com.ray.io.Out;

/**
 * 描述：
 *      Given two rectangles, find if the given two rectangles overlap or not.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : l1 = [0, 8], r1 = [8, 0], l2 = [6, 6], r2 = [10, 0]
 *      Output : true
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : l1 = [0, 8], r1 = [8, 0], l2 = [9, 6], r2 = [10, 0]
 *      Output : false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rectangle-overlap/description
 * @date   2019-07-11 18:34:33
 */
public class L_0626_Rectangle_Overlap {

    /**
     * 反向考虑更容易理解一些，考虑不重叠的情况，只有四种可能
     * 1 在 2 左边或右边
     * 1 在 2 上边或下边
     * 左上右上之类的情况已经包含在左右或上下中
     * 
     * 剩下的情况都是重叠的
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
            return (l2.x <= r1.x && r2.x >= l1.x
                    && l2.y >= r1.y && r2.y <= l1.y);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
