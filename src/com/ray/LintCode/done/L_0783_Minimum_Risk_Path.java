package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      There are m undirected edges on the map, Each edge (x, y, w) represents the weight of position `x` to position `y` is `w`. There may be multiple paths from position `0` to position `n`. We define the risk value of a path as the maximum weight of all the edges in this path.
 *      What is the smallest risk value in all paths from position `0` to position `n`?
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Give n = `2`, m = `2`, x = `[0, 1]`, y = `[1, 2]`, w = `[1, 2]`, return `2`.
 *      Input:
 *      2
 *      2
 *      [0,1]
 *      [1,2]
 *      [1,2]
 *      Output:
 *      2
 *      
 *      Explanation:
 *      Path1: 0→1→ 2 (risk value: 2)
 *      The minimum risk value is 2.
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Give n = `3`, m = `4`, x = `[0, 0, 1, 2]`, y = `[1, 2, 3, 3]`, w = `[1, 2, 3, 4]`, return `3`.
 *      Input:
 *      3
 *      4
 *      [0,0,1,2]
 *      [1,2,3,3]
 *      [1,2,3,4]
 *      Output:
 *      3
 *      
 *      Explanation:
 *      Path1: 0→1→ 3 (risk value: 3)
 *      Path2: 0→2→ 3 (risk value: 4)
 *      The minimum risk value is 3.
 *      ```
 *      
 *      **Example 3:**
 *      ```
 *      Give n = `4`, m = `5`, x = `[0, 1, 1, 2, 3]`, y = `[1, 2, 3, 4, 4]`, w = `[3, 2, 4, 2, 1]`, return `3`.
 *      Input:
 *      4
 *      5
 *      [0,1,1,2,3]
 *      [1,2,3,4,4]
 *      [3,2,4,2,1]
 *      Output:
 *      3
 *      
 *      Explanation:
 *      Path1: 0→1→ 2 → 4 (risk value: 3)
 *      Path2: 0→1→ 3 → 4 (risk value: 4)
 *      The minimum risk value is 3.
 *      ```
 *      
 *      **Example 4:**
 *      ```
 *      Give n = `5`, m = `7`, x = `[0, 0, 1, 2, 3, 3, 4]`, y = `[1, 2, 3, 4, 4, 5, 5]`, w = `[2, 5, 3, 4, 3, 4, 1]`, return `3`.
 *      Input:
 *      5
 *      7
 *      [0,0,1,2,3,3,4]
 *      [1,2,3,4,4,5,5]
 *      [2,5,3,4,3,4,1]
 *      Output:
 *      3
 *      
 *      Explanation:
 *      Path1: 0→1→ 3 → 5 (risk value: 4)
 *      Path2: 0→1→ 3 → 4 → 5 (risk value: 3)
 *      Path3: 0→2→ 4 → 3 → 5 (risk value: 5)
 *      Path4: 0→2→ 4 → 5 (risk value: 5)
 *      The minimum risk value is 3.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-risk-path/description
 * @date   2019-07-11 18:36:40
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
        
        Out.p(new Solution());
        
    }

}
