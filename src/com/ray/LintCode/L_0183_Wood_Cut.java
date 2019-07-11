package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given n pieces of wood with length `L[i]` (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      L = [232, 124, 456]
 *      k = 7
 *      Output: 114
 *      Explanation: We can cut it into 7 pieces if any piece is 114cm long, however we can't cut it into 7 pieces if any piece is 115cm long.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      L = [1, 2, 3]
 *      k = 7
 *      Output: 0
 *      Explanation: It is obvious we can't make it.
 *      ```
 *
 * 挑战：
 *      O(n log Len), where Len is the longest length of the wood.
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/wood-cut/description
 * @date   2019-07-11 18:31:42
 */
public class L_0183_Wood_Cut {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
