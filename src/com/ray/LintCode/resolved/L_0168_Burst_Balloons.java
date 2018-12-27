package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * n个气球，每个气球对应价值 values[i]，每爆炸一个气球，可以得到  values[l] * values[i] * values[r] 的得分
 * l 和 r 是i的邻接气球，爆炸之后 l 和 r 将成为相邻接气球。
 * 
 * 寻找合适的爆炸气球的顺序，以获得最大得分
 *  · 规定 values[-1] = values[n] = 1
 *  · 0 ≤ n ≤ 500, 0 ≤ values[i] ≤ 100
 *  
 * 例如对于气球 [4, 1, 5, 10]，返回 270
 * Return 270
 * nums = [4, 1, 5, 10]  burst 1,  get coins 4 *  1 *  5 = 20
 * nums = [4, 5, 10]     burst 5,  get coins 4 *  5 * 10 = 200 
 * nums = [4, 10]        burst 4,  get coins 1 *  4 * 10 = 40
 * nums = [10]           burst 10, get coins 1 * 10 *  1 = 10
 * Total coins 20 + 200 + 40 + 10 = 270
 * @author rays1
 *
 */
public class L_0168_Burst_Balloons {

    /**
     * 使用动态规划
     * 
     * 假设  k 是最后一个爆破的气球，则分数为 values[k]
     * 
     * 然后需要  寻找 0 - k-1 和 k+1 - n-1 中的最大分数
     * 需要注意的是，当 计算 0 - k-1 时 假设 l 是最后一个爆破的气球，其得分应该是 values[l] * values[k]，因为 k
     *              同理 当 计算 k-1 - n-1 时，假设 m 是最后一个爆破的求，其得分应该是 values[k] * values[m]
     * 因为这两部寻找的假设是 当爆破完这两部分，将只剩下 k，因此爆破两部分气球时，分数必然要乘以 values[k]
     * 
     * 实际算法中，用marked 表示当前未爆破的气球，因此假设一个气球最后爆破时，在marked中寻找其两边是否还有没有未爆破的气球来计算得分。
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        boolean[] marked;
        int[][] mem;
        
        public int maxCoins(int[] values) {
            marked = new boolean[values.length];
            mem = new int[values.length][values.length];
            return helper(values, 0, values.length-1);
        }
        
        public int helper(int[] values, int s, int t) {
            if (s > t) return 0;
            if (mem[s][t] == 0) {
                int max = 0;
                // 假设  k 是最后一个爆炸的气球
                for (int i = s; i <= t; i++) {
                    marked[i] = true;
                    int l = helper(values, s, i-1);
                    int r = helper(values, i+1, t);
                    marked[i] = false;
                    
                    int v = values[i];
                    for (int j = i-1; j >= 0; j--) {
                        if (marked[j]) {
                            v = v * values[j];
                            break;
                        }
                    }
                    
                    for (int j = i+1; j < values.length; j++) {
                        if (marked[j]) {
                            v = v * values[j];
                            break;
                        }
                    }
                    
                    if (l + r + v > max) {
                        max = l + r + v;
                    }
                    
                }
                mem[s][t] = max;
            
            }
            
            return mem[s][t];
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] values = {4, 1, 5, 10};
        Solution sol = new Solution();
        int rs = sol.maxCoins(values);
        Out.p(rs);
    }

}
