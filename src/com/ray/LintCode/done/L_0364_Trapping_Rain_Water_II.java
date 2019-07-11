package com.ray.LintCode.done;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      Given *n* x *m* non-negative integers representing an elevation map 2d where the area of each cell is *1* x *1*, compute how much water it is able to trap after raining.
 *      
 *      ![](https://lintcode-media.s3.amazonaws.com/problem/trapping-rain-water-ii.jpg "")
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Given `5*4` matrix 
 *      Input:
 *      [[12,13,0,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]
 *      Output:
 *      14
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      [[2,2,2,2],[2,2,3,4],[3,3,3,1],[2,3,4,5]]
 *      Output:
 *      0
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/trapping-rain-water-ii/description
 * @date   2019-07-11 18:32:10
 */
public class L_0364_Trapping_Rain_Water_II {

    /**
     * 从边缘开始，每次寻找最矮的边界，维护一个当前最矮边界高度
     * 如果某个点小于这个高度，说明这个点可以储水。
     * @author rays1
     *
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
        
        class NodeComparator implements Comparator<Node> {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.height, o2.height);
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
            PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());
            
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
        
        int[][] heights =  {
                {12, 13,  0, 12},
                {13,  4, 13, 12},
                {13,  8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}
            };
        
        Out.p(new Solution().trapRainWater(heights));
    }
}
