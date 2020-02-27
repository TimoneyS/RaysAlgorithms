package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * Example:
 * Input: Hello World
 * Output: 5
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/length-of-last-word/
 * @since   2020-02-27 22:32:26
 */
public class L0058_Length_of_Last_Word {
    static class Solution {

        public int lengthOfLastWord(String s) {
            int end = -1;
            int start = -1;
            for (int i = s.length() -1; i >= 0; i --) {
                char c = s.charAt(i);
                if (end == -1) {
                    if (c != ' ') end = i;
                }
                if (c == ' ') {
                    start = i+1;
                    if (end != -1) break;
                } else if (i == 0) {
                    start = i;
                    if (end != -1) break;
                }
            }
            return Math.max(end == -1? 0 : end-start+1, 0);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
