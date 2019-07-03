package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 
 *   
 *   Person A will NOT friend request person B (B != A) if any of the following conditions are true:
 *   
 *   * age[B] <= 0.5 * age[A] + 7
 *   * age[B] > age[A]
 *   * age[B] > 100 && age[A] < 100
 *   Otherwise, A will friend request B.
 *   
 *   Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
 *   
 *   How many total friend requests are made?
 *
 * Example :
 *   **Example 1:**
```
Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
```

**Example 2:**
```
Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
```

**Example 3:**
```
Input: [20,30,100,110,120]
Output: 3
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/friends-of-appropriate-ages/description
 * @date   2019-07-03 17:45:33
 */
public class L_1393_Friends_Of_Appropriate_Ages {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
