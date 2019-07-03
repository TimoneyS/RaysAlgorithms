package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   We have two special characters. The first character can be represented by one bit `0`. The second character can be represented by two bits (`10` or `11`).
 *   
 *   Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 *
 * Example :
 *   **Example 1:**
```
Input: 
bits = [1, 0, 0]
Output: True
Explanation: 
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
```
**Example 2:**
```
Input: 
bits = [1, 1, 1, 0]
Output: False
Explanation: 
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/1-bit-and-2-bit-characters/description
 * @date   2019-07-03 17:35:15
 */
public class L_0973_1bit_and_2bit_Characters {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
