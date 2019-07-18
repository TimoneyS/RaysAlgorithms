package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the `minimal` distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most `one nut` at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: height = 5, width = 7,
 *        treePosition = [2, 2],
 *        squirrelPosition = [4, 4],
 *        nuts = [[3, 0], [2, 5]]
 *      Output: 12
 *      ```
 *      
 *      ![](https://lintcode-media.s3.amazonaws.com/problem/22431521269467_.pic_hd.jpg)
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: height = 1, width = 3,
 *        treePosition = [0,1],
 *        squirrelPosition = [0,0],
 *        nuts = [[0,2]]
 *      Output: 3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/squirrel-simulation/description
 * @date   2019-07-11 18:38:11
 */
public class L_0873_Squirrel_Simulation {


    /**
     * 无论松鼠先拿拿一颗，其返回树和剩下的松果所需的距离都是 其到树的曼哈顿距离的两倍
     * 那么只要找到离松鼠最近的松果，先拿这一颗即可。
     * @author rays1
     *
     */
    static class Solution {
    
        public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
            int sum = 0, max = 0;
            for (int[] nut : nuts) {
                int d  = md(tree, nut);
                int d2 = md(squirrel, nut); 
                
                sum += d+d;
                max = Math.max(max, d-d2);
            }
            return sum-max;
        }
        
        public int md(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1]-p2[1]);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
