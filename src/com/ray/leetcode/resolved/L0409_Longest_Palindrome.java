package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Palindrome
 * -----------------------------------------------------------------------------
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *      Example 1
 *      Input:
 *      "abccccdd"
 *      Output:
 *      7
 *      Explanation:
 *      One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-palindrome/
 * @since   2020-03-23 21:46:23
 */
public class L0409_Longest_Palindrome {
    static class Solution {
        public int longestPalindrome(String s) {
            byte[] arr = s.getBytes();
            Set<Byte> set = new HashSet<>();
            int dupCount = 0;
            for(byte b : arr) {
                if(set.contains(b)) {
                    dupCount ++;
                    set.remove(b);
                } else {
                    set.add(b);
                }
            }
            return dupCount * 2 + ( (2*dupCount == arr.length) ? 0 : 1);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
