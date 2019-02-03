package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 抢劫那条街上的那些房子之后，小偷寻找了新的盗窃场所，以免引起太多关注。
 * 这一次，这个地方的所有房屋都排成一个圆圈，这意味着第一栋房屋是最后一栋房屋的邻居。
 * 与此同时，这些房屋的保安系统与前一条街道的保安系统保持一致。
 * 给出一个代表每个房子的金额的非负整数列表，确定今晚可以抢劫的最大金额而不警告警察。
 *
 * @author rays1
 *
 */
public class L_0534_House_Robber_II {

    /**
     * 抢劫 
     * 0  - n-2
     * 1  - n-1
     * 选择最大值
     * 
     * @author rays1
     *
     */
    static class Solution {
        public int houseRobber2(int[] nums) {
            if (nums.length == 1) return nums[0];
            return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }
        
        public int rob(int[] nums, int start, int end) {
            int s = 0, w = 0, pres = 0;
            for (int i = start; i <= end; i++) {
                pres = s;
                s = w + nums[i];
                w = Math.max(w, pres);
            }
            return Math.max(s, w);
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,3,2,1,5};
        
        Out.p(new Solution().houseRobber2(nums));
    }

}
