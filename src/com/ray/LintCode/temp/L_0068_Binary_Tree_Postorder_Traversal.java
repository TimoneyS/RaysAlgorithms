package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;

/**
 * 描述：
 *      <p><span style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 30px;">Given a binary tree, return the&nbsp;</span><i style="box-sizing: border-box; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 30px;">postorder</i><span style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 30px;">&nbsp;traversal of its nodes&#39; values.</span></p>
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：{1,2,3}
 *      Output：[2,3,1]
 *      Explanation:  
 *         1
 *        / \
 *       2   3
 *       it will be serialized {1,2,3}
 *      Post order traversal
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：{1,#,2,3}
 *      Output：[3,2,1]
 *      Explanation:  
 *      1
 *       \
 *        2
 *       /
 *      3
 *      it will be serialized {1,#,2,3}
 *      Post order traversal
 *      ```
 *
 * 挑战：
 *      <p>Can you do it without recursion?</p>
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-postorder-traversal/description
 * @date   2019-07-11 18:29:45
 */
public class L_0068_Binary_Tree_Postorder_Traversal {

    static class Solution {
        /**
         * @param root: A Tree
         * @return: Postorder in ArrayList which contains node values.
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            if (root != null)
                tree(root, rs);
            return rs;
        }
        
        public void tree(TreeNode node, List<Integer> rs) {
            if (node.left != null) tree(node.left, rs);
            if (node.right!= null) tree(node.right, rs);
            rs.add(node.val);
        }
        
    }

}
