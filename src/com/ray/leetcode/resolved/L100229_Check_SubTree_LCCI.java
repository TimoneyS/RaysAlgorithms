package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Check SubTree LCCI
 * -----------------------------------------------------------------------------
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm to determine if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
 *
 * Example:
 *      Example 1
 *       Input: t1 = [1, 2, 3], t2 = [2]
 *       Output: true
 *      Example 2
 *       Input: t1 = [1, null, 2, 4], t2 = [3, 2]
 *       Output: false
 *      Note: 
 *      	The node numbers of both tree are in [0, 20000].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/check-subtree-lcci/
 * @since   2020-04-07 22:10:30
 */
public class L100229_Check_SubTree_LCCI {
    static class Solution {
        public boolean checkSubTree(TreeNode T1, TreeNode T2) {
            if (T1 == null || T2 == null) return T1 == T2;
            if (compare(T1, T2)) return true;
            return checkSubTree(T1.left, T2) || checkSubTree(T1.right, T2);
        }

        private boolean compare(TreeNode t1, TreeNode t2) {
            if (t1 == null || t2 == null) return t2 == t1;
            if (t1.val == t2.val)
                return compare(t1.left, t2.left) && compare(t1.right, t2.right);
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
