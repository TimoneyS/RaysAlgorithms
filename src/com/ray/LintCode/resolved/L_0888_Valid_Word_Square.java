package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the k^th row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * @author rays1
 * @url    
 */
public class L_0888_Valid_Word_Square {

    static class Solution {
    
        public boolean validWordSquare(String[] words) {
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length;j++) {
                    if (charAt(words, i, j) != charAt(words, j, i)) return false;
                    if (charAt(words, i, j) == 0) break;
                }
            }
            return true;
        }
        
        public char charAt(String[] words, int i, int j) {
            if (i >= words.length || j >= words[i].length()) return 0;
            return words[i].charAt(j);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
