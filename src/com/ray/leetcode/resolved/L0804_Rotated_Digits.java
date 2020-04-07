package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Rotated Digits
 * -----------------------------------------------------------------------------
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 *      Example 1
 *      Input: 10
 *      Output: 4
 *      Explanation: 
 *      There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 *      Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 *      Note:
 *      	N  will be in range [1, 10000].
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/rotated-digits/
 * @since   2020-04-07 22:06:42
 */
public class L0804_Rotated_Digits {
    /**
     * 暴力
     * 一个数字不包含3 4 7 且至少包含一个 2 5 6 9
     */
    static class Solution {
        public int rotatedDigits(int N) {
            int rs = 0;
            for (int i = 0; i <= N; i ++) {
                boolean flag = true;
                boolean contains = false;

                int number = i;
                while (number > 0) {
                    int n = number % 10;
                    number /= 10;
                    if (n == 3 || n == 4 || n == 7) {
                        flag = false;
                        break;
                    }
                    if (n == 2 || n == 5 || n == 6 || n == 9) {
                        contains = true;
                    }
                }
                if (contains && flag) {
                    rs ++;
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
