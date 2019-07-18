package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a sequence of words, check whether it forms a valid word square.
 *      
 *      A sequence of words forms a valid word square if the k^th row and column read the exact same string, where `0 ≤ k < max(numRows, numColumns)`.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:  
 *      [
 *        "abcd",
 *        "bnrt",
 *        "crmy",
 *        "dtye"
 *      ]
 *      Output: true
 *      Explanation:
 *      The first row and first column both read "abcd".
 *      The second row and second column both read "bnrt".
 *      The third row and third column both read "crmy".
 *      The fourth row and fourth column both read "dtye".
 *      
 *      Therefore, it is a valid word square.
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input:  
 *      [
 *        "abcd",
 *        "bnrt",
 *        "crm",
 *        "dt"
 *      ]
 *      Output: true
 *      Explanation:
 *      The first row and first column both read "abcd".
 *      The second row and second column both read "bnrt".
 *      The third row and third column both read "crm".
 *      The fourth row and fourth column both read "dt".
 *      
 *      Therefore, it is a valid word square.
 *      ```
 *      
 *      **Example3**
 *      
 *      ```
 *      Input:  
 *      [
 *        "ball",
 *        "area",
 *        "read",
 *        "lady"
 *      ]
 *      Output: false
 *      Explanation:
 *      The third row reads "read" while the third column reads "lead".
 *      
 *      Therefore, it is NOT a valid word square.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-word-square/description
 * @date   2019-07-11 18:38:20
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
