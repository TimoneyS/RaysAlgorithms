package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Let `f(x)` be the number of zeroes at the end of `x!`. (Recall that `x! = 1 * 2 * 3 * ... * x`, and by convention, `0! = 1`.)
 *   
 *   For example, `f(3) = 0` because 3! = 6 has no zeroes at the end, while `f(11) = 2` because 11! = 39916800 has 2 zeroes at the end. Given `K`, find how many non-negative integers `x` have the property that `f(x) = K`.
 *
 * Example :
 *   **Example 1:**
```
Input: K = 0
Output: 5
Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
```

**Example 2:**
```
Input: K = 5
Output: 0
Explanation: There is no x such that x! ends in K = 5 zeroes.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/preimage-size-of-factorial-zeroes-function/description
 * @date   2019-07-03 17:36:43
 */
public class L_1023_Preimage_Size_of_Factorial_Zeroes_Function {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
