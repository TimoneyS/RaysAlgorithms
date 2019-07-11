package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 *      ```
 *      'A' -> 1
 *      'B' -> 2
 *      ...
 *      'Z' -> 26
 *      ```
 *      Beyond that, now the encoded string can also contain the character `*`, which can be treated as one of the numbers from 1 to 9.
 *      Given the encoded message containing digits and the character `*`, return the total number of ways to decode it.
 *      Also, since the answer may be very large, you should return the output mod 10^9 + 7.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: "*"
 *      Output: 9
 *      Explanation: You can change it to "A", "B", "C", "D", "E", "F", "G", "H", "I".
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: "1*"
 *      Output: 18
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/decode-ways-ii/description
 * @date   2019-07-11 18:35:22
 */
public class L_0676_Decode_Ways_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
