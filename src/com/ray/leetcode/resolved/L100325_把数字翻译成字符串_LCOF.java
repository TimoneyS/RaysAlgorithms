package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * 把数字翻译成字符串 LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @since   2020-03-31 22:21:08
 */
public class L100325_把数字翻译成字符串_LCOF {
    /**
     * 保存前一个数字 prev
     * 保存前一个数字、前两个数字起始能够构成的所有字符串个数 dp1, dp2
     *
     * 如果当前数字是0，或者和前一个数字组合大于25
     *      dp = dp1
     * 否则
     *      dp = dp1 + dp2
     * 需要注意初始情况下，如果前一个数字不存在，那么可以直接置结果为 1
     */
    static class Solution {
        public int translateNum(int num) {
            if (num  == 0) return 1;
            int tag = 0;
            int[] arr = new int[2];
            int prev = -1;
            while (num  > 0) {
                int curr = num % 10;
                num /= 10;
                // （当前数字 + 前一个数字） + 前前一个数字能组成的所有字符串
                if (prev == -1 || curr * 10 + prev > 25 || curr == 0) {
                    arr[tag] = 0;
                } else {
                    arr[tag] = arr[tag] == 0 ? 1 : arr[tag];
                }
                arr[tag] += arr[(tag + 1)&1] == 0 ? 1 : arr[(tag + 1)&1];
                tag ++;
                tag &= 1;
                prev = curr;
            }

            return Math.max(arr[0], arr[1]);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
