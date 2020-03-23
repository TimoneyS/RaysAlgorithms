package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Elimination Game
 * -----------------------------------------------------------------------------
 * 
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Find the last number that remains starting with a list of length n.
 *
 * Example:
 *      Example 1
 *      Input:
 *      n = 9,
 *      1 2 3 4 5 6 7 8 9
 *      2 4 6 8
 *      2 6
 *      6
 *      Output:
 *      6
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/elimination-game/
 * @since   2020-03-23 21:49:40
 */
public class L0390_Elimination_Game {
    /**
     * 找规律
     */
    static class Solution {
        public int lastRemaining(int n) {
            return  n <= 2 ? n : 2 * (n /2 + 1 - lastRemaining(n/2));
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
