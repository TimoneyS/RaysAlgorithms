package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a list of strings, you could concatenate these strings together into a loop, where for each string you could choose to reverse it or not. Among all the possible loops, you need to find the lexicographically biggest string after cutting the loop, which will make the looped string into a regular one.
 *      
 *      Specifically, to find the lexicographically biggest string, you need to experience two phases:
 *      
 *      1. Concatenate all the strings into a loop, where you can reverse some strings or not and connect them in the same order as given.
 *      2. Cut and make one breakpoint in any place of the loop, which will make the looped string into a regular one starting from the character at the cutpoint.
 *      
 *      And your job is to find the lexicographically biggest one among all the possible regular strings.
 *      
 *      Note that the string concatenation order and the direction of the loop are all left to right (i.e. the direction in which the index increases).
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: ["abc", "xyz"]
 *      Output: "zyxcba"
 *      Explanation: 
 *        You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-", 
 *        where '-' represents the looped status. 
 *        The answer string came from the fourth looped one, 
 *        where you could cut from the middle character 'a' and get "zyxcba".
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: ["awef", "eawf", "zdaeff", "awefzewaf", "awefzewaf"]
 *      Output: "zfewafewafwaezdaefffawezfewafawe"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/split-concatenated-strings/description
 * @date   2019-07-11 18:38:13
 */
public class L_0876_Split_Concatenated_Strings {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
