package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Sum of Two Integers
 * -----------------------------------------------------------------------------
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example:
 *      Example 1
 *      Input: a = 1, b = 2
 *      Output: 3
 *      Example 2
 *      Input: a = -2, b = 3
 *      Output: 1
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sum-of-two-integers/
 * @since   2020-03-17 22:50:26
 */
public class L0371_Sum_of_Two_Integers {
    /**
     * 异或运算有一个别名叫做：不进位加法
     *      a^b 就是 a+b 之后，该进位的地方不进位的结果
     *      应该进位的位置自然是a和b里都是 1 的地方，就是 a&b ，那么 a&b << 1 就是进位之后的结果。
     *
     *      所以：a + b = (a ^ b) + (a & b << 1)
     * 令
     *      a' = a ^ b
     *      b' = (a & b) << 1
     *
     *      那么 a + b = a' + b'
     *
     * 因为进位不可能一直持续，所以b'最终会变为0，此时 a' 的值就是相加的结果。
     *
     * 示例：
     *      25 + 18 = 11001 + 10010
     *
     *      11001           11001
     *    ^ 10010         & 10010
     *    -------         -------
     *      01011           10000
     *
     *      问题转化为
     *      01011 + 100000
     *
     *      01011           01011
     *   ^ 100000        & 100000
     *    -------         -------
     *     101011          000000
     *
     * 结果为 101011 = 43
     */
    static class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int temp = a ^ b;
                b = (a & b) << 1;
                a = temp;
            }
            return a;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
