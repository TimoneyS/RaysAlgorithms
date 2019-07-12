package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Check if two binary trees are identical. Identical means the two binary trees have the same structure and every identical position has the same value.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:{1,2,2,4},{1,2,2,4}
 *      Output:true
 *      Explanation:
 *              1                   1
 *             / \                 / \
 *            2   2   and         2   2
 *           /                   /
 *          4                   4
 *      
 *      are identical.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:{1,2,3,4},{1,2,3,#,4}
 *      Output:false
 *      Explanation:
 *      
 *              1                  1
 *             / \                / \
 *            2   3   and        2   3
 *           /                        \
 *          4                          4
 *      
 *      are not identical.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/same-tree/description
 * @date   2019-07-11 18:33:23
 */
public class L_0469_Same_Tree {


    /**
     * 先比较内存地址，如果内存地址相同则不用比较
     * 
     * 如果二者只有一个为null，或者值不相等则返回false
     * 否则递归比较
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isIdentical(TreeNode a, TreeNode b) {
            if (a == b) return true;
            if (a == null || b == null || a.val != b.val) return false;
            return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
