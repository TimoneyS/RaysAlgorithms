package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).
 *
 * @author rays1
 * @url    
 */
public class L_0886_Convex_Polygon {

    /**
     * 计算相邻的点的法向量
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isConvex(int[][] points) {
            int n = points.length, pre = 0, cur = 0;
            for (int i = 0; i < n; ++i) {
                int dx1 = points[(i + 1) % n][0] - points[i][0];
                int dx2 = points[(i + 2) % n][0] - points[i][0];
                int dy1 = points[(i + 1) % n][1] - points[i][1];
                int dy2 = points[(i + 2) % n][1] - points[i][1];
                cur = dx1 * dy2 - dx2 * dy1;
                if (cur != 0) {
                    if (cur * pre < 0) return false;
                    else pre = cur;
                }
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
