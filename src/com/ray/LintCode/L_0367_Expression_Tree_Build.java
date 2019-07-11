package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      The structure of Expression Tree is a binary tree to evaluate certain expressions.
 *      All leaves of the Expression Tree have an number string value. All non-leaves of the Expression Tree have an operator string value.
 *      
 *      Now, given an expression array, build the expression tree of this expression, return the root of this expression tree.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: ["2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"]
 *      Output: {[-],[*],[/],[2],[6],[+],[+],#,#,#,#,[23],[7],[1],[2]}
 *      Explanation:
 *      The expression tree will be like
 *      
 *      	                 [ - ]
 *      	             /          \
 *      	        [ * ]              [ / ]
 *      	      /     \           /         \
 *      	    [ 2 ]  [ 6 ]      [ + ]        [ + ]
 *      	                     /    \       /      \
 *      	                   [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
 *      
 *      After building the tree, you just need to return root node `[-]`. 
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: ["10","+","(","3","-","5",")","+","7","*","7","-","2"]
 *      Output: {[-],[+],[2],[+],[*],#,#,[10],[-],[7],[7],#,#,[3],[5]} 
 *      Explanation:
 *      The expression tree will be like
 *       	                       [ - ]
 *      	                   /          \
 *      	               [ + ]          [ 2 ]
 *      	           /          \      
 *      	       [ + ]          [ * ]
 *                    /     \         /     \
 *      	  [ 10 ]  [ - ]    [ 7 ]   [ 7 ]
 *      	          /    \ 
 *                      [3]    [5]
 *      After building the tree, you just need to return root node `[-]`.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/expression-tree-build/description
 * @date   2019-07-11 18:32:12
 */
public class L_0367_Expression_Tree_Build {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
