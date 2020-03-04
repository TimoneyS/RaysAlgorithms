package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.Node;

/**
 * Populating Next Right Pointers in Each Node II
 * -----------------------------------------------------------------------------
 * Given a binary tree
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
 *      Input: root = [1,2,3,4,5,null,7]
 *      Output: [1,#,2,3,#,4,5,7,#]
 *      Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *      Constraints:
 *      	The number of nodes in the given tree is less than 6000.
 *      	-100 <= node.val <= 100
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @since   2020-03-04 21:51:40
 */
public class L0117_Populating_Next_Right_Pointers_in_Each_Node_II {
    /**
     * 这里在链接是需要考虑众多的异常场景
     */
    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null) {
                root.left.next = root.right;
            }

            Node nextNode = root.next;

            while (nextNode != null && nextNode.left == null && nextNode.right == null) {
                nextNode = nextNode.next;
            }

            if (nextNode != null) {
                Node l = root.right == null ? root.left : root.right;
                Node r = nextNode.left == null ? nextNode.right : nextNode.left;
                if (l != null) {
                    l.next = r;
                }
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
