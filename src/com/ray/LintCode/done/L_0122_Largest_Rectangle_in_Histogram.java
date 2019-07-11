package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Given *n* non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 一组宽度为 1 的长方形并列排放，高度为 arr[0] .. arr[n-1]，求可能的最大的长方形面积
 *          _
 *        _|_|
 *       |/|/|
 *       |/|/|  _
 *    _  |/|/|_| | 
 *   | |_|/|/| | | 
 * __|_|_|/|/|_|_|__
 *    2 1 5 6 2 3 
 * 如长方形高度为 [2, 1, 5, 6, 2, 3] 最大面积为 10
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[2,1,5,6,2,3]
 *      Output：10
 *      Explanation：
 *      The third and fourth rectangular truncated rectangle has an area of 2*5=10.
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：[1,1]
 *      Output：2
 *      Explanation：
 *      The first and second rectangular truncated rectangle has an area of 2*1=2.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/largest-rectangle-in-histogram/description
 * @date   2019-07-11 18:30:51
 */
public class L_0122_Largest_Rectangle_in_Histogram {

    static class SolutionT {
        public int largestRectangleArea(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            
            Stack<Integer> stack = new Stack<Integer>();
            int max = 0;
            for (int i = 0; i <= height.length; i++) {
                int curt = (i == height.length) ? -1 : height[i];
                while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                    int h = height[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, h * w);
                }
                stack.push(i);
            }
            
            return max;
        }
    }
    
    static class Solution {
        
        class Node {
            int c;
            int h;
            Node next;
        }
        
        public int largestRectangleArea(int[] heights) {
            return lra(heights);
        }
        
        public int lra(int[] heights) {
            
            int max = 0;
            Node pile = new Node();
            pile.h = -1;
            
            for (int i = 0; i < heights.length; i++) {
                
                Node node = pile.next;
                Node prev = pile;
                int h = heights[i];
                while (node != null && node.h <= h) {
                    node.c += 1;
                    max = Math.max(max, node.c*node.h);
                    prev = node;
                    node = node.next;
                }
                
                if (prev.h != h) {
                    if (node == null)
                        node = new Node();
                    node.c += 1;
                    node.h = h;
                    max = Math.max(max, node.c*node.h);
                    node.next = null;
                    prev.next = node;
                } else {
                    prev.next = null;
                }
                
                Out.p("h = " + h + " prev.h = " + prev.h);
                show (pile);
                Out.sep();
                
            }
            
            return max;
        }
        
        static void show(Node n) {
            
            while (n.next != null) {
                Out.pf("[%s,%s] -> ", n.h, n.c);
                n = n.next;
            }
            Out.pf("[%s,%s]\n", n.h, n.c);
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] heights = {6,2};
        
        Out.p(new SolutionT().largestRectangleArea(heights));
    }

}
