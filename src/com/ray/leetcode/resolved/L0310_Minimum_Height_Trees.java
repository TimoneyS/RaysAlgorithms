package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Minimum Height Trees
 * -----------------------------------------------------------------------------
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * Example 1 :
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *         0
 *         |
 *         1
 *        / \
 *       2   3 
 * Output: [1]
 * Example 2 :
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5 
 * Output: [3, 4]
 * Note:
 * 	According to the definition of tree on Wikipedia: &ldquo;a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.&rdquo;
 * 	The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/minimum-height-trees/
 * @since   2020-03-11 19:19:25
 */
public class L0310_Minimum_Height_Trees {
    /**
     * 从所有的叶子结点开始搜索，搜索到剩下的最后一批，则他们都是最短根结点
     * 一些细节：
     *      1. 一个结点的所有子结点都是被搜索过，即这个结点的入度只有1才加入搜索队列
     *      2. 搜索时统计结点的权重，权重就是加入队列的批次
     *      3. 如果搜索时遇到了权重相等的结点，那么对方和自己一定都是最短树的根节点，而且对方也一定会被加入队列搜索
     *          因此只要将对方加入结果，等对方搜索时也会将自己加入结果
     *      4. 如果一个队列中的结点入度为 0 ，那么说明这是最后一个结点，如果没有与其权重相等的结点，那么其就是最终的唯一解
     */
    static class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer>[] G = new List[n];
            List<Integer> rs = new ArrayList<>();
            // build graph
            for (int i = 0; i < n; i ++) {
                G[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                G[edge[0]].add(edge[1]);
                G[edge[1]].add(edge[0]);
            }
            // prepare
            int[] W   = new int[n];
            int[] adj = new int[n];
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i ++) {
                adj[i] = G[i].size();
                if (G[i].size() == 1) {
                    queue.add(i);
                    W[i] = 1;
                } else if (G[i].size() == 0) {
                    rs.add(i);
                }
            }
            // search
            while (!queue.isEmpty()) {
                int v = queue.poll();
                if (adj[v] == 0) {
                    rs.add(v);
                    continue;
                }
                for (int w : G[v]) {
                    adj[w] --;
                    if (adj[w] > 1)
                        continue;
                    if (W[w] == 0) {
                        W[w] = W[v] + 1;
                        queue.offer(w);
                    } else if (W[w] == W[v]) {
                        adj[w] ++;
                        rs.add(w);
                    }
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
