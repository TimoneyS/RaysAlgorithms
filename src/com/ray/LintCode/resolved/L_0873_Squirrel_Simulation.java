package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid.
 * Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one.
 * The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right,
 * to the adjacent cell. The distance is represented by the number of moves.
 *
 * @author rays1
 * @url    https://www.lintcode.com/problem/squirrel-simulation/description
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
        
//        height = 5, width = 7,
//                treePosition = [2, 2],
//                squirrelPosition = [4, 4],
//                nuts = [[3, 0], [2, 5]]
        
        int height = 5, width = 7;
        int[] tree = {2, 2};
        int[] squirrel = {4, 4};
        int[][] nuts = {
                {3, 0},
                {2, 5}
        };
        
        Out.p(new Solution().minDistance(height, width, tree, squirrel, nuts));
        
    }

}
