package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` balloons, indexed from `0` to `n-1`. Each balloon is painted with a number on it represented by array `nums`. You are asked to burst all the balloons. If the you burst balloon `i` you will get `nums[left] * nums[i] * nums[right]` coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *      
 *      Find the `maximum` coins you can collect by bursting the balloons wisely.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[4, 1, 5, 10]
 *      Output：270
 *      Explanation：
 *      nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
 *      nums = [4, 5, 10]   burst 5, get coins 4 * 5 * 10 = 200 
 *      nums = [4, 10]    burst 4, get coins 1 * 4 * 10 = 40
 *      nums = [10]    burst 10, get coins 1 * 10 * 1 = 10
 *      Total coins 20 + 200 + 40 + 10 = 270
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：[3,1,5]
 *      Output：35
 *      Explanation：
 *      nums = [3, 1, 5] burst 1, get coins 3 * 1 * 5 = 15
 *      nums = [3, 5] burst 3, get coins 1 * 3 * 5 = 15
 *      nums = [5] burst 5, get coins 1 * 5 * 1 = 5
 *      Total coins 15 + 15 + 5  = 35
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/burst-balloons/description
 * @date   2019-07-11 18:31:29
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
