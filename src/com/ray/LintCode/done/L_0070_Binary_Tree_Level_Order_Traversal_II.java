package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      <p style="box-sizing: border-box; margin: 0px 0px 10px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 30px;">Given a binary tree, return the&nbsp;<i style="box-sizing: border-box;">bottom-up level order</i>&nbsp;traversal of its nodes&#39; values. (ie, from left to right, level by level from leaf to root).</p>
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      {1,2,3}
 *      Output:
 *      [[2,3],[1]]
 *      Explanation:
 *          1
 *         / \
 *        2   3
 *      it will be serialized {1,2,3}
 *      level order traversal
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *      {3,9,20,#,#,15,7}
 *      Output:
 *      [[15,7],[9,20],[3]]
 *      Explanation:
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 *      it will be serialized {3,9,20,#,#,15,7}
 *      level order traversal
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-level-order-traversal-ii/description
 * @date   2019-07-11 18:29:47
 */
public class L_0070_Binary_Tree_Level_Order_Traversal_II {

static class Solution {
        
        /**
         * @param root: A Tree
         * @return: Level order a list of lists of integer
         */
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> rs = new ArrayList<>();
            if (root != null)
                tree(root, 0, rs);
            return rs;
        }
        
        public void tree(TreeNode node, int level, List<List<Integer>> rs) {
            addToList(node, level, rs);
            if(node.left != null) tree(node.left, level+1, rs);
            if(node.right != null) tree(node.right, level+1, rs);
        }
        
        public void addToList(TreeNode node, int level, List<List<Integer>> rs) {
            List<Integer> list = null;
            if (level >= rs.size()) {
                list = new ArrayList<Integer>();
                rs.add(0, list);
            } else {
                list = rs.get(rs.size() - level - 1);
            }
            list.add(node.val);
        }
        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        Out.p(new Solution().levelOrderBottom(root));
        
    }

}
