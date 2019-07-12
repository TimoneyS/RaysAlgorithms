package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, find the length of the longest consecutive sequence path.
 *      
 *      The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (`cannot be the reverse`).
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *         1
 *          \
 *           3
 *          / \
 *         2   4
 *              \
 *               5
 *      Output:3
 *      Explanation:
 *      Longest consecutive sequence path is 3-4-5, so return 3.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:
 *         2
 *          \
 *           3
 *          / 
 *         2    
 *        / 
 *       1
 *      Output:2
 *      Explanation:
 *      Longest consecutive sequence path is 2-3,not 3-2-1, so return 2.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-longest-consecutive-sequence/description
 * @date   2019-07-11 18:34:22
 */
public class L_0595_Binary_Tree_Longest_Consecutive_Sequence {

    /**
     * 每个结点统计一个值：从上延申来的长度
     * 
     * 全局最大长度 = max { 每个结点从上延申来的长度 }
     * 
     * @author rays1
     *
     */
    static class Solution {
        public int longestConsecutive(TreeNode root) {
            return helper(root, null, 0);
        }
        
        private int helper(TreeNode root, TreeNode parent, int maxLength) {
            if (root == null)  return 0;
            int length = (parent != null && parent.val + 1 == root.val) ? maxLength + 1 : 1;
            int left  = helper(root.left, root, length);
            int right = helper(root.right, root, length);
            return Math.max(length, Math.max(left, right));
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,#,2,#,4,#,5,#,6}");
        
        Out.p(new Solution().longestConsecutive(root));
        
    }

}
