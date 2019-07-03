package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is same.

For example, these are arithmetic sequences:
```
1,  3,  5,  7,  9
7,  7,  7,  7
3, -1, -5, -9
```

The following sequence is not arithmetic.
```
1, 1, 2, 5, 7
```

Given an array `A`, whose length is `N`. A subsequence slice of `A` is any sequence of `A[P0], A[P1], ..., A[Pk]` and `0 ≤ P0 < P1 < ... < Pk < N`

A subsequence slice of array `A` is called arithmetic if the sequence `A[P0], A[P1], ..., A[Pk-1], A[Pk]` is arithmetic. In particular, this means that `k ≥ 2`.

Return the number of arithmetic subsequence slices of `A`.
 *
 * Example :
 *   **Example 1:**

```
Input: [2, 4, 6, 8, 10]
Output: 7
Explanation: 
    All arithmetic subsequence slices are:
    [2, 4, 6] 
    [4, 6, 8] 
    [2, 6, 10]
    [6, 8, 10]
    [2, 4, 6, 8]
    [4, 6, 8, 10]
    [2, 4, 6, 8, 10]
```

**Example 2:**

```
Input: [1, 2, 3]
Output: 1
Explanation: Only [1, 2, 3]
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/arithmetic-slices-ii-subsequence/description
 * @date   2019-07-03 17:35:37
 */
public class L_0984_Arithmetic_Slices_II_Subsequence {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
