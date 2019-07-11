package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *      
 *      If two nodes are in the same row and column, the order should be from **left to right**.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Inpurt:  {3,9,20,#,#,15,7}
 *      Output: [[9],[3,15],[20],[7]]
 *      Explanation:
 *         3
 *        /\
 *       /  \
 *       9  20
 *          /\
 *         /  \
 *        15   7
 *      ```
 *      **Example2**
 *      ```
 *      Input: {3,9,8,4,0,1,7}
 *      Output: [[4],[9],[3,0,1],[8],[7]]
 *      Explanation:
 *           3
 *          /\
 *         /  \
 *         9   8
 *        /\  /\
 *       /  \/  \
 *       4  01   7
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-vertical-order-traversal/description
 * @date   2019-07-11 18:34:49
 */
public class L_0651_Binary_Tree_Vertical_Order_Traversal {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
