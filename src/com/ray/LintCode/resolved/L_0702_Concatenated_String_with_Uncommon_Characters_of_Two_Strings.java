package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定两个字符串，返回二者删掉共同字符后的相连接形成的新字符串。
 * 简单来说就是  (s1 - s2) + (s2 - s1)
 * 
 * @author rays1
 *
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
        
        String s1 = "aacdb", s2 = "";
        
        Out.p(new Solution().concatenetedString(s1, s2));
        
    }

}
