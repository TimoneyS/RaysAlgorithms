package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   We have two integer sequences `A` and `B` of the same non-zero length.

We are allowed to swap elements `A[i]` and `B[i]`.  Note that both elements are in the same index position in their respective sequences.

After some number of swaps, `A` and `B` are both strictly increasing.  (A sequence is strictly increasing if and only if `A[0] < A[1] < A[2] < ... < A[A.length - 1]`.)

Given `A` and `B`, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 *
 * Example :
 *   **Example 1:**

```
Input: A = [1,3,5,4], B = [1,2,3,7]
Output: 1
Explanation: Swap A[3] and B[3]. Then the sequences are:
  A = [1,3,5,7] and B = [1,2,3,4],
  which are both strictly increasing.
```

**Example 2:**

```
Input: A = [2,4,5,7,10], B = [1,3,4,5,9]
Output: 0
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-swaps-to-make-sequences-increasing/description
 * @date   2019-07-03 17:36:26
 */
public class L_1016_Minimum_Swaps_To_Make_Sequences_Increasing {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
