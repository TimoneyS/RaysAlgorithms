package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      We consider an undirected tree with `N` nodes, numbered from 1 to `N`, Additionally, each node also has a label attached to it and the label is an integer value. Note that different nodes can have identical labels. You need to write a function , that , given a zero-indexed array A of length N, where A[J] is the label value of the `(J + 1)-th` node in the tree, and a zero-indexed array E of length `K = (N - 1) * 2` in which the edges  of the tree are described (for every `0 <= j <= N -2`  values `E[2 * J]` and `E[2 * J + 1]` represents and edge connecting node `E[2 * J]` with node `E[2 * J + 1])`， returns the length of the longest path such that all the nodes on that path have the same label. Then length of a path if defined as the number of edges in that path.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: A = [1, 1, 1 ,2, 2] and E = [1, 2, 1, 3, 2, 4, 2, 5]
 *      Output: 2
 *      Explanation: 
 *      described tree appears as follows:
 *      ​```
 *                         1 （value = 1）
 *                       /   \
 *          (value = 1) 2     3 (value = 1)
 *                     /  \
 *       (value = 2)  4     5 (value = 2)
 *      ​```
 *      The longest path (in which all nodes have the save value of 1) is (2 -> 1 -> 3). The number of edges on this path is 2, thus, that is the answer.
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: A = [1, 2, 1 ,2, 2] and E = [1, 2, 1, 3, 2, 4, 2, 5]
 *      Output: 2
 *      Explanation: 
 *      described tree appears as follows:
 *      ​```
 *                         1 （value = 1）
 *                       /   \
 *          (value = 2) 2     3 (value = 1)
 *                     /  \
 *       (value = 2)  4     5 (value = 2)
 *      ​```
 *      The longest path (in which all nodes have the save value of 2) is (4 -> 2 -> 5). The number of edges on this path is 2, thus, that is the answer.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/tree-longest-path-with-same-value/description
 * @date   2019-07-11 18:35:44
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
        
        Out.p(new Solution());
        
    }

}
