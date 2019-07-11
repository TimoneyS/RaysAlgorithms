package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      If the depth of a tree is smaller than `5`, this tree can be represented by a list of three-digits integers.
 *      
 *      For each integer in this list:
 *      
 *      1. The hundreds digit represents the depth `D` of this node, `1 <= D <= 4`.
 *      2. The tens digit represents the position `P` of this node in the level it belongs to, `1 <= P <= 8`. The position is the same as that in a full binary tree.
 *      3. The units digit represents the value `V` of this node, `0 <= V <= 9`.
 *      
 *      Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [113, 215, 221]
 *      Output: 12
 *      Explanation:
 *        The tree that the list represents is:
 *          3
 *         / \
 *        5   1
 *        The path sum is (3 + 5) + (3 + 1) = 12.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [113, 221]
 *      Output: 4
 *      Explanation:
 *        The tree that the list represents is:
 *          3
 *           \
 *            1
 *        The path sum is 3 + 1 = 4.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-path-sum-iv/description
 * @date   2019-07-11 18:38:03
 */
public class L_0863_Binary_Tree_Path_Sum_IV {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
