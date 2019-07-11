package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Check if two binary trees are identical. Identical means the two binary trees have the same structure and every identical position has the same value.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:{1,2,2,4},{1,2,2,4}
 *      Output:true
 *      Explanation:
 *              1                   1
 *             / \                 / \
 *            2   2   and         2   2
 *           /                   /
 *          4                   4
 *      
 *      are identical.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:{1,2,3,4},{1,2,3,#,4}
 *      Output:false
 *      Explanation:
 *      
 *              1                  1
 *             / \                / \
 *            2   3   and        2   3
 *           /                        \
 *          4                          4
 *      
 *      are not identical.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/same-tree/description
 * @date   2019-07-11 18:33:23
 */
public class L_0469_Same_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
