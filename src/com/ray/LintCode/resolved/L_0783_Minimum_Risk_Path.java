package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 地图上右 m 个无向的边，每条边 Edge(x, y, w) 表示位置 x 到 y 的权重为 w。
 * 从 0 到 n 有多条路径。定义路径的风险值是路径中所有边的最大值，
 * 求从 0 到 n 的最小风险值
 *
 * @author rays1
 *
 */
public class L_0783_Minimum_Risk_Path {

    /**
     * 使用优先级队列，保存每条边，每次处理最小的边，然后加入联通分量
     * 直到 0 和 n 属于同一个联通分量时，结束算法，并返回联通分量重权重最大的边
     * @author rays1
     *
     */
    static class Solution {
    
        public int getMinRiskValue(int n, int m, int[] x, int[] y, int[] w) {
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> arr1[0] - arr2[0]);
            
            for (int i = 0; i < m; i++) {
                pq.add(new int[] {w[i], i});
            }
            
            int[] riskOf = new int[n+1];
            int[] prevOf = new int[n+1];
            Arrays.fill(prevOf, -1);
            
            while (!pq.isEmpty() && find(prevOf, riskOf, riskOf[0], 0) != find(prevOf, riskOf, riskOf[n], n)) {
                int i = pq.poll()[1];
                int p1 = x[i], p2 = y[i];
                
                if (prevOf[p1] == prevOf[p2]) {
                    if (prevOf[p1] != -1) continue;
                    prevOf[p2] = p1;
                    prevOf[p1] = p1;
                    riskOf[p1] = w[i];
                    riskOf[p2] = w[i];
                } else if (prevOf[p1] == -1) {
                    add(prevOf, riskOf, w[i], p2, p1);
                } else if (prevOf[p2] == -1) {
                    add(prevOf, riskOf, w[i], p1, p2);
                } else {
                    int f1 = find(prevOf, riskOf, w[i], p1);
                    int f2 = find(prevOf, riskOf, w[i], p2);
                    if (riskOf[f1] > riskOf[f2]) {
                        prevOf[f2] = f1;
                        riskOf[f2] = riskOf[f1];
                    } else { 
                        prevOf[f1] = f2;
                        riskOf[f1] = riskOf[f2];
                    }
                }
                
            }
            
            return riskOf[find(prevOf, riskOf, riskOf[n], n)];
        }
        
        private void add(int[] prevOf, int[] riskOf, int w, int p1, int p2) {
            int f = find(prevOf, riskOf, w, p1);
            Out.p("f = " + f);
            prevOf[p2] = f;
            riskOf[p2] = riskOf[f];
        }

        private int find(int[] prevOf, int[] riskOf, int w, int p1) {
            if (prevOf[p1] == -1 || prevOf[p1] == p1) {
                riskOf[p1] = Math.max(riskOf[p1], w);
                return p1;
            }
            int f = find(prevOf, riskOf, w, prevOf[p1]);
            prevOf[p1] = f;
            riskOf[p1] = riskOf[f];
            return f;
        }

    }
    
    public static void main(String[] args) {
        
         // n = 5, m = 7, x = [0, 0, 1, 2, 3, 3, 4], y = [1, 2, 3, 4, 4, 5, 5], w = [2, 5, 3, 4, 3, 4, 1]，返回3。
        int n = 5, m = 7;
        int[] x = {0, 0, 1, 2, 3, 3, 4};
        int[] y = {1, 2, 3, 4, 4, 5, 5};
        int[] w = {2, 5, 3, 4, 3, 4, 1};
        
        Out.p(new Solution().getMinRiskValue(n, m, x, y, w));
        
    }

}
