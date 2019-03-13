package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;

/**
 * 有一个有 N 个结点的无向树标记为 1 到 N， 每个结点有一个int类型的值，不同的结点值可以相同。
 * 给定一个长度为 N 的数组 A，A[i] 表示结点 i-1 的值，再给一个长度为 2(N-1) 的数组，数组中每两个元素i,j表示i j之间有一条边。
 * 
 * 返回具有相同值的结点构成的最长路径的长度，路径长度为路径上边的数量。
 * 
 * 示例
 *    输入: A = [1, 1, 1 ,2, 2] 和 E = [1, 2, 1, 3, 2, 4, 2, 5]
 *    输出: 2
 *    输入描述的树如下:
 *                      1(1)
 *                     /   \
 *                  2(1)    3(1)
 *                   /  \
 *                4(2)  5(2)
 *     
 *    最长路径为 2 -> 1 -> 3 (所有节点的值均为1)。这条路径的边的数量为 2
 * 
 * 
 * @author rays1
 * @url    https://www.lintcode.com/problem/tree-longest-path-with-same-value/description
 *
 */
public class L_0717_Tree_Longest_Path_With_Same_Value {

    /**
     * 用dfs搜索每个路径开始的长度，选取最长路径
     * 
     * 所有的路径的起点一定是 外延结点值有一个值相同的结点，所以在搜索时可以忽略那些有超过两个相同值的邻接点的点
     * 
     * 特殊情况下可能是平方级别的复杂度。
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int LongestPathWithSameValue(int[] A, int[] E) {
            
            Map<Integer, Set<Integer>> G = new HashMap<>();
            for (int i = 0; i < A.length; i++)
                G.put(i+1, new HashSet<>());
                
            for (int i = 0; i < E.length; i += 2) {
                G.get(E[i]).add(E[i+1]);
                G.get(E[i+1]).add(E[i]);
            }
            
            int rs = 0;
            for (int i = 1; i <= A.length; i++) {
                int c = 0;
                for (int j : G.get(i)) {
                    if (A[j-1] == A[i-1])
                        c ++;
                }
                if (c == 0) {
                    rs = Math.max(rs, 1);
                } else if (c == 1) {
                    rs = Math.max(rs, dfs(G, A, -1, i, 0));
                }
            }
            
            return rs;
        }
        
        int dfs(Map<Integer, Set<Integer>> G, int[] A, int prev, int v, int base) {
            int n = base;
            for (int w : G.get(v)) {
                if (prev != w && A[w-1] == A[v-1]) {
                    n = Math.max(n, dfs(G, A, v, w, base+1));
                }
            }
            
            return n;
        }
    }
    
    public static void main(String[] args) {
        
        int[] A = {1, 1, 1 ,1, 2};
        int[] E = {1, 2, 1, 3, 2, 4, 2, 5};
        
        Out.p(new Solution().LongestPathWithSameValue(A, E));
        
    }

}
