package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array with *n* objects colored *red*, *white* or *blue*, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *      
 *      Here, we will use the integers `0`, `1`, and `2` to represent the color red, white, and blue respectively.
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : [1, 0, 1, 2]
 *      Output : [0, 1, 1, 2]
 *      Explanation : sort it in-place
 *      ```
 *
 * 挑战：
 *      A rather straight forward solution is a two-pass algorithm using counting sort.
 *      First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 *      
 *      Could you come up with an one-pass algorithm using only constant space?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sort-colors/description
 * @date   2019-07-11 18:31:10
 */
public class L_0148_Sort_Colors {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
