package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 一个二进制的矩阵表示一个图像，0 表示白色像素，1表示黑色像素
 * 黑色的像素是互相连接的，只有一个黑色的区域。
 * 像素是通过垂直或水平的方式连接，给定一个黑色像素的坐标 (x, y)。返回包含所有黑色像素点的矩阵的最小面积。
 *
 * 如：
 *      0 0 1 0
 *      0 1 1 0
 *      0 1 0 0
 * 给出 x = 0, y = 2，返回 6
 *
 * @author rays1
 *
 */
public class L_0600_Smallest_Rectangle_Enclosing_Black_Pixels {

    /**
     * 按照题意，其实是期望按照给定的黑色像素坐标，从该坐标扩展开来寻找其他的黑色像素。
     * 然后寻找最左，最右，最上，最下的四个像素即可。
     * 
     * 算法复杂度为 黑色像素的个数
     * 
     * 
     * 实际上可以通过遍历图来直接寻找四个黑色像素，复杂度O(mn) 也是可以接受的
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int minArea(char[][] image, int x, int y) {
            int m = image.length, n = image[0].length;
            int x1 = m, x2 = 0, y1 = n, y2 = 0;
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (image[i][j] == '1') {
                        x1 = Math.min(x1, i);
                        x2 = Math.max(x2, i);
                        y1 = Math.min(y1, j);
                        y2 = Math.max(y2, j);
                    }
                }
            }
            
            return (x2-x1+1)*(y2-y1+1);
        }
    
    }
    
    public static void main(String[] args) {
        
        char[][] image = {
                "0010".toCharArray(),
                "0110".toCharArray(),
                "0100".toCharArray(),
        };
        
        int x = 0, y = 0;
        
        Out.p(new Solution().minArea(image, x, y));
        
    }

}
