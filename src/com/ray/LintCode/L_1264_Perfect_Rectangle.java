package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 *   
 *   Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2))
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input：
 *   rectangles = [
 *     [1,1,3,3],
 *     [3,1,4,2],
 *     [3,2,4,4],
 *     [1,3,2,4],
 *     [2,3,3,4]
 *   ]
 *   Output：true
 *   Explanation：All 5 rectangles together form an exact cover of a rectangular region.
 *   ```
 *   **Example 2:**
 *   ```
 *   Input：
 *   rectangles = [
 *     [1,1,2,3],
 *     [1,3,2,4],
 *     [3,1,4,2],
 *     [3,2,4,4]
 *   ]
 *   Output：false
 *   Explanation：Because there is a gap between the two rectangular regions.
 *   ```
 *   
 *   **Example 3:**
 *   ```
 *   Input：
 *   rectangles = [
 *     [1,1,3,3],
 *     [3,1,4,2],
 *     [1,3,2,4],
 *     [3,2,4,4]
 *   ]
 *   Output：false
 *   Explanation：Because there is a gap in the top center.
 *   ```
 *   
 *   **Example 4:**
 *   ```
 *   Input：
 *   rectangles = [
 *     [1,1,3,3],
 *     [3,1,4,2],
 *     [1,3,2,4],
 *     [2,2,4,4]
 *   ]
 *   Output：false
 *   Explanation：Because two of the rectangles overlap with each other.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/perfect-rectangle/description
 * @date   2019-07-03 17:42:25
 */
public class L_1264_Perfect_Rectangle {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
