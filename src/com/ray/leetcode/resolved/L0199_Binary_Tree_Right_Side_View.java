package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View
 * -----------------------------------------------------------------------------
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3,null,5,null,4]
 *      Output: [1, 3, 4]
 *      Explanation:
 *         1            <---
 *       /   \
 *      2     3         <---
 *       \     \
 *        5     4       <---
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @since   2020-03-08 21:50:04
 */
public class L0199_Binary_Tree_Right_Side_View {
    /**
     * 前序遍历数，中 -> 左 -> 右
     * 将每个层级的结点加入列表，后加入的覆盖先加入的即可。
     *
     * 或者按照 中 -> 右  -> 左， 每次只添加层级大于列表长度的元素。
     */
    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            heler(root, 0, rs);
            return rs;
        }

        public void heler(TreeNode node, int level, List<Integer> rs) {
            if (node == null) return;
            if (rs.size() <= level) {
                rs.add(node.val);
            }
            heler(node.right, level+1, rs);
            heler(node.left, level+1, rs);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
