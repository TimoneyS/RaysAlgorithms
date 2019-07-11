package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of n distinct non-empty strings, you need to generate **minimal** possible abbreviations for every word following rules below.
 *      
 *      1. Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 *      2. If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
 *      3. If the abbreviation doesn't make the word shorter, then keep it as original.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      ["like","god","internal","me","internet","interval","intension","face","intrusion"]
 *      Output:
 *      ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      ["where","there","is","beautiful","way"]
 *      Output:
 *      ["w3e","t3e","is","b7l","way"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-abbreviation/description
 * @date   2019-07-11 18:34:39
 */
public class L_0639_Word_Abbreviation {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
