package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   A magical string S consists of only '1' and '2' and obeys the following rules:

The string **S** is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string **S** itself.

The first few elements of string **S** is the following: **S** = "1221121221221121122……"

If we group the consecutive '1's and '2's in **S**, it will be:

1 22 11 2 1 22 1 22 11 2 11 22 ......

and the occurrences of '1's or '2's in each group are:

1 2	2 1 1 2 1 2 2 1 2 2 ......

You can see that the occurrence sequence above is the **S** itself.

Given an integer N as input, return the number of '1's in the first N number in the magical string **S**.
 *
 * Example :
 *   Example 1:
```
Input: 6
Output: 3
Explanation: The first 6 elements of magical string S is "122112" and it contains three 1's, so return 3.
```

Example 2:
```
Input: 3
Output: 1
Explanation: The first 3 elements of magical string S is "122" and it contains one 1, so return 1.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/magical-string/description
 * @date   2019-07-03 17:41:21
 */
public class L_1215_Magical_String {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
