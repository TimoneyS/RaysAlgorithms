package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given k strings, find the longest common prefix (_LCP_).
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  "ABCD", "ABEF", "ACEF"
 *      	Output:  "A"
 *      	
 *      
 *      Example 2:
 *      	Input: "ABCDEFG", "ABCEFG" and "ABCEFA"
 *      	Output:  "ABC"
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-common-prefix/description
 * @date   2019-07-11 18:29:55
 */
public class L_0078_Longest_Common_Prefix {

    static class Solution {
        
        /**
         * @param strs: A list of strings
         * @return: The longest common prefix
         */
        public String longestCommonPrefix(String[] strs) {
            int curr = 0;
            if (strs.length==0) return "";
            if (strs.length==1) return strs[0];
            
            while (true) {
                int ch = -1;
                for (String s : strs) {
                    if (s.length() <= curr)         return s.substring(0, curr);
                    else if (ch == -1)              ch = s.charAt(curr);
                    else if (ch != s.charAt(curr))  return s.substring(0, curr);
                }
                curr ++;
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        String[] strs = {"A","B"};
        
        Out.p("\"" + new Solution().longestCommonPrefix(strs) + "\"");
    }

}
