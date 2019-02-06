package com.ray.LintCode.resolved;

/**
 * 给定 n 个图中的结点，结点标识从 1 到 n，初始状态图中没有边。
 * 编写代码支撑如下操作： 
 *      1. connect(a, b)
 *          添加一条连接 a 和 b 的边
 *      2. query()
 *          返回图中区域的个数
 *
 * @author rays1
 *
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
