package com.ray.LintCode;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values `0` or `1`, where each `1` marks the home of someone in the group. The distance is calculated using [Manhattan Distance](https://en.wikipedia.org/wiki/Taxicab_geometry "manhattan distance"), where `distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *      Output:
 *      6
 *      
 *      Explanation:
 *      The point `(0,2)` is an ideal meeting point, as the total travel distance of `2 + 2 + 2 = 6` is minimal. So return `6`.
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      [[1,1,0,0,1],[1,0,1,0,0],[0,0,1,0,1]]
 *      Output:
 *      14
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/best-meeting-point/description
 * @date   2019-07-11 18:38:34
 */
public class L_0912_Best_Meeting_Point {

    /**
     * 需要观察规律，因为距离是曼哈顿距离
     * 所以结果是所有这个点到所有点的距离之和是到所有点的水平距离+所有点的垂直距离之和。
     * 
     * 水平距离和垂直距离的计算都可以作为一维的情况来讨论。
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int minTotalDistance(int[][] grid) {
            
            int m = grid == null ? 0 :    grid.length;
            int n =    m == 0    ? 0 : grid[0].length;
            
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        list.add(new int[] {i, j});
                    }
                }
            }
            
            int rs = 0;
            
            list.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));
            int l = 0, r = list.size() - 1;
            while (l < r) {
                rs += list.get(r--)[0] - list.get(l++)[0];
            }
            
            list.sort((o1, o2) -> Integer.compare(o1[1], o2[1]));
            l = 0;
            r = list.size() - 1;
            while (l < r) {
                rs += list.get(r--)[1] - list.get(l++)[1];
            }
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
