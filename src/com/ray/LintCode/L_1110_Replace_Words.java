package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 *   Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 *   You need to output the sentence after the replacement.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: 
 *   dict = ["cat", "bat", "rat"]
 *   sentence = "the cattle was rattled by the battery"
 *   Output: 
 *   "the cat was rat by the bat"
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input: 
 *   dict = ["go", "begin", "make","end"]
 *   sentence = "a good beginning makes a good ending"
 *   Output: 
 *   "a go begin make a go end"
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/replace-words/description
 * @date   2019-07-03 17:38:54
 */
public class L_1110_Replace_Words {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
