package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.LintCode.util.Point;
import com.ray.io.Out;

/**
 * 434. Number of Islands II
 *
 * 岛屿数 2
 *
 * 给定数字 n，m 分别表示矩阵的行和列数，给定包含 k 个点的数组
 * 起初矩阵中只包含0，表示只有海洋。数组中存放的点表示所在的位置可以升为岛屿。
 * 
 * 返回每个操作后岛屿的数量
 *
 * @author rays1
 *
 */
public class L_0434_Number_of_Islands_II {
    
    /**
     * 使用union find 实现，不然会 mle
     * @author rays1
     *
     */
    static class Solution {
        
        int[] parent;
        int   count = 0;
        
        public List<Integer> numIslands2(int n, int m, Point[] operators) {
            if (n == 0 || m==0||operators == null) return null;
            
            ArrayList<Integer> rs = new ArrayList<>();
            parent = new int[n*m];
            Arrays.fill(parent, -1);
            
            for (Point p : operators) {
                int idx = p.x*m + p.y;
                if (find(idx) < 0) {
                    parent[idx] = idx;
                    count ++;
                }
                
                // 讨论上下左右的修改
                if (p.x > 0   && parent[idx - m] >= 0) union(idx, idx-m);
                if (p.x < n-1 && parent[idx + m] >= 0) union(idx, idx+m);
                if (p.y > 0   && parent[idx - 1] >= 0) union(idx, idx-1);
                if (p.y < m-1 && parent[idx + 1] >= 0) union(idx, idx+1);
                
                
                Out.p(parent);
                rs.add(count);
            }
            
            return rs;
        }
        
        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = parent[rootQ];
                count -- ;
            }
        }

        int find(int idx) {
            while (idx >=0 && parent[idx] != idx) {
                if (parent[idx] >= 0) parent[idx] = parent[parent[idx]];
                idx = parent[idx];
            } 
            return idx;
        }
        
    }

    public static void main(String[] args) {
        
        int n = 2;
        int m = 2;
        
        Point[] operators = {
                new Point(0,0),
                new Point(1,1),
                new Point(1,0),
                new Point(0,1)
        };
        
        Out.p(new Solution().numIslands2(n, m, operators));
        
    }

}
