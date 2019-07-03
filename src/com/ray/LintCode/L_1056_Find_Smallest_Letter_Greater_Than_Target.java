package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a list of sorted characters `letters` containing only lowercase letters, and given a `target` letter target, find the smallest element in the list that is larger than the given target.
 *   
 *   Letters also wrap around. For example, if the target is `target = 'z'` and `letters = ['a', 'b']`, the answer is `'a'`.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input:
 *   letters = ["c", "f", "j"]
 *   target = "a"
 *   Output: "c"
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input:
 *   letters = ["c", "f", "j"]
 *   target = "c"
 *   Output: "f"
 *   ```
 *   
 *   **Example 3:**
 *   ```
 *   Input:
 *   letters = ["c", "f", "j"]
 *   target = "d"
 *   Output: "f"
 *   ```
 *   
 *   **Example 4:**
 *   ```
 *   Input:
 *   letters = ["c", "f", "j"]
 *   target = "g"
 *   Output: "j"
 *   ```
 *   
 *   **Example 5:**
 *   ```
 *   Input:
 *   letters = ["c", "f", "j"]
 *   target = "j"
 *   Output: "c"
 *   ```
 *   
 *   **Example 6:**
 *   ```
 *   Input:
 *   letters = ["c", "f", "j"]
 *   target = "k"
 *   Output: "c"
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-smallest-letter-greater-than-target/description
 * @date   2019-07-03 17:37:29
 */
public class L_1056_Find_Smallest_Letter_Greater_Than_Target {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
