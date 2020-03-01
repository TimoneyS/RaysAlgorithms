package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 *      Example 1
 *      Input: [2,1,5,6,2,3]
 *      Output: 10
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @since   2020-03-01 22:59:09
 */
public class L0084_Largest_Rectangle_in_Histogram {
    static class Solution {
        public int largestRectangleArea(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
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

    static class Solution2 {

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
        Out.p(new Solution());
    }
}
