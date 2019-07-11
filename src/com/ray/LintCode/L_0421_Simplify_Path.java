package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an absolute path for a file (Unix-style), simplify it.
 *      
 *      In a UNIX-style file system, a period `.` refers to the current directory. Furthermore, a double period `..` moves the directory up a level.
 *      
 *      The result must always begin with `/`, and there must be only a single `/` between two directory names. The last directory name (if it exists) must not end with a trailing `/`. Also, the result must be the shortest string representing the absolute path.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "/home/"
 *      Output: "/home"
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "/a/./../../c/"
 *      Output: "/c"
 *      Explanation: "/" has no parent directory, so "/../" equals "/".
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/simplify-path/description
 * @date   2019-07-11 18:32:53
 */
public class L_0421_Simplify_Path {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
