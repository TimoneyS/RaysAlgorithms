package com.ray.LintCode.resolved;

import com.ray.LintCode.util.SegmentTreeNode;

/**
 * For an array, we can build a SegmentTree for it, each node stores an extra attribute count to denote the number of elements in the the array which value is between interval start and end. (The array may not fully filled by elements)
 * Design a query method with three parameters root, start and end, find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.
 *
 *
 * @author rays1
 *
 */
public class L_0247_Segment_Tree_Query_II {

    static class Solution {
        public int query(SegmentTreeNode root, int start, int end) {
            start   = Math.max(root.start, start);
            end     = Math.min(root.end, end);
            if (start > end) return 0;
            if (root.start == start && root.end == end) {
                return root.count;
            } else {
                return query(root.left, start, end) + query(root.right, start, end);
            }
            
        }
    }

}
