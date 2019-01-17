package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个字符串s，找到包含最多 k 个不同字符的最长子字符串 T 的长度。
 *
 * @author rays1
 *
 */
public class L_0386_Longest_Substring_with_At_Most_K_Distinct_Characters {
    
    /**
     * 用数组计数，用额外的一个数字记录数组中计数大于0的个数，即为字符个数
     * 向前进行，每个字符的统计数字加1
     * 当字符个数大于 k 时，不断从后方移除元素，同时将字符统计数字减一，直到字符个数小于等于 k
     * @author rays1
     *
     */
    static class Solution {
    
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (k <= 0) return 0;
            
            int[] count = new int[256];
            int   diffNum = 0;
            
            int max = 0, curr = 0;
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)] ++;
                
                // 新字符
                if (count[s.charAt(i)] == 1) diffNum ++;
                
                if (diffNum <= k) {
                    // 不同的字符小于等于 k
                    curr ++;
                    max = Math.max(max, curr);
                } else {
                    // 不同的字符数超标
                    int j = i - curr;
                    while (diffNum > k) {
                        if ((--count[s.charAt(j)]) == 0) {
                            diffNum --;
                        }
                        j ++;
                    }
                    curr = i - j + 1;
                }
                
            }
            
            return max;
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";
        int k = 16;
        
        Out.p(new Solution().lengthOfLongestSubstringKDistinct(s, k));
        
        
    }

}
