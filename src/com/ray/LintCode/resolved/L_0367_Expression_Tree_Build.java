package com.ray.LintCode.resolved;

import java.util.Stack;

import com.ray.LintCode.util.ExpressionTreeNode;

/**
 * 表达式树是用于计算实际的表达式的一种二叉树结构。
 * 所有的叶子结点都是数字，所有的非叶子结点的值都是操作符
 * 根据表达式，构建表达式数
 * 
 * 对于表达式  ( 2 * 6 - ( 23 + 7 ) / ( 1 + 2 ) ) 可以分解为
 * 构成的树如下
 *         -
 *     /        \
 *    *          /
 *   / \       /   \
 *  2   6     +     +
 *           / \   / \
 *          23  7 1   2
 *
 * @author rays1
 *
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
