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
    private int[]     maxValue;

    public KnapsackZeroOne(int[] w, int[] p, int c) {

        this.w = w;
        this.p = p;
        
        maxValue = new int[w.length+1];
        dynamic(0, c);
        
        show();
    }

    /**
     * 动态规划选择
     * @param i 物品id
     * @param c 背包可用容量
     * @return
     */
    public int dynamic(int i, int c) {
        if (i >= w.length) return 0;
        
        int v1 = (w[i] <= c) ? p[i] + dynamic(i + 1, c - w[i]) : 0; // 选择当前物品
        int v2 = dynamic(i + 1, c);                                 // 不选择当前物品

        maxValue[i] = Math.max(v1, v2);

        return maxValue[i];
    }
    
    public void show() {
        Out.pt("choose : ");
        for (int i = 0; i < w.length; i++) {
            if (maxValue[i] != maxValue[i + 1])
                Out.pt(i + " ");
        }
        Out.p("\nmaxValue = " + maxValue[w.length-1]);
    }

    public static void main(String[] args) {

        int c = 5;
        int[] w = { 1, 2, 3, 4, 5 };
        int[] p = { 2, 2, 3, 4, 5 };

        new KnapsackZeroOne(w, p, c);

    }

}
