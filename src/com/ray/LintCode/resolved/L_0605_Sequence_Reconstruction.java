package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ray.io.Out;

/**
 * 检查一个原始序列 org 是否能够唯一的从一系列的序列 seqs 中重建。org 序列是一个 1 到 n 之间的整数的一个排列组合，n 的范围是 (1, 10^4)
 * 重建表示在 seqs 中构建序列的最短的父序列 (意思是，一个最短的序列使得所有 seqs 里的序列都是它的子序列).
 * 判断是否有且仅有一个能从 seqs 重构出来的序列，并且这个序列是 org。
 * 
 * 例如：
 *      原始序列 [1, 2, 3], 序列表 [[1, 2], [1, 3]]
 * 
 * @author rays1
 *
 */
public class L_0605_Sequence_Reconstruction {

    /**
     * 原始的序列构成图的一个路径，序列表构成一张具体的图
     * 这张具体的图，拓扑排序的顺序只有一个，且就是原始序列
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean sequenceReconstruction(int[] org, int[][] seqs) {
            Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
            Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
            
            for (int num : org) {
                graph.put(num, new HashSet<Integer>());
                indegree.put(num, 0);
            }

            int n = org.length, count = 0;
            for (int[] seq : seqs) {
                count += seq.length;
                if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) return false;
                for (int i = 1; i < seq.length; i++) {
                    if (seq[i] <= 0 || seq[i] > n) return false;
                    if (graph.get(seq[i - 1]).add(seq[i]))
                        indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }

            // case: [1], []
            if (count < n) return false;
            
            Queue<Integer> q = new ArrayDeque<Integer>();
            for (int key : indegree.keySet()) 
                if (indegree.get(key) == 0)
                    q.add(key);
            
            int cnt = 0;
            while (q.size() == 1) {
                int ele = q.poll();
                for (int next : graph.get(ele)) {
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 0) q.add(next);
                }
                if (ele != org[cnt]) {
                    return false;
                }
                cnt++;
            }
            
            return cnt == org.length;
        }
    
    }
    
    public static void main(String[] args) {
        
        
        int[] org = {1,2,3,4};
        
        int[][] seqs = {
                {1, 2, 3},
                {2, 3, 4},
                {2, 4},
                {3, 4}
        };
        
        Out.p(new Solution().sequenceReconstruction(org, seqs));
        
    }

}
