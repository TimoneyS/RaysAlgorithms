package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   In a given array `nums` of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size `k`, and we want to maximize the sum of all `3*k` entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographially smallest one.
 *
 * Example :
 *   **Example 1**

```
Input: 
[1,2,1,2,6,7,5,1]
2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
```

**Example 2**

```plain
Input:
[1,2,3]
1
Output: [0,1,2]
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-sum-of-3-non-overlapping-subarrays/description
 * @date   2019-07-03 17:38:23
 */
public class L_1083_Maximum_Sum_of_3_Non_Overlapping_Subarrays {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
