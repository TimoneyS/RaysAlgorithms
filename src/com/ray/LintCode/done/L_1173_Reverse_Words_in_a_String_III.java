package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个字符串句子，反转句子中每一个单词的所有字母，同时保持空格和最初的单词顺序。
 *      字符串中，每一个单词都是由空格隔开，字符串中不会有多余的空格。
 *      
 * 用例：
 *      ```
 *      输入: "Let's take LeetCode contest"
 *      输出: "s'teL ekat edoCteeL tsetnoc"
 *      ```
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-words-in-a-string-iii/description
 * @date   2019-07-19 17:27:56
 */
public class L_1173_Reverse_Words_in_a_String_III {

    /**
     * 直接遍历，遇到空格或者解尾时，反向回溯将字符添加到结果中。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String reverseWords(String s) {
            
            StringBuilder sb = new StringBuilder();
            int l = 0;
            for (int i = 0; i <= s.length(); i++) {
                char c = i == s.length() ? ' ' : s.charAt(i);
                
                if (c == ' ') {
                    for (int j = i-1; j >= l; j--) {
                        sb.append(s.charAt(j));
                    }
                    if (i < s.length()) sb.append(' ');
                    l = i+1;
                }
            }
            
            return sb.toString();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution().reverseWords("Let's take LeetCode contest"));
        
    }

}
