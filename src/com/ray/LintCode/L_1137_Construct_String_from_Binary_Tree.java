package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 *   
 *   The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 * Example :
 *   **Example 1:**
 *   ~~~~.
 *   Input: Binary tree: [1,2,3,4]
 *          1
 *        /   \
 *       2     3
 *      /    
 *     4     
 *   
 *   Output: "1(2(4))(3)"
 *   
 *   Explanation: Originallay it needs to be "1(2(4)())(3()())", 
 *   but you need to omit all the unnecessary empty parenthesis pairs. 
 *   And it will be "1(2(4))(3)".
 *   ~~~~
 *   **Example 2:**
 *   ~~~~.
 *   Input: Binary tree: [1,2,3,null,4]
 *          1
 *        /   \
 *       2     3
 *        \  
 *         4 
 *   
 *   Output: "1(2()(4))(3)"
 *   
 *   Explanation: Almost the same as the first example, 
 *   except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 *   ~~~~
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/construct-string-from-binary-tree/description
 * @date   2019-07-03 17:39:34
 */
public class L_1137_Construct_String_from_Binary_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
