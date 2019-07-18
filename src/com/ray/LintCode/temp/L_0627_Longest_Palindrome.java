package com.ray.LintCode.temp;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *      
 *      This is case sensitive, for example `"Aa"` is not considered a palindrome here.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : s = "abccccdd"
 *      Output : 7
 *      Explanation :
 *      One longest palindrome that can be built is "dccaccd", whose length is `7`.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-palindrome/description
 * @date   2019-07-11 18:34:34
 */
public class L_0627_Longest_Palindrome {

    static class Solution {
        /**
         * @param s a string which consists of lowercase or uppercase letters
         * @return the length of the longest palindromes that can be built
         */
        public int longestPalindrome(String s) {
            byte[] arr = s.getBytes();
            Set<Byte> set = new HashSet<>();
            int dupCount = 0;
            for(byte b : arr) {
                if(set.contains(b)) {
                    dupCount ++;
                    set.remove(b);
                } else {
                    set.add(b);
                }
            }
            
            return dupCount * 2 + ( (2*dupCount == arr.length) ? 0 : 1);
            
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
