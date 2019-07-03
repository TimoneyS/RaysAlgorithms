package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   There is a game of stone merging. At the beginning, there were `n` piles of stones arranged in a row. The goal was to combine all the stones into a pile. The consolidation rules are as follows:
 *   
 *   1. Each time you can merge consecutive `x` piles, `left <= x <= right`.
 *   2. The cost of each merger is the sum of the weight of the combined `x` piles.
 *   
 *   Find the minimum merge cost, if you cannot complete the merge return `0`.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Given n = `4`, left = `3`, right = `3`, weight = `[1,2,3,4]`, return `0`.
 *   Input:
 *   4
 *   3
 *   3
 *   [1,2,3,4]
 *   Output:
 *   0
 *   
 *   Explanation:
 *   Unable to complete the merge.
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Given n = `3`, left = `2`, right = `3`, weight = `[1,2,3]`, return `6`.
 *   Input:
 *   3
 *   2
 *   3
 *   [1,2,3]
 *   Output:
 *   6
 *   
 *   Explanation:
 *   Merge 1,2,3, the merger cost is 1 + 2 + 3 = 6.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/segment-stones-merge/description
 * @date   2019-07-03 17:45:24
 */
public class L_1384_Segment_Stones_Merge {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
