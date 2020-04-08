package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 机器人的运动范围  LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @since   2020-04-08 22:06:55
 */
public class L100281_机器人的运动范围__LCOF {
    static class Solution {
        public int movingCount(int m, int n, int k) {
            int[][] DIRS = new int[][] {{ 0, 1}, {-1, 0}, { 0,-1}, { 1, 0}};
            int count = 0;
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] marked = new boolean[m*n];
            q.offer(0);
            marked[0] = true;

            // BFS 搜索每个数字，验证合法的加入队列
            while (!q.isEmpty()) {
                int x = q.peek() / n;
                int y = q.poll() % n;
                for (int[] dir : DIRS) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (valid(m,n,i,j,k) && !marked[i*n+j]) {
                        q.offer(i*n+j);
                        marked[i*n+j] = true;
                    }
                }
                count++;
            }
            return count;
        }

        // 验证数字是否合法
        private boolean valid(int m, int n, int i, int j, int k) {
            if (i < 0 || i >= m || j < 0 || j >= n) return false;
            int sum = 0;
            do {
                sum += i % 10;
            } while ((i /= 10) > 0);
            do {
                sum += j % 10;
            } while ((j /= 10) > 0);
            return sum <= k;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
