package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, find its minimum depth.
 *      
 *      The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {}
 *      Output: 0
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  {1,#,2,3}
 *      Output: 3	
 *      Explanation:
 *      	1
 *      	 \ 
 *      	  2
 *      	 /
 *      	3    
 *      it will be serialized {1,#,2,3}
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input:  {1,2,3,#,#,4,5}
 *      Output: 2	
 *      Explanation: 
 *            1
 *           / \ 
 *          2   3
 *             / \
 *            4   5  
 *      it will be serialized {1,2,3,#,#,4,5}
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-depth-of-binary-tree/description
 * @date   2019-07-11 18:31:18
 */
public class L_0155_Minimum_Depth_of_Binary_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
