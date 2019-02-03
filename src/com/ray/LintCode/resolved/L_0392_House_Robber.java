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
     * 用 S[i] 表示从 0 - i 并且抢劫了房屋 i 能得到的最大收获。A[i] 表示房屋的储蓄
     * 
     * 对于选择抢劫第 i 栋房屋的情况，i-1 房屋固定不能被抢劫，而抢劫 i-2 和 i-3 栋房屋不能同时发生
     *      可以抢劫第 i-2 栋房屋 S[i] = S[i-2] + A[i]
     *      可以抢劫第 i-3 栋房屋 S[i] = S[i-3] + A[i]
     *      抢劫 i-4 栋房屋和抢劫 i-2 栋房屋可以同时发生，因此不需要讨论。
     * 因此
     *      S[i] = max { S[i-2], S[i-3] } + A[i]
     * -------------------------------------------------------------------------------------
     * 进一步考虑
     * 如果知道抢劫第 i-1 栋房屋的最大收获为 S[i-1]，假设用i替换i-1房屋，那么最大收获就是
     *      S[i] = S[i-1] - A[i-1] + A[i]
     * 替换了之后 i-1(替换后的i) 和 i-2 又不能同时发生，因此也要考虑未替换前的情况
     *      S[i] = S[i-2] + A[i]
     * 
     * 因此
     *      S[i] = max {S[i-1] - A[i-1], S[i-2]} + A[i]
     * 
     * 这样只需要保存前两次的结果即可。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public long houseRobber(int[] A) {
            long[] mem = new long[2];
            int cur = 1, pre = 0;
            
            if(A.length > 0) mem[0] = A[0];
            for (int i = 1; i < A.length; i++) {
                pre = (cur + 1) % 2;
                mem[cur] = Math.max(mem[cur], mem[pre]- i > 0 ? 0 : A[i-1]) + A[i];
                cur = pre;
            }
            
            return Math.max(mem[0], mem[1]);
        }
        
    }
    
    /**
     * 用 
     *      S[i] 表示到房屋 i 为止，抢劫 i 的最大收获
     *      W[i] 表示到房屋 i 为止，不抢劫 i 的最大收获
     * 则
     *      S[i] = W[i-1] + A[i]
     *      W[i] = max { S[i-1], W[i-1] }
     */
    class Solution1 {
        
        public long houseRobber(int[] A) {
            long s = 0, w = 0, pres = 0;
            for (int i = 0; i < A.length; i++) {
                pres = s;
                s = w + A[i];
                w = Math.max(w, pres);
            }
            return Math.max(s, w);
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {3,2,1,5};
        
        Out.p(new Solution().houseRobber(A));
        
    }

}
