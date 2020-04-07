package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Jewels and Stones
 * -----------------------------------------------------------------------------
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so a is considered a different type of stone from A.
 *
 * Example:
 *      Example 1
 *      Input: J = aA, S = aAAbbbb
 *      Output: 3
 *      Example 2
 *      Input: J = z, S = ZZ
 *      Output: 0
 *      Note:
 *      	S and J will consist of letters and have length at most 50.
 *      	The characters in J are distinct.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/jewels-and-stones/
 * @since   2020-04-07 22:11:20
 */
public class L0782_Jewels_and_Stones {
    static class Solution {
        public int numJewelsInStones(String J, String S) {
            int rs = 0;
            byte[] marked = new byte[52];
            for (int i = 0; i < J.length(); i ++)
                marked[toI(J.charAt(i))] = 1;

            for (int i = 0; i < S.length(); i ++)
                if (marked[toI(S.charAt(i))] == 1) rs ++;
            return rs;
        }

        private int toI(char c) {
            return Character.isUpperCase(c) ? c - 'A' + 26 : c - 'a';
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
