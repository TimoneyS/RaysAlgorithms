package com.ray.algorithms.dynamic;

import com.ray.io.Out;

/**
 * 0/1 背包问题
 * <p>
 * 重量 wi 的 物品，价值为 pi。背包的大小为 m ， 求背包可装载的物品的最大价值。
 * 
 * @author rays1
 *
 */
public class KnapsackZeroOne {

    public KnapsackZeroOne(int[] w, int[] p, int c) {
        int rs = helper(0, c, w, p);
        Out.p(rs);
    }

    /**
     * 动态规划选择
     * @param i 物品id
     * @param c 背包可用容量
     * @return
     */
    public int helper(int i, int c, int[] w, int[] p) {
        if (i >= w.length) return 0;
        
        int v1 = (w[i] <= c) ? p[i] + helper(i + 1, c - w[i], w, p) : 0; // 选择当前物品
        int v2 = helper(i + 1, c, w, p);                                 // 不选择当前物品

        return Math.max(v1, v2);
    }
    
    public static void main(String[] args) {

        int c = 11;
        int[] w = { 1, 6, 11, 5 };
        int[] p = { 1, 6, 11, 5 };

        new KnapsackZeroOne(w, p, c);

    }

}
