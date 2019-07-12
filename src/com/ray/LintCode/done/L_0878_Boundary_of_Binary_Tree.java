package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, return the values of its boundary in **anti-clockwise** direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 *      
 *      **Left boundary** is defined as the path from root to the **left-most** node. **Right boundary** is defined as the path from root to the **right-most** node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
 *      
 *      The **left-most** node is defined as a **leaf** node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 *      
 *      The **right-most** node is also defined by the same way with left and right exchanged.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {1,#,2,3,4}
 *      Output: [1,3,4,2]
 *      Explanation: 
 *        1
 *         \
 *          2
 *         / \
 *        3   4
 *        The root doesn't have left subtree, so the root itself is left boundary.
 *        The leaves are node 3 and 4.
 *        The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 *        So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: {1,2,3,4,5,6,#,#,#,7,8,9,10}
 *      Output: [1,2,4,7,8,9,10,6,3]
 *      Explanation: 
 *                1
 *           /          \
 *          2            3
 *         / \          / 
 *        4   5        6   
 *           / \      / \
 *          7   8    9  10  
 *        The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 *        The leaves are node 4,7,8,9,10.
 *        The right boundary are node 1,3,6,10. (10 is the right-most node).
 *        So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/boundary-of-binary-tree/description
 * @date   2019-07-11 18:38:14
 */
public class L_0878_Boundary_of_Binary_Tree {


    /**
     * 递归前先判断下一个递归的结点是左边界还是右边界
     * 左边界使用尾递归，而右边界使用首递归
     * @author rays1
     *
     */
    static class Solution {
    
        List<Integer> rs;
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            rs = new ArrayList<>();
            if (root == null) return rs;
            rs.add(root.val);
            dfs(root.left, true, false);
            dfs(root.right, false, true);            
            return rs;
        }
        
        void dfs(TreeNode node, boolean l, boolean r) {
            if (node == null) return;
            if (node.left == null && node.right == null) {
                rs.add(node.val);
            } else {
                if (l) rs.add(node.val);
                dfs(node.left, l, node.right == null & r);
                dfs(node.right, node.left == null & l, r);
                if (r) rs.add(node.val);
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
