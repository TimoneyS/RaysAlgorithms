package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   There is a multi-branch tree whose `n` nodes are rooted at `1`. Find the number of connected subgraphs of this tree. 

Since the middle part of the calculation and the answer may exceed the range of long, the answer is modulo `10000007`. (Connected subgraph: optional `x` points (`1 <= x <= n`), any two points can reach each other)
 *
 * Example :
 *   **Example 1**

```
Input:
start = [1]
end   = [2]
Output: 3
Explanation:
There are 3 connected subgraphs [1], [2], [1→2].
```

**Example 2**

```
Input:
start = [1, 1]
end   = [2, 3]
Output: 6
Explanation:
There are 6 connected subgraphs [1], [2], [3], [1→2], [1→3], [1→2,1→3].
```

**Example 3**

```
Input:
start = [1, 1, 2]
end   = [2, 3, 4]
Output: 10
Explanation:
There are 10 connected subgraphs [1], [2], [3], [4], [1→2], [1→3], [2→4], [1→2,1→3], [1→2,2→4], [1→3,1→2,2→4] .
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/subtree-count/description
 * @date   2019-07-03 17:45:22
 */
public class L_1383_Subtree_Count {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
