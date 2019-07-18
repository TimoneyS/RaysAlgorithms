package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a **non-empty** string `word` and an abbreviation `abbr`, return whether the string matches with the given abbreviation.
 *      
 *      A string such as `"word"` contains only the following valid abbreviations:
 *      ```
 *      ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *      ```
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : s = "internationalization", abbr = "i12iz4n"
 *      Output : true
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : s = "apple", abbr = "a2e"
 *      Output : false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-word-abbreviation/description
 * @date   2019-07-11 18:34:38
 */
public class L_0637_Valid_Word_Abbreviation {

    static class Solution {
        
        public boolean validWordAbbreviation(String word, String abbr) {
            int i = 0, j = 0;
            while (i < word.length() && j < abbr.length()) {
                if (word.charAt(i) == abbr.charAt(j)) {
                    i++;
                    j++;
                } else if ((abbr.charAt(j) > '0') && (abbr.charAt(j) <= '9')) {     //notice that 0 cannot be included
                    int start = j;
                    while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                        j++;
                    }
                    i += Integer.valueOf(abbr.substring(start, j));
                } else {
                    return false;
                }
            }
            return (i == word.length()) && (j == abbr.length());
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
