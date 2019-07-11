package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word. No same word in dictionary
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：["doaf","agai","dcan"]，["dog","dad","dgdg","can","again"]
 *      Output：["again","can","dad","dog"]
 *      Explanation：
 *        d o a f
 *        a g a i
 *        d c a n
 *      search in Matrix，so return ["again","can","dad","dog"].
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：["a"]，["b"]
 *      Output：[]
 *      Explanation：
 *       a
 *      search in Matrix，return [].
 *      ```
 *
 * 挑战：
 *      <p>Using trie to implement your algorithm.</p>
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-search-ii/description
 * @date   2019-07-11 18:30:58
 */
public class L_0132_Word_Search_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
