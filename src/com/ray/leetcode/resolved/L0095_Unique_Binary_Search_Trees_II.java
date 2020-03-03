package com.ray.leetcode.resolved;

import com.ray.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 * -----------------------------------------------------------------------------
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *      Input: 3
 *      Output:
 *      [
 *        [1,null,3,2],
 *        [3,2,null,1],
 *        [3,1,null,null,2],
 *        [2,1,3],
 *        [1,null,2,null,3]
 *      ]
 *      Explanation:
 *      The above output corresponds to the 5 unique BST's shown below:
 *         1         3     3      2      1
 *          \       /     /      / \      \
 *           3     2     1      1   3      2
 *          /     /       \                 \
 *         2     1         2                 3
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @since   2020-03-03 22:35:41
 */
public class L0095_Unique_Binary_Search_Trees_II {
    /**
     * 二叉搜索数的特点是，结点左侧的元素小于根结点，右侧的元素都大于根节点
     * 所以如果 1 到 n 的数字中，如果以 k 为根
     * 那么左侧的元素必然是 1..k-1
     *     右侧的元素必然是 k+1..n
     *
     * 那么显然 rs(1..n) = { rs(1..k-1) + rs(k+1..n) } (k = 1..n)
     *
     */
    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            return helper(1, n, new List[n+2][n+2]);
        }

        public List<TreeNode> helper(int s, int t, List<TreeNode>[][] mem) {
            List<TreeNode> rs = new ArrayList<>();
            if (mem[s][t] == null) {
                if (s > t) {
                    rs.add(null);
                } else if (s == t) {
                    rs.add(new TreeNode(s));
                } else {
                    for (int i = s;i <= t; i++) {
                        for (TreeNode l : helper(s, i-1, mem)) {
                            for (TreeNode r : helper(i+1, t, mem)) {
                                TreeNode root = new TreeNode(i);
                                root.left = l;
                                root.right = r;
                                rs.add(root);
                            }
                        }
                    }
                }
                mem[s][t] = rs;
            }
            return mem[s][t];
        }
    }
    
    public static void main(String[] args) {
        int n = 3;
        Solution sol = new Solution();
        List<TreeNode> rs = sol.generateTrees(n);
        rs.forEach(t -> t.show());
    }
}
