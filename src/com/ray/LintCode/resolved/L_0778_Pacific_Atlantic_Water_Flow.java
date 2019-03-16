package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个非负整数组成的 mxn 的矩阵，表示一个地形中每个单元格的高度。太平洋和地形的左上的边接触，大西洋和右下的边接触。
 * 水只能从一个格子沿着上、下、左、右的方向像另一个低一点的格子流动。
 * 
 * 寻找水可以同时流向大西洋和太平的格子坐标。
 * 
 * 例如
 *      [1,2,2,3,5],
 *      [3,2,3,4,4],
 *      [2,4,5,3,1],
 *      [6,7,1,4,5],
 *      [5,1,1,2,4]
 *      
 * @author rays1
 *
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
        
        int[][] matrix = {
                {1,2},
                {4,3}
        };
        
        Out.p(new Solution().pacificAtlantic(matrix));
        
    }

}
