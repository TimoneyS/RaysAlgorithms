package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Implement a data structure supporting the following operations:
 *   
 *   * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 *   * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 *   * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 *   * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 *
 * Example :
 *   **Example 1:**
```
Input：
AllOne()
inc("hello")
getMaxKey()
getMinKey()
Output：["hello","hello"]
Explanation：Only a string"hello",so all return "hello".
```

**Example 2:**
```
Input：
AllOne()
inc("hello")
inc("hello")
getMaxKey()
getMinKey()
inc("lint")
getMaxKey()
getMinKey()
Output：["hello","hello","hello","lint"]
Explanation：In the first three queries, there was only one string "hello",last appearance"lint",so return three times "hello" and once "lint" .
```
 *
 * Challenge :
 *   Perform all these in O(1) time complexity.
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/all-oone-data-structure/description
 * @date   2019-07-03 17:42:00
 */
public class L_1245_All_O_one_Data_Structure {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
