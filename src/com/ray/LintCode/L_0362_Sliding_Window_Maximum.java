package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [1,2,7,7,8]
 *      3
 *      输出:
 *      [7,7,8]
 *      
 *      Explanation：
 *      At first the window is at the start of the array like this `[|1, 2, 7| ,7, 8]` , return the maximum `7`;
 *      then the window move one step forward.`[1, |2, 7 ,7|, 8]`, return the maximum `7`;
 *      then the window move one step forward again.`[1, 2, |7, 7, 8|]`, return the maximum `8`;
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      [1,2,3,1,2,3]
 *      5
 *      Output:
 *      [3,3]
 *      
 *      Explanation:
 *      At first, the state of the window is as follows: ` [,2,3,1,2,1 | , 3] `, a maximum of ` 3 `;
 *      And then the window to the right one. ` [1, | 2,3,1,2,3 |] `, a maximum of ` 3 `;
 *      ```
 *
 * 挑战：
 *      o(n) time and O(k) memory
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sliding-window-maximum/description
 * @date   2019-07-11 18:32:08
 */
public class L_0362_Sliding_Window_Maximum {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
