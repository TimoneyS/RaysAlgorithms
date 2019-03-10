package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 一个房间有 n 盏灯，并且初始状态下都是打开的。墙上有 4 个按钮。
 *
 * 经过对按钮的一共 m 个操作之后，返回可能的灯的明暗状态。
 *
 * n 个灯被标记为 [1,2,3, ..., n]，按钮的功能如下：
 *      1. 开关所有的灯
 *      2. 开关偶数号灯
 *      3. 开关奇数号灯
 *      4. 开关(3k+1)号灯
 * @author rays1
 *
 */
public class L_0704_Bulb_Switcher_II {

    /**
     * 如果让标号从 0 开始，4中开关则是 全部、奇数、偶数、3的倍数。
     * 
     * 观察一下可以发现，如果有 12盏灯，那么 1-6盏灯和 7-12盏灯的明灭一定是一一对应的。
     * 那么无论经过哪些操作对于 1-6盏灯得到的每种状态，对应 7-12 盏灯中的每盏灯的状态都是确定的，那么可以得出：
     *          dp[7 ~ 12] = dp[6]
     * 因此题目只需要考虑 1 ~ 6 的情况即可
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int flipLights(int n, int m) {
            if (n == 0 || m == 0) return 1;
            if (n == 1) return 2;
            if (n == 2) return m == 1 ? 3 : 4;
            if (m == 1) return 4;
            return m == 2 ? 7 : 8;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
