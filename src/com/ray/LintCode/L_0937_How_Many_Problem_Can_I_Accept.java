package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a positive integer `n` representing the time of one competition. The difficulty of the problem in the game is increasing. You need to spend `k × i` time for each question you complete, where `k` is the input coefficient and `i` is the number of the problem (starting from 1). Find the `maximum` number of problems you can complete.
 *
 * Example :
 *   **Example1**

```
Input: n = 30, k = 1
Output: 7
Explanation:
Because 1 * 1 + 1 * 2 + 1 * 3 + 1 * 4 + 1 * 5 + 1 * 6 + 1 * 7 = 28 < 30 and 1 * 1 + 1 * 2 + 1 * 3 + 1 * 4 + 1 * 5 + 1 * 6 + 1 * 7 + 1 * 8 = 36 > 30
```

**Example2**

```
Input: n = 31, k = 2
Output: 5
Explanation:
Because 2 * 1 + 2 * 2 + 2 * 3 + 2 * 4 + 2 * 5 = 30 < 31 and 2 * 1 + 2 * 2 + 2 * 3 + 2 * 4 + 2 * 5 + 2 * 6 = 42 > 31
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/how-many-problem-can-i-accept/description
 * @date   2019-07-03 17:34:52
 */
public class L_0937_How_Many_Problem_Can_I_Accept {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
