package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a (decimal - _e.g._ 3.72) number that is passed in as a string, return the binary representation that is passed in as a string. If the fractional part of the number can not be represented accurately in binary with at most 32 characters, return `ERROR`.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: "3.72"
 *      Output: "ERROR"
 *      ```
 *      
 *      Explanation: $(3.72)_{10} = (11.10111000010100011111\cdots)_2$ We can't represent it in 32 characters.
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: "3.5"
 *      OUtput: "11.1"
 *      ```
 *      
 *      Explanation: $(3.5)_{10}=(11.1)_2$
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-representation/description
 * @date   2019-07-11 18:31:39
 */
public class L_0180_Binary_Representation {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
