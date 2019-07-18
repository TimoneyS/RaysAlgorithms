package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      We are playing the Guess Game. The game is as follows:
 *      I pick a number from 1 to n. You have to guess which number I picked.
 *      Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 *      However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 *      Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 10
 *      Output: 16
 *      Explanation:
 *      Given n = 10, I pick 2.
 *      First round:  You guess 7, I tell you that it's lower. You pay $7.
 *      Second round: You guess 3, I tell you that it's lower. You pay $3.
 *      Third round:  You guess 1, I tell you that it's higher. You pay $1.
 *      Game over. 1 is the number I picked.
 *      You end up paying $7 + $3 + $1 = $11.
 *      
 *      Given n = 10, I pick 4.
 *      First round:  You guess 7, I tell you that it's lower. You pay $7.
 *      Second round: You guess 3, I tell you that it's higher. You pay $3.
 *      Third round:  You guess 5, I tell you that it's lower. You pay $5.
 *      Game over. 4 is the number I picked.
 *      You end up paying $7 + $3 + $5 = $15.
 *      
 *      Given n = 10, I pick 8.
 *      First round:  You guess 7, I tell you that it's higher. You pay $7.
 *      Second round: You guess 9, I tell you that it's lower. You pay $9.
 *      Game over. 8 is the number I picked.
 *      You end up paying $7 + $7 + $9 = $16.
 *      
 *      So given n = 10, the answer is 16.
 *      ```
 *      **Example2**
 *      ```
 *      Input: 5
 *      Output: 6
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/guess-number-higher-or-lower-ii/description
 * @date   2019-07-11 18:35:17
 */
public class L_0666_Guess_Number_Higher_or_Lower_II {

    /**
     * 设 p(l, r, i) 表示猜测位于 l r 之间的数字，且第一次猜测的数字为 i，需要准备的钱数
     * 
     * 对于第一次猜测任意一个 数字 i，之后需要猜测的数字可能位于 i 左边，也可能位于 i 右边
     *      pl = p(l, i-1)
     *      pr = p(i+1, r)
     * 因为两种可能都存在，所以基于最坏的情况去考虑，
     *      p(l, r, i) = Max(p(l, i-1), p(i+1, r)) + i
     * 
     * 第一次猜测的数字不同，导致的结果也可能不同，这时候要选择一个能够使得需要准备钱数最少的方案
     * 
     * 因此
     *      rs = Min { p(l, r, i) } = Min { Max(p(l, i-1), p(i+1, r)) + i }
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        int[][] inner;
        
        public int getMoneyAmount(int n) {
            inner = new int[n+1][n+1];
            return p(1, n);
        }
        
        int p(int start, int end) {
            if (inner[start][end] == 0) {
                if (start == end) inner[start][end] = 0;
                else if (end - start == 1) inner[start][end] = Math.min(start, end);
                else {
                    int sum = Integer.MAX_VALUE;
                    for (int i = start + 1; i < end; i++) {
                        int t = Math.max(p(start, i - 1), p(i + 1, end)) + i;
                        if (t < sum )
                            sum = t;
                    }
                    inner[start][end] = sum;
                }
            }
            return inner[start][end];
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
