package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 *
 * Example :
 *   ```
Example 1:
	Input:  licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
	Output:  "steps"
	
	Explanation:
	The smallest length word that contains the letters "S", "P", "S", and "T".
	Note that the answer is not "step", because the letter "s" must occur in the word twice.
	Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
	
Example 2:
	Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
	Output:  "pest"
	
	Explanation:
	There are 3 smallest length words that contains the letters "s".
	We return the one that occurred first.
	
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/shortest-completing-word/description
 * @date   2019-07-03 17:37:26
 */
public class L_1052_Shortest_Completing_Word {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
