package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   A password is considered strong if below conditions are all met:
 *   
 *   1. It has at least 6 characters and at most 20 characters.
 *   2. It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 *   3. It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 *   
 *   Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
 *   
 *   Insertion, deletion or replace of any one character are all considered as one change.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: "aaa123"
 *   Output: 1
 *   Explanation："aaa123"->"aaA123"
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input: "a"
 *   Output: 5
 *   Explanation："a"->"aa"->"aaA"->"aaA1"->"aaA12"->"aaA123"
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/strong-password-checker/description
 * @date   2019-07-03 17:42:06
 */
public class L_1249_Strong_Password_Checker {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
