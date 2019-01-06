package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 一个数组和一系列的区间，返回每个区间内的最小值。
 *
 * @author rays1
 *
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
