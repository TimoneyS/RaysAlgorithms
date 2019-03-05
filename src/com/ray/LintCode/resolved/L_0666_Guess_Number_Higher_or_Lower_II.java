package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 猜数字的游戏之二，如下：
 *      A 选择一个 1 到 n 之间的数字，B 需要猜出 A 选择的数字
 *      每次B猜的不对，则A告诉B选中的数字是更大还是更小。
 *      如果猜错了，需要付给 A x元。
 * 计算需要准备多少钱来保证赢得游戏。
 * @author rays1
 *
 */
public class L_0666_Guess_Number_Higher_or_Lower_II {

    /**
     * 设 p(l, r, i) 表示猜测位于 l r 之间的数字，且第一次猜测的数字为 i，需要准备的钱数
     * 
     * 对于第一次猜测任意一个 数字 i，之后需要猜测的数字可能位于 i 左边，也可能位于 i 右边
     *      pl = p(l, i-1)
     *      pr = p(i+1, r)
     * 因为两种可能都存在，所以基于最坏的情况去考虑，
     *      p(l, r, i) = Max(p(l, i-1), p(i+1, r)) + i
     * 
     * 第一次猜测的数字不同，导致的结果也可能不同，这时候要选择一个能够使得需要准备钱数最少的方案
     * 
     * 因此
     *      rs = Min { p(l, r, i) } = Min { Max(p(l, i-1), p(i+1, r)) + i }
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        int[][] inner;
        
        public int getMoneyAmount(int n) {
            inner = new int[n+1][n+1];
            return p(1, n);
        }
        
        int p(int start, int end) {
            if (inner[start][end] == 0) {
                if (start == end) inner[start][end] = 0;
                else if (end - start == 1) inner[start][end] = Math.min(start, end);
                else {
                    int sum = Integer.MAX_VALUE;
                    for (int i = start + 1; i < end; i++) {
                        int t = Math.max(p(start, i - 1), p(i + 1, end)) + i;
                        if (t < sum )
                            sum = t;
                    }
                    inner[start][end] = sum;
                }
            }
            return inner[start][end];
        }
    
    }
    
    public static void main(String[] args) {
        
        
        // 1 2 3 4 5;
        
        int n = 129;
        
        Out.p(new Solution().getMoneyAmount(n));
        
    }

}
