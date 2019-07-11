package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a set of words **without duplicates**, find all [`word squares`](https://en.wikipedia.org/wiki/Word_square "Word square") you can build from them.
 *      
 *      A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 *      
 *      For example, the word sequence `["ball","area","lead","lady"]` forms a word square because each word reads the same both horizontally and vertically.
 *      ```
 *      b a l l
 *      a r e a
 *      l e a d
 *      l a d y
 *      ```
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      ["area","lead","wall","lady","ball"]
 *      Output:
 *      [["wall","area","lead","lady"],["ball","area","lead","lady"]]
 *      
 *      Explanation:
 *      The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      ["abat","baba","atan","atal"]
 *      Output:
 *       [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-squares/description
 * @date   2019-07-11 18:34:36
 */
public class L_0634_Word_Squares {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
