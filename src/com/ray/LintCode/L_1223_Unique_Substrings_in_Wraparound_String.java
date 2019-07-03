package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Consider the string `s` to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so `s` will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

Now we have another string `p`. Your job is to find out how many unique non-empty substrings of `p` are present in `s`. In particular, your input is the string `p` and you need to output the number of different non-empty substrings of `p` in the string `s`.
 *
 * Example :
 *   Example 1:
```
Input: "a"
Output: 1
Explanation: Only the substring "a" of string "a" is in the string s.
```

Example 2:
```
Input: "cac"
Output: 2
Explanation: There are two substrings "a", "c" of string "cac" in the string s.
```

Example 3:
```
Input: "zab"
Output: 6
Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/unique-substrings-in-wraparound-string/description
 * @date   2019-07-03 17:41:32
 */
public class L_1223_Unique_Substrings_in_Wraparound_String {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
