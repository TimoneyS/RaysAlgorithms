package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Description :
 *   There are `n` coins in a line. Two players take turns to take one or two coins from right side 
 *   until there are no more coins left.
 *   The player who take the last coin wins.
 *   
 *   Could you please decide the **first** player will win or lose?
 *   
 *   If the first player wins, return `true`, otherwise return `false`.
 *
 * Example :
 *   **Example 1:**
 *   
 *   ```
 *   Input: 1
 *   Output: true
 *   ```
 *   
 *   **Example 2:**
 *   
 *   ```
 *   Input: 4
 *   Output: true
 *   Explanation:
 *   The first player takes 1 coin at first. Then there are 3 coins left.
 *   Whether the second player takes 1 coin or two, then the first player can take all coin(s) left.
 *   ```
 *
 * Challenge :
 *   O(n) time and O(1) memory
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/coins-in-a-line/description
 * @date   2019-07-09 16:31:06
 */
public class L_0394_Coins_in_a_Line {

    /**
     * f[i] 表示从i开始拿，是否能够胜利
     * 
     * 则从i开始：
     *      1. 拿 1 个
     *          f[i] = !f[i+1]
     * 
     *      2. 拿 2 个
     *          f[i] = !f[i+2]
     * 
     *  f[i] = !f[i+1] || !f[i+2]
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean firstWillWin(int n) {
            if (n == 0) return false;
            if (n <= 2) return true;
            boolean fn1 = true, fn2 = true, f = false;
            for (int i = n-3; i >= 0; i--) {
                f = !fn1 || !fn2;
                fn2 = fn1;
                fn1 = f;
            }
            return f;
        }
    
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().firstWillWin(6));
        
    }

}
