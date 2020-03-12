package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Reverse Vowels of a String
 * -----------------------------------------------------------------------------
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example:
 *      Example 1
 *      Input: hello
 *      Output: holle
 *      Example 2
 *      Input: leetcode
 *      Output: leotcede
 *      Note:
 *      The vowels does not include the letter y.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * @since   2020-03-12 22:40:47
 */
public class L0345_Reverse_Vowels_of_a_String {
    static class Solution {
        public String reverseVowels(String s) {
            char[] a = s.toCharArray();
            for (int i = 0, j = a.length-1; i < j; i ++, j--) {
                while (i < j && !isVowels(s.charAt(i))) i++;
                while (i < j && !isVowels(s.charAt(j))) j--;
                char c = a[i];
                a[i] = a[j];
                a[j] = c;
            }
            return new String(a);
        }

        boolean isVowels(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
