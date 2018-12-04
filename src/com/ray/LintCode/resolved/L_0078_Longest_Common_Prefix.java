package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * Given k strings, find the longest common prefix (LCP).
 * 
 * @author rays1
 *
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
