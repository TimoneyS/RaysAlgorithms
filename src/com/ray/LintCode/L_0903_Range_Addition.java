package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Assume you have an array of length `n` initialized with all `0`'s and are given `k` update operations.

Each operation is represented as a triplet: `[startIndex, endIndex, inc]` which increments each element of subarray `A[startIndex ... endIndex]` (startIndex and endIndex inclusive) with `inc`.

Return the modified array after all `k` operations were executed.
 *
 * Example :
 *   ```
Given:
length = 5,
updates = 
[
[1,  3,  2],
[2,  4,  3],
[0,  2, -2]
]
return [-2, 0, 3, 5, 3]

Explanation:
Initial state:
[ 0, 0, 0, 0, 0 ]
After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]
After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]
After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-addition/description
 * @date   2019-07-03 17:34:08
 */
public class L_0903_Range_Addition {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
