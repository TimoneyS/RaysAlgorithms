package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island has the same shape as another island (and not rotated or reflected).
 *
 * @author rays1
 *
 */
public class L_0860_Number_of_Distinct_Islands {

    static class Solution {
    
        class Shape {
            int hashCode = Integer.MAX_VALUE;
            int n ,m;
            
            public Shape(List<int[]> list) {
                list.sort((a, b) -> {return a[0] == b[0] ? a[1] - b[1] : a[0]-b[0];});
                
                int[] edge = {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0};   // 0 最上，1最下，2最左，3最右
                for (int[] pos : list) {
                    if (pos[0] < edge[0]) { edge[0] = pos[0]; }
                    if (pos[0] > edge[1]) { edge[1] = pos[0]; }
                    if (pos[1] < edge[2]) { edge[2] = pos[1]; }
                    if (pos[1] > edge[3]) { edge[3] = pos[1]; }
                }
                n = edge[1] - edge[0] + 1;
                m = edge[3] - edge[2] + 1;
                
                StringBuilder sb = new StringBuilder();
                for (int[] pos : list) {
                    int i = pos[0] - edge[0];
                    int j = pos[1] - edge[2];
                    sb.append(i*m+j+1);
                }
                hashCode = sb.toString().hashCode();
            }
            
            @Override
            public boolean equals(Object obj) {
                Shape s = (Shape)obj;
                
                if (s.n != n || s.m != m) return false;
                
                return hashCode == obj.hashCode();
            }
            
            @Override
            public int hashCode() {
                return hashCode;
            }
            
        }
        
        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        public int numberofDistinctIslands(int[][] grid) {
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
        
        Out.p(new Solution());
        
    }

}
