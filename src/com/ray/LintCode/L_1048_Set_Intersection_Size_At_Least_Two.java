package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.
 *   
 *   Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has size at least 2
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 *   Output: 3
 *   
 *   Explanation:
 *   Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
 *   Also, there isn't a smaller size set that fulfills the above condition.
 *   Thus, we output the size of this set, which is 3.
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
 *   Output: 5
 *   
 *   Explanation:
 *   An example of a minimum sized set is {1, 2, 3, 4, 5}.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/set-intersection-size-at-least-two/description
 * @date   2019-07-03 17:37:19
 */
public class L_1048_Set_Intersection_Size_At_Least_Two {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
