package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.LintCode.util.ExpressionTreeNode;

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


    /**
     * 每个数字、操作符都有一个权重，括号内的操作符比括号外大的。
     * 如果按照权重对元素进行下沉的操作，那么所有的数字都沉到最底部，操作符权重大的沉的相对较深
     * 权重最轻的结点则成为根结点，权重相同的操作符，按照先出现的较大
     * 
     * 因此栈中的结点的权重是单调递增的
     * @author rays1
     *
     */
    static public class Solution {
        
        public ExpressionTreeNode build(String[] expression) {
            if (expression == null || expression.length == 0) return null;
            
            Stack<ExpressionTreeNode> nodeStack = new Stack<ExpressionTreeNode>();
            Stack<Integer>            deepStack = new Stack<>();
            
            int base = 0;
            for (String val : expression) {
                
                if (val.equals("(")) {base += 2; continue;}
                if (val.equals(")")) {base -= 2; continue;}
                
                int deep = deep(base, val);
                ExpressionTreeNode node = new ExpressionTreeNode(val);
                
                // 栈中的元素是单调递增的
                while (!deepStack.isEmpty() && deepStack.peek() >= deep) {
                    node.left = nodeStack.pop();
                    deepStack.pop();
                }
                
                if (!nodeStack.isEmpty()) nodeStack.peek().right = node;
                nodeStack.push(node);
                deepStack.push(deep);
                
            }
            
            ExpressionTreeNode rs = null;
            while (!nodeStack.isEmpty()) rs = nodeStack.pop();
            
            return rs;
        }
        
        // 权重，数字的权重最高，操作符的权重 乘除 大于 加减
        public int deep(int base, String s) {
            if (s.equals("+") || s.equals("-")) return base;
            if (s.equals("*") || s.equals("/")) return base + 1;
            return Integer.MAX_VALUE;
        }
        
    }
    
    public static void main(String[] args) {
        
        String[] expression = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
        
        ExpressionTreeNode root = new Solution().build(expression);
        
        root.show();
    }

}
