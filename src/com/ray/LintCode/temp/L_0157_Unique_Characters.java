package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement an algorithm to determine if a string has all unique characters.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "abc_____"
 *      Output: false
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  "abc"
 *      Output: true	
 *      ```
 *
 * 挑战：
 *      What if you can not use additional data structures?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/unique-characters/description
 * @date   2019-07-11 18:31:19
 */
public class L_0157_Unique_Characters {

    static class Solution {
        /*
         * @param str: A string
         * @return: a boolean
         */
        public boolean isUnique(String str) {
            int[] count = new int[256];
            for (int i = 0; i < str.length(); i++) {
                if (count[str.charAt(i)] == 0)
                    count[str.charAt(i)] ++;
                else
                    return false;
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
