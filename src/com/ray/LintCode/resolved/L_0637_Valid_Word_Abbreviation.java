package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个非空字符串 word 和缩写 abbr，返回字符串是否可以和给定的缩写匹配。
 * 比如一个 “word” 的字符串仅包含以下有效缩写：
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * @author rays1
 *
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
        
        String word = "321";
        String abbr = "3";
        
        Out.p(new Solution().validWordAbbreviation(word, abbr));
        
    }

}
