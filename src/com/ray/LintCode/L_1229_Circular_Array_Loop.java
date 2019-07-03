package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps. Conversely, if it's negative (-n), move backward n steps. Assume the first element of the array is forward next to the last element, and the last element is backward next to the first element. Determine if there is a loop in this array. A loop starts and ends at a particular index with **more than 1** element along the loop. The loop **must be "forward" or "backward'**.
 *
 * Example :
 *   **Example 1:** 
```
Input: [2, -1, 1, 2, 2]
OUtput: true
Explanation: there is a loop, from index 0 -> 2 -> 3 -> 0.
```
**Example 2:**
```
Input: [-1, 2]
Output: false
```
 *
 * Challenge :
 *   Can you do it in **O(n)** time complexity and **O(1)** space complexity?
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/circular-array-loop/description
 * @date   2019-07-03 17:41:43
 */
public class L_1229_Circular_Array_Loop {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
