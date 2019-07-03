package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *   
 *   Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example :
 *   **Example1**
 *   
 *   ```
 *   Input:  paragraph = "Bob hit a ball, the hit BALL flew far after it was hit." and banned = ["hit"]
 *   Output: "ball"
 *   Explanation:
 *   "hit" occurs 3 times, but it is a banned word.
 *   "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
 *   Note that words in the paragraph are not case sensitive,
 *   that punctuation is ignored (even if adjacent to words, such as "ball,"), 
 *   and that "hit" isn't the answer even though it occurs more because it is banned.
 *   ```
 *   
 *   **Example2**
 *   
 *   ```
 *   Input:  paragraph = "a a a b b c c d" and banned = ["a","b"]
 *   Output: "c"
 *   Explanation:
 *   "a" and "b" are banned words
 *   "c" occurs 2 times and "d" occurs only once
 *   So output "c"
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/most-common-word/description
 * @date   2019-07-03 17:45:15
 */
public class L_1369_Most_Common_Word {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
