package com.ray.LintCode.resolved;

import static com.ray.io.Out.p;

import com.ray.io.Out;
import com.ray.util.StringUtil;

public class SegmentTreeNode {
    public int start, end, max, count;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.count = max;
        this.left = this.right = null;
    }
    
    public static void show(SegmentTreeNode root) {
        p("== tree ===========================");
        if (root != null) tree(root, 0, 1);
        p("===================================");
    }

    public static void tree(SegmentTreeNode node, int type, int deepth) {
        if(node == null) return;
        tree(node.right, 1, deepth+1);
        String suffix = StringUtil.multiString(' ', deepth * 5);
        if (type == 0) {
            Out.pf("%s--[%s-%s](%s,%s)\n", suffix, node.start, node.end, node.count, node.max);
        } else if (type > 0) {
            Out.pf("%s /[%s-%s](%s,%s)\n", suffix, node.start, node.end, node.count, node.max);
        } else {
            Out.pf("%s \\[%s-%s](%s,%s)\n", suffix, node.start, node.end, node.count, node.max);
        }
        tree(node.left, -1, deepth+1);
    }
    
}