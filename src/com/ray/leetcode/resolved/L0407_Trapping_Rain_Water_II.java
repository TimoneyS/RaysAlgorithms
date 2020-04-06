package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Trapping Rain Water II
 * -----------------------------------------------------------------------------
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 *
 * Example:
 *      Example 1
 *      Given the following 3x6 height map:
 *      [
 *        [1,4,3,1,3,2],
 *        [3,2,1,3,2,4],
 *        [2,3,3,2,3,1]
 *      ]
 *      Return 4.
 *      The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 *      After the rain, water is trapped between the blocks. The total volume of water trapped is 4.
 *      Constraints:
 *      	1 <= m, n <= 110
 *      	0 <= heightMap[i][j] <= 20000
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/trapping-rain-water-ii/
 * @since   2020-04-04 17:17:45
 */
public class L0407_Trapping_Rain_Water_II {
    /**
     * 从边缘开始，每次寻找最矮的边界，维护一个当前最矮边界高度
     * 如果某个点小于这个高度，说明这个点可以储水。
     */
    static class Solution {

        class Node {
            int x, y;
            int height;
            public Node(int x, int y, int height) {
                super();
                this.x = x;
                this.y = y;
                this.height = height;
            }
        }

        int m, n;
        static int[][] dirs = {
                { 1,  0},
                {-1,  0},
                { 0,  1},
                { 0, -1},
        };

        public int trapRainWater(int[][] heights) {
            m = heights.length;
            n = heights[0].length;

            boolean[][] marked = new boolean[m][n];
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.height));

            for (int i = 0; i < m; i ++) {
                pq.add(new Node(i, 0, heights[i][0]));
                pq.add(new Node(i, n-1, heights[i][n-1]));
                marked[i][0] = true;
                marked[i][n-1] = true;
            }

            for (int j = 1; j < n - 1; j ++) {
                pq.add(new Node(0,   j, heights[0][j]));
                pq.add(new Node(m-1, j, heights[m-1][j]));
                marked[0][j] = true;
                marked[m-1][j] = true;
            }

            int deep = -1;
            int rs   = 0;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                deep = Math.max(deep, node.height);

                if (node.height < deep) {
                    rs += (deep - node.height);
                }

                for (int[] dir : dirs) {
                    int tx = node.x + dir[0], ty = node.y + dir[1];
                    if (tx < 0 || ty < 0 || tx >= m || ty >= n || marked[tx][ty]) continue;
                    marked[tx][ty] = true;
                    pq.add(new Node(tx, ty, heights[tx][ty]));
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
