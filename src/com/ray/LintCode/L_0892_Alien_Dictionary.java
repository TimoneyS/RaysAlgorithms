package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of **non-empty** words from the dictionary, where words are **sorted lexicographically by the rules of this new language**. Derive the order of letters in this language.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：["wrt","wrf","er","ett","rftt"]
 *      Output："wertf"
 *      Explanation：
 *      from "wrt"and"wrf" ,we can get 't'<'f'
 *      from "wrt"and"er" ,we can get 'w'<'e'
 *      from "er"and"ett" ,we can get 'r'<'t'
 *      from "ett"and"rtff" ,we can get 'e'<'r'
 *      So return "wertf"
 *      
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：["z","x"]
 *      Output："zx"
 *      Explanation：
 *      from "z" and "x"，we can get 'z' < 'x'
 *      So return "zx"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/alien-dictionary/description
 * @date   2019-07-11 18:38:23
 */
public class L_0892_Alien_Dictionary {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
