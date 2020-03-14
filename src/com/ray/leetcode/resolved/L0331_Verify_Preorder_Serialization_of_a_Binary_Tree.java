package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Verify Preorder Serialization of a Binary Tree
 * -----------------------------------------------------------------------------
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string 9,3,4,#,#,1,#,#,2,#,6,#,#, where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as 1,,3.
 *
 * Example:
 *      Example 1
 *      Input: 9,3,4,#,#,1,#,#,2,#,6,#,#
 *      Output: true
 *      Example 2
 *      Input: 1,#
 *      Output: false
 *      Example 3
 *      Input: 9,#,#,1
 *      Output: false
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * @since   2020-03-14 13:44:42
 */
public class L0331_Verify_Preorder_Serialization_of_a_Binary_Tree {
    static class Solution {
        public boolean isValidSerialization(String preorder) {
            int slot = 1;
            for (int i = 0; i < preorder.length(); i ++) {
                if (preorder.charAt(i) == '#') {
                    slot --;
                } else if (preorder.charAt(i) != ',') {
                    slot ++;
                    while (i < preorder.length() - 1 && preorder.charAt(i + 1) != ',') i ++;
                }
                if (slot < 0 || slot == 0 && i < preorder.length()-1) return false;
            }
            return slot == 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
