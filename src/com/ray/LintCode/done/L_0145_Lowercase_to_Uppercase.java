package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Convert a lowercase character to uppercase.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 'a'
 *      Output: 'A'
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: 'b'
 *      Output: 'B'
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Native
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/lowercase-to-uppercase/description
 * @date   2019-07-11 18:31:10
 */
public class L_0145_Lowercase_to_Uppercase {

    static class Solution {
        /**
         * @param character: a character
         * @return: a character
         */
        public char lowercaseToUppercase(char character) {
            return (char) (character - 32);
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
