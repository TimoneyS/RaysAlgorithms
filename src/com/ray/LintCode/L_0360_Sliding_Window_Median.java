package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the median of the element inside the window at each moving. (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [1,2,7,8,5]
 *      3
 *      Output:
 *      [2,7,7]
 *      
 *      Explanation:
 *      At first the window is at the start of the array like this `[ | 1,2,7 | ,8,5]` , return the median `2`;
 *      then the window move one step forward.`[1, | 2,7,8 | ,5]`, return the median `7`;
 *      then the window move one step forward again.`[1,2, | 7,8,5 | ]`, return the median `7`;
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      [1,2,3,4,5,6,7]
 *      4
 *      Output:
 *      [2,3,4,5]
 *      
 *      Explanation:
 *      At first the window is at the start of the array like this `[ | 1,2,3,4, | 5,6,7]` , return the median `2`;
 *      then the window move one step forward.`[1,| 2,3,4,5 | 6,7]`, return the median `3`;
 *      then the window move one step forward again.`[1,2, | 3,4,5,6 | 7 ]`, return the median `4`;
 *      then the window move one step forward again.`[1,2,3,| 4,5,6,7 ]`, return the median `5`;
 *      ```
 *
 * 挑战：
 *      O(nlog(n)) time
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sliding-window-median/description
 * @date   2019-07-11 18:32:07
 */
public class L_0360_Sliding_Window_Median {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
