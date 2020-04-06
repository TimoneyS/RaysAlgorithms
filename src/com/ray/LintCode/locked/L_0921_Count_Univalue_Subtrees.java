package com.ray.LintCode.locked;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一棵二叉树，统计唯一值子树的数目.
 *      唯一值子树意味着子树的所有节点都具有相同的值.
 *
 * 用例：
 *      **用例1**
 *      
 *      ```
 *      输入:  root = {5,1,5,5,5,#,5}
 *      输出: 4
 *      解释:
 *                    5
 *                   / \
 *                  1   5
 *                 / \   \
 *                5   5   5
 *      ```
 *      
 *      **用例2**
 *      
 *      ```
 *      输入:  root = {1,3,2,4,5,#,6}
 *      输出: 3
 *      解释:
 *                    1
 *                   / \
 *                  3   2
 *                 / \   \
 *                4   5   6
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/count-univalue-subtrees/description
 * @date   2019-07-19 16:38:15
 */
public class L_0921_Count_Univalue_Subtrees {

    /**
     * 遍历即可，一个树是否是唯一树的条件是子树是唯一树且子数和根的值一致，或子树为空
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) return 0;
            return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right) + (isUni(root) ? 1 : 0);
        }
        
        private boolean isUni(TreeNode root) {
            if (root == null) return true;
            return isUni(root.left) &&
                    isUni(root.right) &&
                    (root.right == null ||root.val == root.right.val) &&
                    (root.left == null ||root.val == root.left.val);
        }
    
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,3,2,4,5,#,6}");
        Out.p(new Solution().countUnivalSubtrees(root));
        
    }

}
