package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: `"a"` maps to `".-"`, `"b"` maps to `"-..."`, `"c"` maps to `"-.-."`, and so on.
 *   
 *   For convenience, the full table for the 26 letters of the English alphabet is given below:
 *   ```
 *   [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *   ```
 *   Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 *   
 *   Return the number of different transformations among all words we have.
 *
 * Example :
 *   **Example 1:**
```
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
```
**Example 2:**
```
Input: words = ["a", "b"]
Output: 2
Explanation: 
The transformation of each word is:
"a" -> ".-"
"b" -> "-..."
There are 2 different transformations, ".-" and "-...".
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/unique-morse-code-words/description
 * @date   2019-07-03 17:36:22
 */
public class L_1013_Unique_Morse_Code_Words {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
