package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Count the number of distinct islands. An island is considered to be the same as another if they have the same shape, 
 * or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down direction).
 *
 *
 * @author rays1
 *
 */
public class L_0804_Number_of_Distinct_Islands_II {

    /**
     * 对每个点开始搜索，搜索到的所有格子，记录其上下左右旋转和翻转后的 8 个形状
     * 
     * 这个题目的难点主要在于如何判断两个形状相同
     * 
     * 本方法是采用记录每个形状的格子的坐标（相对坐标），和上下左右翻转后的8个坐标。对坐标取hash，并记录这些hash的最小值。
     * 如果另一个形状和这个形状相同，那么得到的最小hash和之前的形状一定相同。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        class Shape {
            
            int hashCode = Integer.MAX_VALUE;
            int n ,m;
            
            public Shape(List<int[]> list) {
                
                int[] edge = {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0};   // 0 最上，1最下，2最左，3最右
                for (int[] pos : list) {
                    if (pos[0] < edge[0]) { edge[0] = pos[0]; }
                    if (pos[0] > edge[1]) { edge[1] = pos[0]; }
                    if (pos[1] < edge[2]) { edge[2] = pos[1]; }
                    if (pos[1] > edge[3]) { edge[3] = pos[1]; }
                }
                n = edge[1] - edge[0] + 1;
                m = edge[3] - edge[2] + 1;
                
                int[][] arr = new int[8][m*n];
                int cursor = 0;
                for (int[] pos : list) {
                    int i = pos[0] - edge[0];
                    int j = pos[1] - edge[2];
                    int ii = n-i-1;
                    int jj = m-j-1;
                    
                    arr[0][cursor] = i*m+j+1;
                    arr[1][cursor] = ii*m+jj+1;
                    arr[2][cursor] = j*n+ii+1;
                    arr[3][cursor] = jj*n+i+1;
                    
                    arr[4][cursor] = i*m+jj+1;
                    arr[5][cursor] = j*n+i+1;
                    arr[6][cursor] = ii*m+j+1;
                    arr[7][cursor] = jj*n+ii+1;
                    
                    cursor ++;
                }
                for (int[] row : arr) {
                    Arrays.sort(row);
                    hashCode = Math.min(hashCode, Arrays.toString(row).hashCode());
                }
            }
            
            
            @Override
            public boolean equals(Object obj) {
                return obj.hashCode() == hashCode;
            }
            
            @Override
            public int hashCode() {
                return hashCode;
            }
            
        }
        
        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        
        public int numDistinctIslands2(int[][] grid) {
            int n = grid == null ? 0 : grid.length, m = n == 0 ? 0 : grid[0].length;
            if (m*n == 0) return 0;
            
            boolean[][] marked = new boolean[n][m];
            
            Set<Shape> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (marked[i][j] || grid[i][j] != 1) continue;
                    List<int[]> list = new ArrayList<>();
                    dfs(grid, marked, i, j, list);
                    if (list.size() > 0) {
                        Shape s = new Shape(list);
                        set.add(s);
                    }
                }
            }
            
            return set.size();
        }

        private void dfs(int[][] grid, boolean[][] marked, int i, int j, List<int[]> list) {
            list.add(new int[] {i, j});
            marked[i][j] = true;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                
                if (x < 0 || x >= grid.length ||
                    y < 0 || y >= grid[0].length) continue;
                if (marked[x][y] || grid[x][y] != 1) continue;
                dfs(grid, marked, x, y, list);
            }
        }
    
    }
    
    public static void main(String[] args) {

        List<int[]> l1 = Arrays.asList(new int[][] {
            {0,0}, {1,0},
        });
        
        List<int[]> l2 = Arrays.asList(new int[][] {
            {8,8}, {8, 9}
        });
        
        Out.p(new Solution().new Shape(l1).equals(new Solution().new Shape(l2)));
        
        int[][] grid =
            {
                {0,0,0,0,1,0,1,1,0,0,1,0,1,1,0,1,1,1,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,1,1,1,1,1,1,0,1,1},
                {0,1,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,1,1,1,0,0,1,0,1,0,0,1,0,0,0,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1},
                {1,0,0,0,0,0,0,1,1,1,1,0,1,1,0,0,0,0,1,0,0,1,0,0,1,1,1,0,0,0,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,0,1,1,1,1},
                {0,0,0,0,1,1,1,0,1,1,0,1,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,1,1,0,0,1,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1},
                {0,0,0,0,1,1,1,1,0,1,1,0,0,1,1,1,0,1,1,1,0,1,1,0,0,0,1,0,1,1,1,1,1,0,1,1,0,1,1,0,1,0,0,0,0,0,1,0,0,1},
                {0,0,1,1,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,0,0,0,0,0,1,0,1},
                {0,1,0,1,0,0,1,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,0,0,0,0,1,1,0,1,1,0},
                {0,1,0,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,1,0,1,0,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,0,1,0},
                {0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,1,0,0}
        };
        Out.p(new Solution().numDistinctIslands2(grid));
        
    }

}
