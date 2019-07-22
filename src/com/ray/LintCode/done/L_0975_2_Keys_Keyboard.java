package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 *      
 *      1. `Copy All:` You can copy all the characters present on the notepad (partial copy is not allowed).
 *      2. `Paste:` You can paste the characters which are copied **last time**.
 *      Given a number `n`. You have to get **exactly** `n` 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get `n` 'A'.
 *  
 *      初始时在记事本上只有一个字符 'A'。你可以在此记事本上每一步可以进行两种操作：
 *          Copy All: 你可以复制记事本上所有的字符（不允许部分复制）
 *          Paste: 你可以粘贴上一次复制的字符。
 *      给出一个数字 n。你需要在记事本上得到恰好 n 个 'A'， 请问最少需要几步。
 *  
 * 用例：
 *      用例 1:
 *      输入: 3
 *      输出: 3
 *      解释:  A -> AA -> AAA
 *      
 *      用例 2:
 *      输入: 1
 *      输出: 0
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/2-keys-keyboard/description
 * @date   2019-07-22 18:17:25
 */
public class L_0975_2_Keys_Keyboard {

    /**
     * dp[i] 表示恰好得到 i 个字符所需的最小次数
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int minSteps(int n) {
            int[] dp = new int[n+1];
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                for (int j = i-1; j > 1; j--) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + (i/j);
                        break;
                    }
                    
                }
            }
            return dp[n];
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 15;
        
        Out.p(new Solution().minSteps(n));
        
    }

}
