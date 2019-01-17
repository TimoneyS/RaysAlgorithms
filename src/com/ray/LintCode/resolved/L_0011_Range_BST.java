package com.ray.LintCode.resolved;

import java.util.LinkedList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * Given a binary search tree and a range [k1, k2], return all elements in the given range.
 * <p>
 * Example
 * <p>
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 *      20
 *     /  \
 *    8   22
 *   / \
 *  4   12
 * @author rays1
 *
 */
public class L_0011_Range_BST {
    
    static class Solution {
        /**
         * @param root: param root: The root of the binary search tree
         * @param k1: An integer
         * @param k2: An integer
         * @return: return: Return all keys that k1<=key<=k2 in ascending order
         */
        public List<Integer> searchRange(TreeNode root, int k1, int k2) {
            List<Integer> list = new LinkedList<Integer>();
            
            searchRange(root, list, k1, k2);
            
            return list;
        }
        
        public void searchRange(TreeNode root, List<Integer> list, int l, int h) {
            if (root == null) return;
            searchRange(root.left, list, l, h);
            if (root.val >= l && root.val <= h) list.add(root.val);
            searchRange(root.right, list, l, h);            
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(20);
        
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);        
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(22);
        
        Out.p(new Solution().searchRange(root, 10, 22));
        
    }
}
