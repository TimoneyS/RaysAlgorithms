package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.LintCode.util.SegmentTreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers `[start, end]`. For each query, calculate the minimum number between index start and end in the given array, return the result list.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : array: [1,2,7,8,5], queries :[(1,2),(0,4),(2,4)] .Output: [2,1,5]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : array: [4,5,7,1], queries :[(1,2),(1,3)]. Output: [5,1]
 *      ```
 *
 * 挑战：
 *      O(logN) time for each query
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/interval-minimum-number/description
 * @date   2019-07-11 18:31:55
 */
public class L_0205_Interval_Minimum_Number {

    static class Solution {
        private SegmentTreeNode buildMin(int[] A, int start, int end) {
            if (start > end) return null; 
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if (start != end) {
                int mid = (start + end) / 2;
                node.left = buildMin(A, start, mid);
                node.right = buildMin(A, mid+1, end);
                node.max = Math.min(node.right.max, node.left.max);
            } else {
                node.max = A[start];
            }
            return node;
        }
        
        private int query(SegmentTreeNode root, int start, int end) {
            start   = Math.max(root.start, start);
            end     = Math.min(root.end, end);
            if (start > end) return Integer.MAX_VALUE;
            if (root.start == start && root.end == end) {
                return root.max;
            } else {
                return Math.min(
                        query(root.left, start, end),
                        query(root.right, start, end));
            }
            
        }
        
        public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
            SegmentTreeNode root = buildMin(A, 0, A.length-1);
            SegmentTreeNode.show(root);
            
            List<Integer> rs = new ArrayList<Integer>();
            for (Interval interval : queries) {
                rs.add(query(root, interval.start, interval.end));
            }
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[][] intervals = {
                {0,6},
                {2,3},
                {3,5}
        };
        int[] A = {1,2,3,4,5,6,7};
        List<Interval> queries = new ArrayList<>();
        
        for (int[] intv : intervals) {
            queries.add(new Interval(intv[0], intv[1]));
        }
        
        Out.p(new Solution().intervalMinNumber(A, queries));
        
    }

}
