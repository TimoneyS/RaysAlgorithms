package com.ray.LintCode.resolved;

import com.ray.LintCode.util.SegmentTreeNode;
import com.ray.io.Out;

/**
 * 区段树构建
 * 
 * 段树是一种二叉树结构，每个结点包含 start 和 end 两个属性，表示一个线段或者区间。
 * start 和 end 都是整数，需要遵循如下规则：
 *      1. 根节点的start和end由构造方法指定
 *      2. 结点 A 的左结点有 start = A.left, end = (A.left + A.right) / 2
 *      3. 结点 A 的右结点有 start = (A.left + A.right) / 2 + 1, end = A.right
 *      4. 如果start == end 结点将没有子结点
 *      
 * 实现构建方法，使用数组来构造一个区段树，区段树的每个结点表示对应的数组的一个范围，结点的值表示该范围内得数组的最大值。
 *
 * @author rays1
 *
 */
public class L_0439_Segment_Tree_Build_II {

    static class Solution {
        
        int[] inner;
        
        public SegmentTreeNode build(int[] A) {
            inner = A;
            return build(0, A.length-1);
        }
        
        public SegmentTreeNode build(int start, int end) {
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start != end) {
                int mid = (start + end) / 2;
                root.left = build(start, mid);
                root.right = build(mid+1, end);
                root.max = Math.max(root.left.max, root.right.max);
            } else {
                root.max = inner[start];
            }
            return root;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
