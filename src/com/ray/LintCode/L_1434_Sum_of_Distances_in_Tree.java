package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   An undirected, connected tree with `N` nodes labelled `0...N-1` and `N-1` edges are given.
 *   
 *   The `i`th edge connects nodes `edges[i][0]` and `edges[i][1]` together.
 *   
 *   Return a list ans, where `ans[I]` is the sum of the distances between node `I` and all other nodes.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 *   Output: [8,12,6,10,10,10]
 *   
 *   Explanation: 
 *   Here is a diagram of the given tree:
 *     0
 *    / \
 *   1   2
 *      /|\
 *     3 4 5
 *   We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 *   equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input:
 *   5
 *   [[0,1],[1,2],[2,3],[3,4]]
 *   Output:
 *   [10,7,6,7,10]
 *   
 *   Explanation:
 *                   0
 *                 /
 *               1
 *             /
 *           2
 *         /
 *       3
 *     /
 *   4
 *   answer[0] = 1 + 2 + 3 + 4 = 10
 *   answer[1] = 1 + 1 + 2 + 3 = 7
 *   answer[2] = 1 + 2 + 1 + 2 = 6,and so on.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sum-of-distances-in-tree/description
 * @date   2019-07-03 17:45:36
 */
public class L_1434_Sum_of_Distances_in_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
