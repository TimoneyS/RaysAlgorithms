package com.ray.LintCode.temp;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input : {5,2,13}
 *                    5
 *                  /   \
 *                 2     13
 *      Output : {18,20,13}
 *                   18
 *                  /   \
 *                20     13
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input : {5,3,15}
 *                    5
 *                  /   \
 *                 3     15
 *      Output : {20,23,15}
 *                   20
 *                  /   \
 *                23     15
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/convert-bst-to-greater-tree/description
 * @date   2019-07-11 18:35:12
 */
public class L_0661_Convert_BST_to_Greater_Tree {

    
    /**
     * 因为二叉搜索树，实际上是有序的，只要按照从大到小的顺序访问结点，然后不断记录结点和，作为遍历到的结点的值。
     * 
     * 遍历顺序为 右 - 中 - 左
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public TreeNode convertBST(TreeNode root) {
            trans(root, 0);
            return root;
        }
        
        int trans(TreeNode root, int sum) {
            if (root == null) return sum;
            sum = trans(root.right, sum);
            sum += root.val;
            root.val = sum;
            sum = trans(root.left, sum);
            return sum;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
