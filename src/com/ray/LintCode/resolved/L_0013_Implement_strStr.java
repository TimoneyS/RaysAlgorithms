package com.ray.LintCode.resolved;

/**
 * For a given source string and a target string, 
 * you should output the first index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 * <p>
 * Example
 * <p>
 * <li>If source = "source" and target = "target", return -1.
 * <li>If source = "abcdabcdefg" and target = "bcd", return 1.
 * <p>
 * Challenge : O(n²) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
 * @author rays1
 *
 */
public class L_0013_Implement_strStr {
    
    static class Solution {
        
        /**
         * @param source: 
         * @param target: 
         * @return: return the index
         */
        public int strStr(String source, String target) {
            int j,M = target.length();
            int i,N = source.length();
            
            for (i = 0, j = 0; i < N && j < M; i ++) {
                
                if (source.charAt(i) == target.charAt(j)) {
                    j ++;
                } else {
                    // 回退本次查找
                    i -= j;
                    j = 0;
                }
            }
            if (j == M) return i - M;
            else        return -1;
        }
        
    }
    
}
