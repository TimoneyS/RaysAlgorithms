package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Example :
 *   Example 1:
```
Input:
{5,2,-3}
Output:
[-3,2,4]
Explanation:
  5
 /  \
2   -3
since all the values happen only once, return all of them in any order.
```

Example 2:
```
Input:
{5,2,-5}
Output:
[2]
Explanation:
  5
 /  \
2   -5
since 2 happens twice, however -5 only occur once.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/most-frequent-subtree-sum/description
 * @date   2019-07-03 17:40:51
 */
public class L_1198_Most_Frequent_Subtree_Sum {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
