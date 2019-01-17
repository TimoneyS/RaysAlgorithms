package com.ray.LintCode.resolved;

import com.ray.LintCode.util.SegmentTreeNode;

/**
 * For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding SegmentTree, each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).
 *
 * Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.
 *
 * @author rays1
 *
 */
public class L_0202_Segment_Tree_Query {

    /**
     * 首先对区间取交集，交集后如果区间和结点区间相等，则返回max，否则分别在左右结点中继续搜索
     * @author rays1
     *
     */
    static class Solution {
        /**
         * @param root: The root of segment tree.
         * @param start: start value.
         * @param end: end value.
         * @return: The maximum number in the interval [start, end]
         */
        public int query(SegmentTreeNode root, int start, int end) {
            start   = Math.max(root.start, start);
            end     = Math.min(root.end, end);
            if (start > end) return 0;
            if (root.start == start && root.end == end) {
                return root.max;
            } else {
                return Math.max(
                        query(root.left, start, end),
                        query(root.right, start, end));
            }
            
        }
    }
    
}
