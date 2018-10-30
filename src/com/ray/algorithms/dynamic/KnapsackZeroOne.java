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

    private int[]     w;
    private int[]     p;
    private int       n;
    private int[]     maxValue;

    public KnapsackZeroOne(int[] w, int[] p, int c) {

        n = w.length;
        this.w = w;
        this.p = p;

        maxValue = new int[n + 1];
        for (int i = 0; i < n; i++) {
            maxValue[i] = -1;
        }
        maxValue[n] = 0;

        int v = maxValue(0, c);

        Out.pt("choose : ");
        for (int i = 0; i < n; i++) {
            if (maxValue[i] != maxValue[i + 1])
                Out.pt(i + " ");
        }
        Out.p();
        Out.p("maxValue = " + v);

    }

    public int maxValue(int i, int c) {
        if (i >= n)
            return 0;
        
        int v1 = (w[i] <= c) ? p[i] + maxValue(i + 1, c - w[i]) : 0;
        int v2 = maxValue(i + 1, c);

        maxValue[i] = Math.max(v1, v2);

        return maxValue[i];
    }

    public static void main(String[] args) {

        int c = 5;
        int[] w = { 1, 2, 3, 4, 5 };
        int[] p = { 2, 2, 3, 4, 5 };

        new KnapsackZeroOne(w, p, c);

    }

}
