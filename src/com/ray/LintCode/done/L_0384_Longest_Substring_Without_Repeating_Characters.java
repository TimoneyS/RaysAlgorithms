package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string, find the length of the longest substring without repeating characters.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "abcabcbb"
 *      Output: 3
 *      Explanation: The longest substring is "abc".
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "bbbbb"
 *      Output: 1
 *      Explanation: The longest substring is "b".
 *      ```
 *
 * 挑战：
 *      time complexity O(n)
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-substring-without-repeating-characters/description
 * @date   2019-07-11 18:32:23
 */
public class L_0384_Longest_Substring_Without_Repeating_Characters {


    /**
     * 不断的前行，并记录每个字符出现的次数
     *      若字符不重复，则将长度+1
     *      若字符出现重复，则将长度截断到上一次该字符出现的位置
     *      同时记录每次计算后的长度的最大值
     * @author rays1
     *
     */
    static class Solution {
    
        public int lengthOfLongestSubstring(String s) {
            
            int[] count = new int[256];
            
            int max = 0, curr = 0;
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)] ++;
                if (count[s.charAt(i)] == 1) {
                    // 无重复
                    curr ++;
                    max = Math.max(max, curr);
                } else {
                    // 有重复
                    int j = i - curr;
                    while (j < i) {
                        count[s.charAt(j)] --;
                        if (s.charAt(j) == s.charAt(i)) break;
                        j ++;
                    }
                    curr = i - j;
                }
                
            }
            
            return max;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
