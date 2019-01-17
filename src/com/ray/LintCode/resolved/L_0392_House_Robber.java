package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 你是一个专业的强盗，计划在街上抢劫房屋。
 * 每个房子都有一定数量的钱存在，阻止你抢劫他们的唯一限制是相邻的房屋有连接的安全系统
 * 如果两个相邻的房子在同一个晚上被打破，它将自动联系警察。
 * 
 * 给出一个代表每个房子的金额的非负整数列表，确定今晚可以抢劫的最大金额而不警告警察。
 * 如给出 [3, 8, 4] 返回 8
 * @author rays1
 *
 */
public class L_0392_House_Robber {

    /**
     * 每次处理房屋 k 时，之前的访问记录了三个数字
     * 抢劫了 k - 1 的最大收获
     * 抢劫了 k - 2 的最大收获
     * 抢劫了 k - 3 的最大收获
     * 
     * 抢劫 k-1 的数据供下一个房屋使用，当前房屋的最大收获为
     * max( mk-2, mk-3 ) + a[k]
     * 
     * 因为抢劫 房屋k时，抢劫 k-2 k 或者 k-3 k 两种选择（k-4 的情况 和 k-2 的情况可以同时发生，再之前的房屋同理）
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public long houseRobber(int[] A) {
            long[] mem = new long[3];
            int i = 0;
            for (int a : A) {
                int j = (i + 1) % 3;
                mem[i] = Math.max(mem[i], mem[j]) + a;
                i = j;
            }
            return Math.max(mem[0],Math.max(mem[1], mem[2]));
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {3, 8, 4};
        
        Out.p(new Solution().houseRobber(A));
        
    }

}
