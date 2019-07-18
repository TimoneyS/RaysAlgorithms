package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Two strings are given and you have to modify 1st string such that all the common characters of the 2nd strings have to be removed and the uncommon characters of the 2nd string have to be concatenated with uncommon characters of the 1st string.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : s1 = "aacdb", s2 = "gafd"
 *      Output : "cbgf"
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : s1 = "abcs", s2 = "cxzca"
 *      Output : "bsxz"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/concatenated-string-with-uncommon-characters-of-two-strings/description
 * @date   2019-07-11 18:35:40
 */
public class L_0702_Concatenated_String_with_Uncommon_Characters_of_Two_Strings {

    /**
     * 统计字符在 s1 和 s2 中计数 c1[] c2[]
     * 遍历 s1 和 s2 的每个字符 char 只要 c1[char] * char[char] == 0 表示该字符非共有字符，则加入新的字符。
     * 
     * 似乎必须要用两个数组计数，因为单个数组计数，无法区分统计结果是以为字符串内部重复还是和 另一个字符串重复
     * 
     * 时间复杂度 O(n)，空间复杂度O(1)
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public String concatenetedString(String s1, String s2) {
            if (s1 == null || s2 == null) return s1 + s2;
            
            int[][] c = new int[255][2];
            for (int i = 0; i < s1.length(); i++) c[s1.charAt(i)][0] ++;
            for (int i = 0; i < s2.length(); i++) c[s2.charAt(i)][1]++;    
            
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s1.length(); i++) if (c[s1.charAt(i)][0] * c[s1.charAt(i)][1] == 0) sb.append(s1.charAt(i));
            for (int i = 0; i < s2.length(); i++) if (c[s2.charAt(i)][0] * c[s2.charAt(i)][1] == 0) sb.append(s2.charAt(i));
            
            return sb.toString();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
