package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement a method to perform basic string compression using the counts of repeated characters. For example, the string `aabcccccaaa` would become `a2b1c5a3`.
 *      
 *      If the "compressed" string would not become smaller than the original string, your method should return the original string.
 *      
 *      You can assume the string has only upper and lower case letters (a-z).
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: str = "aabcccccaaa"
 *      Output: "a2b1c5a3"
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: str = "aabbcc"
 *      Output: "aabbcc"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/string-compression/description
 * @date   2019-07-11 18:32:00
 */
public class L_0213_String_Compression {

    /**
     * 所有字符压缩次数为1，则不显示次数
     * 有字符被压缩，则需要显示一次的次数
     * @author rays1
     *
     */
    static class Solution {
        public String compress(String s) {
            if (s == null || s.length() == 0) return s;
            
            String str = s+"#";
            StringBuilder sb = new StringBuilder();
            
            char prev = str.charAt(0);
            int count = 1;
            int prevCount = -1;
            boolean flag = false;
            
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == prev) {
                    count ++;
                } else {
                    sb.append(prev);
                    sb.append(count);
                    if (prevCount != -1 && prevCount != count)
                        flag = true;
                    prev = str.charAt(i);
                    prevCount = count;
                    count = 1;
                }
            }
            if (prevCount != -1 && prevCount != count)
                flag = true;
            sb.append(prev);
            sb.append(count);
            
            if (!flag) {
                for (int i = sb.length()-1; i >= 0; i -= 2) {
                    sb.deleteCharAt(i);
                } 
            }
            
            while (sb.charAt(sb.length()-1) != '#')
                sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            
            return sb.length() < s.length() ? sb.toString() : s;
        }
    }
    
    public static void main(String[] args) {
        String s = "aabbcc";
        Out.p(new Solution().compress(s));
    }

}
