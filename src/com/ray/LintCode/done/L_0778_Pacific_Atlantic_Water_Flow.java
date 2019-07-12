package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an `m x n` matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *      
 *      Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *      
 *      Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      matrix = 
 *      [[1,2,2,3,5],
 *      [3,2,3,4,4],
 *      [2,4,5,3,1],
 *      [6,7,1,4,5],
 *      [5,1,1,2,4]]
 *      Output:
 *      [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *      Explanation:
 *      Pacific ~ ~ ~ ~ ~
 *            ~ 1 2 2 3 5 *
 *            ~ 3 2 3 4 4 *
 *            ~ 2 4 5 3 1 *
 *            ~ 6 7 1 4 5 *
 *            ~ 5 1 1 2 4 *
 *              * * * * * Atlantic
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      matrix =
 *      [[1,2],
 *      [4,3]]
 *      Output:
 *      [[0,1],[1,0],[1,1]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/pacific-atlantic-water-flow/description
 * @date   2019-07-11 18:36:37
 */
public class L_0778_Pacific_Atlantic_Water_Flow {


    /**
     * 从起点出发的水的高度是 1，如果一路的高度相同，那么水可以前进。
     * 如果出现地形下降再上升，则水便无法通过。
     * 
     * 那么每一个水，经过的路径是这样的一条路径：
     *      从开始的格子起，每次只能向高度小于等于当前高度的格子流淌，直到到达大海，或者无法前进。
     * 如果把路径的方向调换，从大海向格子前进，那么路径是这样的
     *      从开始的格子起，每次只能向高度大于等于当前高度的格子流淌，直到到到达目标格子。
     *      
     * 那么可以说，沿着这样的规律，从海边的每个格子搜起，那么能够到达的每个格子，都是能够到达海洋的。
     * 所以
     *      沿着大西洋的海边，搜索所有能够到达大西洋的格子 s1
     *      沿着太平洋的海边，搜索所有能够到达太平洋的格子 s2
     * s1 和 s2 的交集就是目标     
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            boolean[][] marked1 = new boolean[n][m], marked2 = new boolean[n][m];
            
            for (int i = 0; i < n; i++) {
                dfs(matrix, marked1, i, 0);
                dfs(matrix, marked2, i, m-1);
            }
            for (int j = 0; j < m; j++) {
                dfs(matrix, marked1, 0, j);
                dfs(matrix, marked2, n-1, j);
            }
            
            List<List<Integer>> rs = new ArrayList<>();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (marked1[i][j] && marked2[i][j])
                        rs.add(Arrays.asList(new Integer[] {i, j}));
            
            return rs;
        }
        
        public void dfs(int[][] matrix, boolean[][] marked, int i, int j) {
            if (marked[i][j]) return;
            marked[i][j] = true;
            if (i > 0                    && !marked[i-1][j] && matrix[i-1][j] >= matrix[i][j]) dfs(matrix, marked, i-1, j);
            if (i < matrix.length-1      && !marked[i+1][j] && matrix[i+1][j] >= matrix[i][j]) dfs(matrix, marked, i+1, j);
            if (j > 0                    && !marked[i][j-1] && matrix[i][j-1] >= matrix[i][j]) dfs(matrix, marked, i, j-1);
            if (j < matrix[0].length-1   && !marked[i][j+1] && matrix[i][j+1] >= matrix[i][j]) dfs(matrix, marked, i, j+1);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
