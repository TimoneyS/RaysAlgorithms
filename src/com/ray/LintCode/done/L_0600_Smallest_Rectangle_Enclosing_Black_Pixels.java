package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      An image is represented by a binary matrix with `0` as a white pixel and `1` as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location `(x, y)` of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：["0010","0110","0100"]，x=0，y=2
 *      Output：6
 *      Explanation：
 *      The upper left coordinate of the matrix is (0,1), and the lower right coordinate is (2,2).
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：["1110""1100""0000""0000"], x = 0, y = 1
 *      Output：6
 *      Explanation：
 *      The upper left coordinate of the matrix is (0, 0), and the lower right coordinate is (1,2).
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/smallest-rectangle-enclosing-black-pixels/description
 * @date   2019-07-11 18:34:24
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
