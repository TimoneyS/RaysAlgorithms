package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given an array of unique integers, each integer is strictly greater than 1.
 *   
 *   We make a binary tree using these integers and each number may be used for any number of times.
 *   
 *   Each non-leaf node's value should be equal to the product of the values of it's children.
 *   
 *   How many binary trees can we make?  Return the answer modulo **10 ** 9 + 7**.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: A = [2, 4]
 *   Output: 3
 *   Explanation: We can make these trees: [2], [4], [4, 2, 2]
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input: A = [2, 4, 5, 10]
 *   Output: 7
 *   Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-trees-with-factors/description
 * @date   2019-07-03 17:45:27
 */
public class L_1387_Binary_Trees_With_Factors {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
