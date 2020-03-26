package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Serialize and Deserialize BST
 * -----------------------------------------------------------------------------
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * The encoded string should be as compact as possible.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 * @since   2020-03-27 00:12:34
 */
public class L0449_Serialize_and_Deserialize_BST {
    /**
     * 序列化的顺序是对树的BFS搜索
     *      首先被序列化的是根结点
     *      然后是根结点的左结点，根节点的右结点
     *      按照层级，从左向右，从上到下依次将结点写入字符串即可。
     *
     * 反序列话的顺序和序列话一致
     *      首先读取的是根节点
     *      然后是根结点的左结点，根节点的右结点
     *      按照层级，从左向右，从上到下依次将字符串生成结点即可。
     */
    public class Codec {
        public String serialize(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            if (root != null) queue.add(root);

            TreeNode dummy = new TreeNode(0);
            StringBuilder sb = new StringBuilder("{");
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.equals(dummy)) {
                    sb.append('#');
                } else {
                    queue.add(node.left  == null ? dummy : node.left);
                    queue.add(node.right == null ? dummy : node.right);
                    sb.append(node.val);
                }
                sb.append(",");
            }

            while (sb.length() > 2 && sb.charAt(sb.length()-2) == '#') {
                sb.setLength(sb.length()-2);
            }

            if (sb.charAt(sb.length()-1) == ',') {
                sb.setCharAt(sb.length()-1, '}');
            } else {
                sb.append('}');
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.trim();
            String[] dataArr = data.substring(1, data.length()- 1).split(",");
            TreeNode pile = new TreeNode(0);
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(pile);

            boolean isLeft = false;
            for (String val : dataArr) {

                if (val.equals("")) continue;

                if (!val.equals("#")) {
                    TreeNode node = new TreeNode(Integer.parseInt(val));
                    if (isLeft) {
                        node = queue.peek().left = node;
                    } else {
                        node = queue.peek().right = node;
                    }
                    queue.add(node);
                }
                if (!isLeft) {
                    queue.poll();
                }
                isLeft = !isLeft;
            }
            return pile.right;
        }
    }
    
    public static void main(String[] args) {
    }
}
