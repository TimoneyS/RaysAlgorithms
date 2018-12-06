package com.ray.LintCode.resolved;

import java.util.Stack;

import com.ray.io.Out;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * 
 * 给定两个节点，寻找最近的共同父辈。
 * 
 * @author rays1
 *
 */
public class L_0088_Lowest_Common_Ancestor_of_a_Binary_Tree {

    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    /**
     * 将每个节点的搜索结果作为路径，如果找不到则没有路径
     * 寻找路径上最后一个相同的节点即可
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        /*
         * @param root: The root of the binary search tree.
         * @param A: A TreeNode in a Binary.
         * @param B: A TreeNode in a Binary.
         * @return: Return the least common ancestor(LCA) of the two nodes.
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
            
            Stack<TreeNode> sa = new Stack<TreeNode>();
            Stack<TreeNode> sb = new Stack<TreeNode>();
            
            nodePath(root, A, sa);
            nodePath(root, B, sb);
            
            TreeNode rs = null;
            while (!sa.isEmpty() && !sb.isEmpty()) {
                if (sa.peek().val == sb.peek().val) {
                    rs = sa.pop();
                    sb.pop();
                } else {
                    break;
                }
            }
            
            return rs;
        }
        
        public boolean nodePath(TreeNode n, TreeNode tar, Stack<TreeNode> stack) {
            if (n == null) return false;
            if (n.val ==  tar.val || nodePath(n.right, tar, stack) || nodePath(n.left, tar, stack)) {
                stack.push(n);
                return true;
            } else {
                return false;
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(-2);
        
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(3);
        
        Out.p(new Solution().lowestCommonAncestor(root, A, B).val);
        
        
    }

}
