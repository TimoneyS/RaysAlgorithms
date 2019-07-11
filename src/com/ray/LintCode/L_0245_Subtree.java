package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      You have two very large binary trees: `T1`, with millions of nodes, and `T2`, with hundreds of nodes. Create an algorithm to decide if `T2` is a subtree of `T1`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：{1,2,3,#,#,4},{3,4}
 *      Output：true
 *      Explanation：
 *      T2 is a subtree of T1 in the following case:
 *                 1                3
 *                / \              / 
 *          T1 = 2   3      T2 =  4
 *                  /
 *                 4
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：{1,2,3,#,#,4},{3,#,4}
 *      Output：false
 *      Explanation：
 *      T2 isn't a subtree of T1 in the following case:
 *      
 *                 1               3
 *                / \               \
 *          T1 = 2   3       T2 =    4
 *                  /
 *                 4
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/subtree/description
 * @date   2019-07-11 18:32:04
 */
public class L_0245_Subtree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
