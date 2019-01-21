package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 给定字符串s由大写/小写字母和空格字符''组成，返回字符串中最后一个单词的长度。
 * 如果最后一个单词不存在，则返回0。
 *
 * 如 "Hello World", 返回 5.
 *
 * @author rays1
 *
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
