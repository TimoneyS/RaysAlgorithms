package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      <p style="line-height: 30px;">Given a 2D board and a word, find if the word exists in the grid.</p><p style="line-height: 30px;">The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.</p>
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：["ABCE","SFCS","ADEE"]，"ABCCED"
 *      Output：true
 *      Explanation：
 *      [    
 *           A B C E
 *           S F C S 
 *           A D E E
 *      ]
 *      (0,0)A->(0,1)B->(0,2)C->(1,2)C->(2,2)E->(2,1)D
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：["z"]，"z"
 *      Output：true
 *      Explanation：
 *      [ z ]
 *      (0,0)z
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-search/description
 * @date   2019-07-11 18:30:52
 */
public class L_0123_Word_Search {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
