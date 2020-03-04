package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.Node;

/**
 * Populating Next Right Pointers in Each Node
 * -----------------------------------------------------------------------------
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Follow up:
 * 	You may only use constant extra space.
 * 	Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 * Example:
 *      Example 1
 *      Input: root = [1,2,3,4,5,6,7]
 *      Output: [1,#,2,3,#,4,5,6,7,#]
 *      Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *      Constraints:
 *      	The number of nodes in the given tree is less than 4096.
 *      	-1000 <= node.val <= 1000
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @since   2020-03-04 21:50:05
 */
public class L0116_Populating_Next_Right_Pointers_in_Each_Node {
    /**
     * 就是二叉树多一个结点，这个结点指向其同一层级的右侧的结点。
     * 常规的考虑是用bfs，拿到同一层的所有结点，然后一次链接。
     * 但是这个题目中，需要注意的是我们已经建立了同级链接的话，这个链接是可以利用的
     *        1
     *     /    \
     *    2  ->  3
     *  /  \    /  \
     * 4 -> 5->6 -> 7
     *
     * 如图，我们利用 1 可以建立 2 和 3 的链接
     *  n.left.next = n.right
     * 同理 利用 2 可以建立 4 5个链接，3可以建立 6 7的链接
     *
     * 而利用2 3，我们可以建立4 5的链接
     * n.right.next = n.next.left
     */
    static class Solution {
        public Node connect(Node root) {
            if (root == null || root.left == null) {
                return root;
            }
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.right);
            connect(root.left);
            return root;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
