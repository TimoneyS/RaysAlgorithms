package com.ray.leetcode.util;

import com.ray.io.Out;
import com.ray.util.StringUtil;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.ray.io.Out.p;

public class TreeNode {
    
    public int      val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
    
    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        
        TreeNode dummy = new TreeNode(0);
        StringBuilder sb = new StringBuilder("{");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.equals(dummy)) {
                sb.append('#');
            } else {
                queue.add(node.left  == null ? dummy : node.left);
                queue.add(node.right == null ? dummy : node.right);
                sb.append(node.val);
            }
            sb.append(",");
        }
        
        while (sb.charAt(sb.length()-2) == '#') {
            sb.setLength(sb.length()-2);
        }
        
        if (sb.charAt(sb.length()-1) == ',') {
            sb.setCharAt(sb.length()-1, '}');
        } else {
            sb.append('}');
        }
            
        return sb.toString();
    }

    public static TreeNode parse(String data) {
        data = data.trim();
        String[] dataArr = data.substring(1, data.length()- 1).split(",");
        TreeNode pile = new TreeNode(0);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pile);
        
        boolean isLeft = false;
        for (String val : dataArr) {
            if (!val.equals("#")) {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                if (isLeft) {
                    node = queue.peek().left = node;
                } else {
                    node = queue.peek().right = node;
                }
                queue.add(node);
            }
            if (!isLeft) {
                queue.poll();
            }
            isLeft = !isLeft;
        }
        return pile.right;
    }
    
    public void show() {
        TreeNode.show(this);
    }
    
    public static void show(TreeNode root) {
        p("== tree ===========================");
        if (root != null) tree(root, 0, 1);
        p("===================================");
    }

    public static void tree(TreeNode node, int type, int deepth) {
        if(node == null) return;
        tree(node.right, 1, deepth+1);
        String suffix = StringUtil.multiString(' ', deepth * 5);
        if (type == 0) {
            Out.pf("%s--[%s]\n", suffix, node.val);
        } else if (type > 0) {
            Out.pf("%s /[%s]\n", suffix, node.val);
        } else {
            Out.pf("%s \\[%s]\n", suffix, node.val);
        }
        tree(node.left, -1, deepth+1);
    }
    
    @Override
    public String toString() {
        return val+"";
    }
    
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,2,3,#,4,5,6,7,8}");
        
        TreeNode.show(root);
        
        
    }
    
}
