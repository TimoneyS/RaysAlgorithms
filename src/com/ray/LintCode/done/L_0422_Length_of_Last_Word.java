package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string s consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word in the string.
 *      
 *      If the last word does not exist, return `0`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: "Hello World"
 *      Output: 5
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: "Hello LintCode"
 *      Output: 8
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/length-of-last-word/description
 * @date   2019-07-11 18:32:54
 */
public class L_0422_Length_of_Last_Word {

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
            
            Out.p(start + " " + end);
            return Math.max(end == -1? 0 : end-start+1, 0);
        }
    
    }
    
    public static void main(String[] args) {
        String s= " ";
        
        Out.p(new Solution().lengthOfLastWord(s));
        
    }

}
