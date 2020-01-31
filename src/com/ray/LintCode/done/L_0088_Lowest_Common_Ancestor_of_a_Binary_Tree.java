package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定二叉树的根和两个结点，寻找两个结点的最低的共同祖先。
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/lowest-common-ancestor-of-a-binary-tree/description
 * @since  2019-07-11 18:30:04
 */
public class L_0088_Lowest_Common_Ancestor_of_a_Binary_Tree {
    /**
     * 将每个节点的搜索结果作为路径，如果找不到则没有路径
     * 寻找路径上最后一个相同的节点即可
     */
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
            Stack<TreeNode> sa = new Stack<>();
            Stack<TreeNode> sb = new Stack<>();
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
        TreeNode root = TreeNode.parse("{-2,1,3,4,5,6,7,8}");
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(8);
        TreeNode.show(root);
        Out.p(new Solution().lowestCommonAncestor(root, A, B).val);
    }
}
