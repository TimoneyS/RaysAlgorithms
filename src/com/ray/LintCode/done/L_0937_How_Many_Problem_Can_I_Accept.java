package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个正整数n，表示一场比赛的时间，比赛中题目的难度是递增的.
 *      你每完成一个题目，就要花费k × i的时间，其中k是输入的一个系数，i表示题目的序号(从1开始)。
 *      根据这些信息，返回这场比赛中，你最多能完成几个题目。
 *
 * 用例：
 *      **用例1**
 *      输入: n = 30, k = 1
 *      输出: 7
 *      解释:
 *      Because 1 * 1 + 1 * 2 + 1 * 3 + 1 * 4 + 1 * 5 + 1 * 6 + 1 * 7 = 28 < 30 and 1 * 1 + 1 * 2 + 1 * 3 + 1 * 4 + 1 * 5 + 1 * 6 + 1 * 7 + 1 * 8 = 36 > 30
 *      
 *      **用例2**
 *      输入: n = 31, k = 2
 *      输出: 5
 *      解释:
 *      Because 2 * 1 + 2 * 2 + 2 * 3 + 2 * 4 + 2 * 5 = 30 < 31 and 2 * 1 + 2 * 2 + 2 * 3 + 2 * 4 + 2 * 5 + 2 * 6 = 42 > 31
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/how-many-problem-can-i-accept/description
 * @date   2019-07-19 17:53:59
 */
public class L_0937_How_Many_Problem_Can_I_Accept {

    /**
     *
     * k*(1 + 2 + ... + x) < n 
     * k * x * (x+1) / 2 < n
     * x² + x - 2n/k < 0
     * 
     * a = 1
     * b = 1
     * c = -2n/k
     * 
     * x=[-b±√(b²-4ac)]/2a
     * 
     * x = [-1±√(1+8n/k)]/2
     * 
     * 直接使用一元二次方程的求根公式即可。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public long canAccept(long n, int k) {
            return (long) (Math.sqrt(1.0 + (8.0 * n) / k) - 1.0) / 2;
        }
        
        public int f(double x, long n, int k) {
            return (int) (x*x + x - 2 * n / k);
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 30;
        int k = 1;
        
        Out.p(new Solution().canAccept(n, k));
        
    }

}
