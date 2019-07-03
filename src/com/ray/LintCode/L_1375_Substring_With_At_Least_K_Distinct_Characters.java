package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a string `S` with only lowercase characters.

Return the number of substrings that contains at least `k` distinct characters.
 *
 * Example :
 *   **Example 1:**

```
Input: S = "abcabcabca", k = 4
Output: 0
Explanation: There are only three distinct characters in the string.
```

**Example 2:**

```
Input: S = "abcabcabcabc", k = 3
Output: 55
Explanation: Any substring whose length is not smaller than 3 contains a, b, c.
    For example, there are 10 substrings whose length are 3, "abc", "bca", "cab" ... "abc"
    There are 9 substrings whose length are 4, "abca", "bcab", "cabc" ... "cabc"
    ...
    There is 1 substring whose length is 12, "abcabcabcabc"
    So the answer is 1 + 2 + ... + 10 = 55.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/substring-with-at-least-k-distinct-characters/description
 * @date   2019-07-03 17:45:17
 */
public class L_1375_Substring_With_At_Least_K_Distinct_Characters {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
