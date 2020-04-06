package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * 1-bit and 2-bit Characters
 * -----------------------------------------------------------------------------
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).  
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      bits = [1, 0, 0]
 *      Output: True
 *      Explanation: 
 *      The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 *      Example 2
 *      Input: 
 *      bits = [1, 1, 1, 0]
 *      Output: False
 *      Explanation: 
 *      The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 *      Note:
 *      1 .
 *      bits[i] is always 0 or 1.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * @since   2020-04-06 23:21:42
 */
public class L0717_1_bit_and_2_bit_Characters {
    /**
     * 遇到 1 就进位，如果能够遍历到最后一位，说明最后一位为单独字符。
     */
    static class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int i = 0;
            for (i = 0; i < bits.length; i++) {
                if (i == bits.length - 1) {
                    return true;
                }
                if (bits[i] == 1) {
                    i++;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
