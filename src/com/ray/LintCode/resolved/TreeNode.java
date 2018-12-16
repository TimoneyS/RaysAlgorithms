package com.ray.LintCode.resolved;

import static com.ray.io.Out.p;

import java.util.LinkedList;

import com.ray.io.Out;
import com.ray.util.StringUtil;

public class TreeNode {
    public int      val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
    
    public static String serialize(TreeNode root) {
        // write your code here
        if (root == null) return "{}";
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        TreeNode emptyNode = new TreeNode(-1);
        
        StringBuilder sb = new StringBuilder("{");
        while (!queue.isEmpty()) {
            
            TreeNode node = queue.poll();
            
            if (node.val == -1) {
                sb.append('#');
            } else {
                if (node.left == null)
                    queue.add(emptyNode);
                else
                    queue.add(node.left);
                
                if (node.right == null)
                    queue.add(emptyNode);
                else
                    queue.add(node.right);
                
                sb.append(node.val);
            }
                
            sb.append(",");
        }
        
        while (sb.charAt(sb.length()-2) == '#') {
            sb.setLength(sb.length()-2);
        }
        sb.setCharAt(sb.length()-1, '}');
            
        return sb.toString();
       
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public static TreeNode parse(String data) {
        // write your code here
        if (data.equals("{}"))  return null;
        
        String[] dataArr = data.substring(1, data.length()- 1).split(",");
        
        TreeNode root = new TreeNode(Integer.valueOf(dataArr[0]));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        boolean isLeft = true;
        for (int i = 1; i < dataArr.length; i++) {
            
            TreeNode node = null;
            TreeNode childNode = null;
            
            if (!dataArr[i].equals("#"))
                childNode = new TreeNode(Integer.valueOf(dataArr[i]));
            if (isLeft) {
                node = queue.peek();
                node.left = childNode;
            } else {
                node = queue.poll();
                node.right = childNode;
            }
            if (childNode != null)
                queue.add(childNode);
            
            isLeft = !isLeft;
        }
        return root;
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
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,2,3,#,4,5,6,7,8}");
        
        TreeNode.show(root);
        
        
    }
    
}
