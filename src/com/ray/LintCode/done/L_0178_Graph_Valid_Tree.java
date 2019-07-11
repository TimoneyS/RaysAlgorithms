package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` nodes labeled from `0` to `n - 1` and a list of `undirected` edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
 *      Output: true.
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
 *      Output: false.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/graph-valid-tree/description
 * @date   2019-07-11 18:31:38
 */
public class L_0178_Graph_Valid_Tree {

    static class Solution {
        /**
         * @param n: An integer
         * @param edges: a list of undirected edges
         * @return: true if it's a valid tree, or false
         */
        public boolean validTree(int n, int[][] edges) {
            
            int[] group = new int[n];
            
            if (n == 1) return true;
            if (edges.length == 0) {
                return false;
            }
            
            int id = 1;
            for (int[] edge : edges) {
                int s = edge[0], t = edge[1];
                
                if (group[s] == group[t]) {
                    if (group[s] != 0) {
                        return false;
                    } else {
                        group[s] = id;
                        group[t] = id;
                        id ++;
                    }
                } else if (group[s] == 0) {
                    group[s] =  group[t];
                } else if (group[t] == 0) {
                    group[t] =  group[s];
                } else {
                    int ids = group[s];
                    for (int i = 0; i < group.length; i++) {
                        if (group[i] == ids) {
                            group[i] = group[t];
                        }
                    }
                }
                
            }
            
            int i = 0;
            for (int g : group) {
                if (g == 0) return false;
                if (i==0) i = g;
                else if (i!=g) return false;
            }
            
            return true;
        }
    }
    
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {2, 3},
                {0, 2},
                {1, 4}
        };
        int n = 5;
        
        Out.p(new Solution().validTree(n, edges));;
        
    }

}
