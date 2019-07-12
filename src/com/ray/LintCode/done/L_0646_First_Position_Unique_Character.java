package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return `-1`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : s = "lintcode"
 *      Output : 0
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : s = "lovelintcode"
 *      Output : 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/first-position-unique-character/description
 * @date   2019-07-11 18:34:45
 */
public class L_0646_First_Position_Unique_Character {

    static class Solution {
        /**
         * @param s a string
         * @return it's index
         */
        public int firstUniqChar(String s) {
            for(int i = 0; i < s.length(); i ++) {
                char c = s.charAt(i);
                if ( s.indexOf(c) == s.lastIndexOf(c) ) return i;
            }
            return -1;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
