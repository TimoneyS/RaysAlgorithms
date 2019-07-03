package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a permutation `A` of `[0, 1, ..., N - 1]`, where `N` is the length of `A`.

The number of global inversions is the number of `i < j` with `0 <= i < j < N` and `A[i] > A[j]`.

The number of local inversions is the number of `i` with `0 <= i < N` and `A[i] > A[i+1]`.

Return `true` if and only if the number of global inversions is equal to the number of local inversions, otherwise returh `false`.
 *
 * Example :
 *   **Example 1:**

```
Input: [0, 1, 2]
Output: true
Explanation: There is 0 global inversion, and 0 local inversion.
```

**Example 2:**

```
Input: [1, 2, 0]
Output: false
Explanation: There are 2 global inversions, and 1 local inversion.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/global-and-local-inversions/description
 * @date   2019-07-03 17:37:03
 */
public class L_1037_Global_and_Local_Inversions {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
