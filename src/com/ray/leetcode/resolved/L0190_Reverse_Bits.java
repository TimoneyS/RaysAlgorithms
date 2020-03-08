package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Reverse Bits
 * -----------------------------------------------------------------------------
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 *      Example 1
 *      Input: 00000010100101000001111010011100
 *      Output: 00111001011110000010100101000000
 *      Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 *      Example 2
 *      Input: 11111111111111111111111111111101
 *      Output: 10111111111111111111111111111111
 *      Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *      Note:
 *      	Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 *      	In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *      Follow up:
 *      If this function is called many times, how would you optimize it?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-bits/
 * @since   2020-03-08 20:38:39
 */
public class L0190_Reverse_Bits {
    public static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int rs = 0;
            for (int i = 0; i < 32; i++) {
                rs <<= 1;
                rs |= (n & 1);
                n >>= 1;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        int n =   0b00000010100101000001111010011101;
        Out.p(new Solution().reverseBits(n));
    }
}
