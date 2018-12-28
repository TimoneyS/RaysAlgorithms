package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 *  write a function to check whether these edges make up a valid tree.
 *
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * @author rays1
 *
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
