package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array `nums` of length `n` and an array `req` of length `k` , you need to fold the array as required, and output the result of the fold.
 *      1.If `req[i] = 0` means you should fold from `left` to `right`
 *      for example:
 *      ```
 *      1 2 3 4 5 6 7 8  ==>   4 3 2 1
 *                             5 6 7 8
 *      ```
 *      2.If `req[i] = 1` means you should fold from `right` to `left`
 *      for example:
 *      ```
 *      1 2 3 4 5 6 7 8  ==>   8 7 6 5
 *                             1 2 3 4
 *      ```
 *      
 *      More example:
 *      ```
 *      fold from left to right
 *      4 3 2 1  ==>  6 5
 *      5 6 7 8       3 4
 *                    2 1
 *                    7 8
 *      
 *      
 *      fold from right to left
 *      6 5  ==>   8
 *      3 4        1
 *      2 1        4
 *      7 8        5
 *                 6
 *                 3
 *                 2
 *                 7 
 *      ```
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      nums = [1, 2, 3, 4, 5, 6, 7, 8]
 *      req = [0, 0, 1]
 *      
 *      Output: [8, 1, 4, 5, 6, 3, 2, 7]
 *      Explanation: Please see the description.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      nums = [1,2,3,4]
 *      req = [0,1]
 *      
 *      Output: [4,1,2,3]
 *      ```
 *
 * 挑战：
 *      How to do in place?
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/folding-array/description
 * @date   2019-07-11 18:35:41
 */
public class L_0703_Folding_Array {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
