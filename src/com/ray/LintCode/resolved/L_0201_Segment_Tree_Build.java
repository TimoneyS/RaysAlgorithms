package com.ray.LintCode.resolved;

import com.ray.LintCode.help.SegmentTreeNode;

/**
 * 段树是一种二叉树结构，没个结点包含start和end两个属性，表示一个段或者区间。
 * start和end 都是整数，规则如下：
 *      根节点的start和end由构造方法指定。
 *      结点A的左结点 start = A.left, end = (A.left + A.right) / 2
 *      结点A的右结点 start=(A.left + A.right) / 2 + 1, end=A.right
 *      如果start == end 结点将没有子结点
 * Implement a build method with two parameters start and end, so that we can create a corresponding segment tree with every node has the correct start and end value, return the root of this segment tree.
 *
 * @author rays1
 *
 */
public class L_0201_Segment_Tree_Build {

    static class Solution {
        public SegmentTreeNode build(int start, int end) {
            if (start > end) return null; 
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start != end) {
                int mid = (start + end) / 2;
                root.left = build(start, mid);
                root.right = build(mid+1, end);                
            }
            return root;
        }
        
    }

}
