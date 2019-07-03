package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   A gene string can be represented by an 8-character long string, with choices from `"A"`, `"C"`, `"G"`, `"T"`.
 *   
 *   Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 *   
 *   For example, `"AACCGGTT"` -> `"AACCGGTA"` is 1 mutation.
 *   
 *   Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 *   
 *   Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 *
 * Example :
 *   **Example 1:**
```
Input:
"AACCGGTT"
"AACCGGTA"
["AACCGGTA"]
Output: 1
Explanation:
start: "AACCGGTT"
end:  "AACCGGTA"
bank: ["AACCGGTA"]
```
**Example 2:**
```
Input:
"AACCGGTT"
"AAACGGTA"
["AACCGGTA", "AACCGCTA", "AAACGGTA"]
Output: 2
```
**Example 3:**
```
Input:
"AAAAACCC"
"AACCCCCC"
["AAAACCCC", "AAACCCCC", "AACCCCCC"]
Output: 3
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-genetic-mutation/description
 * @date   2019-07-03 17:41:59
 */
public class L_1244_Minimum_Genetic_Mutation {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
