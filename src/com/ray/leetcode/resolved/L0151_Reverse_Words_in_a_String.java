package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Random;

/**
 * Reverse Words in a String
 * -----------------------------------------------------------------------------
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *      Example 1
 *      Input: the sky is blue
 *      Output: blue is sky the
 *      Example 2
 *      Input:   hello world!  
 *      Output: world! hello
 *      Explanation: Your reversed string should not contain leading or trailing spaces.
 *      Example 3
 *      Input: a good   example
 *      Output: example good a
 *      Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *      Note:
 *      	A word is defined as a sequence of non-space characters.
 *      	Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 *      	You need to reduce multiple spaces between two words to a single space in the reversed string.
 *      Follow up:
 *      For C programmers, try to solve it in-place in O(1) extra space.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @since   2020-03-07 21:25:37
 */
public class L0151_Reverse_Words_in_a_String {
    static class Solution {

        public String reverseWords(String s) {
            char[] arr = new char[s.length()];
            int cursor = 0;
            int r = s.length()-1;
            for (int i = s.length()-1; i >= -1; i--) {
                char c = i >= 0 ? s.charAt(i) : ' ';
                if (c == ' ') {
                    if (r == i) {
                        r --;
                        continue;
                    }
                    if (cursor != 0) {
                        arr[cursor++] = ' '; // cursor = 0  说明还没有检测到 world
                    }
                    for (int j = i+1; j <= r; j++) {
                        arr[cursor++] = s.charAt(j);
                    }
                    r = i-1;
                }
            }
            return new String(arr, 0, cursor);
        }
    }

    static String createString(int n) {
        char[] chars = new char[n];
        Random r = new Random(47);
        for (int i = 0; i < chars.length; i++) {
            int size = r.nextInt(5);
            if (size+i >= chars.length)
                size = chars.length - i - 1;
            for (int j = 0; j < size; j++) {
                chars[j+i] = (char)(r.nextInt(26) + 97);
            }
            chars[i+size] = ' ';
            i += size;
        }

        return new String(chars);
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
