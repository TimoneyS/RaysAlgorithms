package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 *
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * @author rays1
 * @url    https://www.lintcode.com/problem/closest-binary-search-tree-value-ii/
 * @date   2019-04-12 11:17:22
 */
public class L_0901_Closest_Binary_Search_Tree_Value_II {

    /**
     * 二叉搜索树的许多方法，都可以用有序数组的算法来理解。
     * 
     * 这里可以先想如何在有序数组中，找到 k 个最接近 target 的数字。
     * 暴力算法就是遍历数组，然后依次保留 k 个数字，复杂度为O(n)，而遍历数组等效于在BST中的中序遍历。
     * 
     * 因为是有序数组，那么可以利用这个有序信息来节省操作，使用二分的思想可以将复杂度将到指数级别。
     * 
     * @author rays1
     *
     */
    static class Solution {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> values = new ArrayList<>();
            
            traverse(root, values);
            
            int i = 0, n = values.size();
            for (; i < n; i++) {
                if (values.get(i) >= target) {
                    break;
                }
            }
            
            if (i >= n) {
                return values.subList(n - k, n);
            }
            
            int left = i - 1, right = i;
            List<Integer> result = new ArrayList<>();
            for (i = 0; i < k; i++) {
                if (left >= 0 && (right >= n || target - values.get(left) < values.get(right) - target)) {
                    result.add(values.get(left));
                    left--;
                } else {
                    result.add(values.get(right));
                    right++;
                }
            }
            
            return result;
        }
        
        private void traverse(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }
            
            traverse(root.left, values);
            values.add(root.val);
            traverse(root.right, values);
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
