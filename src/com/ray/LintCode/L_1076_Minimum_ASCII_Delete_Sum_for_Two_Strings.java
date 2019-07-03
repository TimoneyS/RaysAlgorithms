package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given two strings `s1, s2`, find the lowest ASCII sum of deleted characters to make two strings equal.
 *
 * Example :
 *   ```
Example 1:
	Input:  s1 = "sea", s2 = "eat"
	Output:  231
	
	Explanation:
	Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
	Deleting "t" from "eat" adds 116 to the sum.
	At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

	
Example 2:
	Input: s1 = "delete", s2 = "leet"
	Output:  403
	
	Explanation:
	Deleting "dee" from "delete" to turn the string into "let",
	adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
	At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
	If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-ascii-delete-sum-for-two-strings/description
 * @date   2019-07-03 17:38:13
 */
public class L_1076_Minimum_ASCII_Delete_Sum_for_Two_Strings {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
