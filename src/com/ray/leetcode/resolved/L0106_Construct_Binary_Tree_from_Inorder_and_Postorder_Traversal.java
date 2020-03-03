package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * -----------------------------------------------------------------------------
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @since   2020-03-03 23:28:03
 */
public class L0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    /**
     * 给定树的前序和后序遍历，构造树结构
     *
     * 前序是 中 -> 左 -> 右
     * 后序是 左 -> 右 -> 中
     *
     * 观察二叉树：
     *          1
     *         / \
     *        2   3
     *       / \   \
     *      4   5   6
     * 遍历的结果如下：
     *      前序：1 2 4 5 3 6
     *      后序：4 5 2 6 3 1
     * ----------------------------------
     * 去掉根节点 1 后，遍历的结果如下：
     *      前序：    2 4 5 3 6
     *      后序：4 5 2 6 3
     *
     * 这两个遍历顺序整体都是 [左子树元素][右子树元素]，我们需要确定每个子树元素的范围
     * 前序遍历，子树根元素在最前，后序遍历子树根元素在最后，即：
     *      前序：                          [根 左子树其他元素][根 右子树其他元素]
     *      后序：[左子树其他元素 根][右子树其他元素 根]
     *
     * 我们只要找到同一个根在两个数组中的位置，就可以分割数组，然后递归的处理子树。比如这里，我们可以找到：
     *      前序：        [2 4 5][3 6]
     *      后序：[4 5 2][6 3]
     * 然后递归处理即可。
     */
    static class Solution {

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0) return null;
            return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        }

        public TreeNode buildTree(int[] inorder, int[] postorder, int l1, int r1, int l2, int r2) {
            if (r2 < l2 || r1 < l1) return null;
            TreeNode node = new TreeNode(postorder[r2]);
            if (r2 == l2) return node;
            int i = l1;
            while (i <= r1) {
                if (inorder[i] == postorder[r2])
                    break;
                i++;
            }
            node.left  = buildTree(inorder, postorder, l1, i - 1, l2, l2 + i - l1 - 1);
            node.right = buildTree(inorder, postorder, i + 1, r1, r2 - r1 + i, r2 - 1);

            return node;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
