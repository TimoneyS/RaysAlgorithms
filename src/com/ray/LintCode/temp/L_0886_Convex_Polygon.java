package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a list of points that form a polygon when joined sequentially, find if this polygon is convex ([Convex polygon definition](https://en.wikipedia.org/wiki/Convex_polygon "Convex polygon definition")).
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: points = [[0, 0], [0, 1], [1, 1], [1, 0]]
 *      	Output:  true
 *      	
 *      	Explanation:
 *      ```
 *      ![](https://lintcode-media.s3.amazonaws.com/problem/E3N5G.png)
 *      
 *      ```
 *      Example 2:
 *      	Input:  points = [[0, 0], [0, 10], [10, 10], [10, 0], [5, 5]]
 *      	Output:  false
 *      	
 *      	Explanation:
 *      ```
 *      ![](https://lintcode-media.s3.amazonaws.com/problem/E3f02.png)
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/convex-polygon/description
 * @date   2019-07-11 18:38:18
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
