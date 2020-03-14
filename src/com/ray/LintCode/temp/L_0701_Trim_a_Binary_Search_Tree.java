package com.ray.LintCode.temp;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given the root of a binary search tree and 2 numbers min and max, trim the tree such that all the numbers in the new tree are between min and max (inclusive). The resulting tree should still be a valid binary search tree. So, if we get this tree as input:
 *      ![http://www.ardendertat.com/wp-content/uploads/2012/01/bst.png](http://www.ardendertat.com/wp-content/uploads/2012/01/bst.png "")
 *      and we’re given min value as 5 and max value as 13, then the resulting binary search tree should be:
 *      ![http://www.ardendertat.com/wp-content/uploads/2012/01/bst_trim.png](http://www.ardendertat.com/wp-content/uploads/2012/01/bst_trim.png "")
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: 
 *      {8,3,10,1,6,#,14,#,#,4,7,13}
 *      5
 *      13
 *      Output: {8, 6, 10, #, 7, #, 13}
 *      Explanation:
 *      The picture of tree is in the description.
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: 
 *      {1,0,2}
 *      1
 *      2
 *      Output: {1,#,2}
 *      Explanation:
 *      Input is 
 *        1
 *       / \
 *      0   2
 *      Output is
 *        1
 *         \
 *          2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/trim-a-binary-search-tree/description
 * @date   2019-07-11 18:35:39
 */
public class L_0701_Trim_a_Binary_Search_Tree {

    /**
     *  如果 root 的值在二者之间，则 root 的位置不需要变更，
     *  如果 root 的值小于最小，则 root 和其左子树全部删除，新的根在右子树中
     *  如果 root 的值大于最大，则 root 和其右子树全部删除，新的根在左子树中
     */
    static class Solution {
    
        public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
            if (root == null) return root;
            if (root.val >= minimum && root.val <= maximum) {
                root.left = trimBST(root.left, minimum, maximum);
                root.right = trimBST(root.right, minimum, maximum);
                return root;
            } else if (root.val < minimum) {
                return trimBST(root.right, minimum, maximum);
            } else {
                return trimBST(root.left, minimum, maximum);
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
