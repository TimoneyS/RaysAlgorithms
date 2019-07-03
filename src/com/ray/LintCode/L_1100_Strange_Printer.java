package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   There is a strange printer with the following two special requirements:

1. The printer can only print a sequence of the same character each time.
2. At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.
 *
 * Example :
 *   **Example 1:**
```
Input: "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
```
**Example 2:**
```
Input: "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/strange-printer/description
 * @date   2019-07-03 17:38:43
 */
public class L_1100_Strange_Printer {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
