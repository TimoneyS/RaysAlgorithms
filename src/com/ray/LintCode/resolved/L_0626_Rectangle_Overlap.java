package com.ray.LintCode.resolved;

import com.ray.LintCode.util.Point;
import com.ray.io.Out;

/**
 * 给定两个长方形，检测其是否重叠。
 *
 * 长方形是由其左上和右下的两个点来表示的。
 *      l1 第一个长方形的左上坐标
 *      r1 第一个长方形的右下坐标
 *      l2 第二个长方形的左上坐标
 *      r2 第二个长方形的右下坐标
 * l1 != r2 并且 l2 != r2
 *
 * @author rays1
 *
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
