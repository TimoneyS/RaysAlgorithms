package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Guess Number Higher or Lower
 * -----------------------------------------------------------------------------
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 *
 * Example:
 *      Example 1
 *      Input: n = 10, pick = 6
 *      Output: 6
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * @since   2020-03-17 22:56:10
 */
public class L0374_Guess_Number_Higher_or_Lower {
    /**
     * 二分搜索
     */
    public static class Solution {
        public int guessNumber(int n) {
            int l = 1, r = n;
            while (l <= r ) {
                int m =  l + (r-l)/2;
                int c = guess(m);
                if (c == 0) return m;
                else if (c < 0) r = m - 1;
                else            l = m + 1;
            }
            return -1;
        }

        int guess(int num) { return Integer.compare(1702766719, num); }
    }
    
    public static void main(String[] args) {


        Out.p(new Solution().guessNumber(2126753390));
    }
}
