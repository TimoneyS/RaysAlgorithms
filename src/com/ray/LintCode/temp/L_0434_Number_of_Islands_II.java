package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.LintCode.util.Point;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
 *      Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
 *      The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid
 *      matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
 *      Output: [1,1,2,2]
 *      Explanation:
 *      0.  00000
 *          00000
 *          00000
 *          00000
 *      1.  00000
 *          01000
 *          00000
 *          00000
 *      2.  01000
 *          01000
 *          00000
 *          00000
 *      3.  01000
 *          01000
 *          00000
 *          00010
 *      4.  01000
 *          01000
 *          00000
 *          00011
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: n = 3, m = 3, A = [[0,0],[0,1],[2,2],[2,1]]
 *      Output: [1,1,2,2]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-islands-ii/description
 * @date   2019-07-11 18:33:06
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
