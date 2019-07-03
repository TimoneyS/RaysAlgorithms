package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
 *   
 *   Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 *   
 *   Given a non-empty string S and a number K, format the string according to the rules described above.
 *
 * Example :
 *   Input: S = "5F3Z-2e-9-w", K = 4
 *   
 *   Output: "5F3Z-2E9W"
 *   
 *   Explanation: The string S has been split into two parts, each part has 4 characters.
 *   Note that the two extra dashes are not needed and can be removed.
 *   
 *   Input: S = "2-5g-3-J", K = 2
 *   
 *   Output: "2-5G-3J"
 *   
 *   Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/license-key-formatting/description
 * @date   2019-07-03 17:41:19
 */
public class L_1214_License_Key_Formatting {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
