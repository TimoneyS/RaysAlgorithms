package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two words *word1* and *word2*, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *      
 *      You have the following 3 operations permitted on a word:
 *      
 *      - Insert a character
 *      - Delete a character
 *      - Replace a character
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 
 *      "horse"
 *      "ros"
 *      Output: 3
 *      Explanation: 
 *      horse -> rorse (replace 'h' with 'r')
 *      rorse -> rose (remove 'r')
 *      rose -> ros (remove 'e')
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 
 *      "intention"
 *      "execution"
 *      Output: 5
 *      Explanation: 
 *      intention -> inention (remove 't')
 *      inention -> enention (replace 'i' with 'e')
 *      enention -> exention (replace 'n' with 'x')
 *      exention -> exection (replace 'n' with 'c')
 *      exection -> execution (insert 'u')
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/edit-distance/description
 * @date   2019-07-11 18:30:48
 */
public class L_0119_Edit_Distance {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
