package com.ray.LintCode.locked;

import com.ray.io.Out;

/**
 * 描述：
 *      Imagine you have a special keyboard with the following keys:
 *          - `Key 1`: (A): Print one 'A' on screen.
 *          - `Key 2`: (Ctrl-A): Select the whole screen.
 *          - `Key 3`: (Ctrl-C): Copy selection to buffer.
 *          - `Key 4`: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 *      Now, you can only press the keyboard for **N** times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.
 *
 *      假设你有一个特殊的键盘，键盘上有如下键:
 *          键1: (A): 在屏幕上打印一个'A'。
 *          键2: (Ctrl-A): 选择整个屏幕。
 *          键3: (Ctrl-C): 复制选择到缓冲区。
 *          键4: (Ctrl-V): 在屏幕上已有的内容后面追加打印缓冲区的内容。
 *      现在，你只能按键盘上N次(使用以上四个键)，找出你可以在屏幕上打印的“A”的最大数量
 *
 * 用例：
 *      **Example 1:**
 *      Input: 3
 *      Output: 3
 *      Explanation: A, A, A
 *      
 *      **Example 2:**
 *      Input: 7
 *      Output: 9
 *      Explanation: A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/4-keys-keyboard/description
 * @date   2019-07-11 18:38:07
 */
public class L_0867_4_Keys_Keyboard {

    /**
     * 执行一次复制需要的操作： c-A c-C c-V 3 次
     * 复制操作在执行了 c-V 之后，可以继续使用 c-V 复制任意次
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
        
        int N = 9;
        
        Out.p(new Solution().maxA(N));
    }

}
