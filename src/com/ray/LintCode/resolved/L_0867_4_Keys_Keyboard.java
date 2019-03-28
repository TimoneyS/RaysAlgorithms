package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Imagine you have a special keyboard with the following keys:
 *    Key 1: (A): Print one 'A' on screen.
 *    Key 2: (Ctrl-A): Select the whole screen.
 *    Key 3: (Ctrl-C): Copy selection to buffer.
 *    Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 * Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.
 *
 * @author rays1
 * @url    
 */
public class L_0867_4_Keys_Keyboard {

    /**
     * 执行一次复制需要的操作 ： c-A c-C c-V 3 次
     * 复制操作在执行了 c-V 之后，可以继续执行 任意次
     * 
     * 因此 dp[i] = max {dp[i-1] + 1, dp[i-k] * 2^k-2} (k >= 3)
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int maxA(int N) {
            int[] dp = new int[N+1];
            
            int rs = 0;
            for (int i = 1; i <= N; i++) {
                dp[i] = Math.max(dp[i-1]+1, dp[i]);
                for (int j = i+3; j <= N; j++) {
                    dp[j] = Math.max(dp[i] * (j-i-1), dp[j]);
                }
                rs = Math.max(rs, dp[N]);
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int N = 15;
        Out.p(new Solution().maxA(N));
        
    }

}