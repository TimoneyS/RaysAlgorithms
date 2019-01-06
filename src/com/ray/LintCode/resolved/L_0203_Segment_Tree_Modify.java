package com.ray.LintCode.resolved;

/**
 * For a Maximum Segment Tree, which each node has an extra value max to store the maximum value in this node's interval.
I* mplement a modify function with three parameter root, index and value to change the node's value with [start, end] = [index, index] to the new given value. Make sure after this change, every node in segment tree still has the max attribute with the correct value.
 *
 * @author rays1
 *
 */
public class L_0203_Segment_Tree_Modify {

    /**
     * 向下寻找，修改了最终结点后，依次更新父结点的值
     * @author rays1
     *
     */
    static class Solution {
        /**
         * @param root: The root of segment tree.
         * @param index: index.
         * @param value: value
         * @return: nothing
         */
        public void modify(SegmentTreeNode root, int index, int value) {
            if (index == root.start && index == root.end) {
                root.max = value;
            } else if (index >= root.start && index <= root.end) {
                int mid = (root.start + root.end)/2;
                if (index <= mid) {
                    modify(root.left, index, value);
                } else {
                    modify(root.right, index, value);
                }
                root.max = Math.max(max(root.right), max(root.left));
            }
        }
        
        public int max(SegmentTreeNode node) {
            return node == null ? 0 : node.max;
        }
        
    }

}
