package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 给定一个 mxn 的二维矩阵，一开始矩阵中有一下三个可能的值。
 *      -1  - 墙或者障碍物
 *      0   - 大门
 *      INF - 空地 2147483647
 * 在代表每个空房间的网格中填入到距离最近门的距离。如果不可能到达门口，则应填入 INF。
 * 这里距离不计算斜角距离，
 * @author rays1
 *
 */
public class L_0663_Walls_and_Gates {

    /**
     * 从所有大门开始向外搜索
     *      如果某个空地没有距离或从该大门更近则将空地加入搜索队列
     * @author rays1
     *
     */
    static class Solution {
    
        public void wallsAndGates(int[][] rooms) {
            
            Queue<Integer> queue = new ArrayDeque<>();
            int m = rooms.length, n = rooms[0].length;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (rooms[i][j] == 0)
                        queue.add(i*n + j);
            
            while (!queue.isEmpty()) {
                
                int i = queue.peek()/n, j = queue.poll() % n;
              
                if (i > 0)   deal(i, j, i-1, j, m, n, rooms, queue); 
                if (i < m-1) deal(i, j, i+1, j, m, n, rooms, queue);
                if (j > 0)   deal(i, j, i, j-1, m, n, rooms, queue);
                if (j < n-1) deal(i, j, i, j+1, m, n, rooms, queue);
            }
            
        }

        private void deal(int i1, int j1, int i2, int j2, int m, int n, int[][] rooms, Queue<Integer> queue) {
            if (rooms[i2][j2] <= rooms[i1][j1]) return;
            rooms[i2][j2] = rooms[i1][j1] + 1;
            queue.offer(n*i2 + j2);
        }
    
    }
    
    public static void main(String[] args) {
        
        int INF = 2147483647;
        
        int[][] rooms = {
                { INF,  -1,  0 , INF },
                { INF, INF, INF,  -1 },
                { INF,  -1, INF,  -1 },
                {   0,  -1, INF, INF }
        };
        
        new Solution().wallsAndGates(rooms);
        Out.p(rooms, "%2s ");
        
    }

}
