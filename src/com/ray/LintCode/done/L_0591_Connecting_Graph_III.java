package com.ray.LintCode.done;

/**
 * 描述：
 *      Given `n` nodes in a graph labeled from `1` to `n`. There is no edges in the graph at beginning.
 *      
 *      You need to support the following method:
 *      1. `connect(a, b)`, an edge to connect node a and node b
 *      2. `query()`, Returns the number of connected component in the graph
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      ConnectingGraph3(5)
 *      query()
 *      connect(1, 2)
 *      query()
 *      connect(2, 4)
 *      query()
 *      connect(1, 4)
 *      query()
 *      
 *      Output:[5,4,3,3]
 *      
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      ConnectingGraph3(6)
 *      query()
 *      query()
 *      query()
 *      query()
 *      query()
 *      
 *      
 *      Output:
 *      [6,6,6,6,6]
 *      
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/connecting-graph-iii/description
 * @date   2019-07-11 18:34:21
 */
public class L_0591_Connecting_Graph_III {

    /**
     * 这个题目的条件很坑爹，首先没有给出完整的 API，需要添加一个参数 n 的构造器
     * 其他的则是标准的 UnionFind算法
     * 
     * @author rays1
     *
     */
    static class ConnectingGraph3 {
        
        private int[] parentOf;
        private int   count;
        
        public ConnectingGraph3(int n) {
            parentOf = new int[n+1];
            for (int i = 0; i < parentOf.length; i++) {
                parentOf[i] = i;
            }
            count = n;
        }
        
        private int find(int i) {
            int t = i;
            while(parentOf[i] != i) {
                i = parentOf[i];
            }
            parentOf[t] = i;
            return i;
        }
        
        public void connect(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra != rb) {
                parentOf[ra] = rb;
                count --;
            }
        }

        public int query() {
            return count;
        }
        
    }

}
