package com.ray.LintCode.temp;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary search tree  and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  tree = {}, node = 1
 *      	Output:  1
 *      	
 *      	Explanation:
 *      	Insert node 1 into the empty tree, so there is only one node on the tree.
 *      
 *      Example 2:
 *      	Input: tree = {2,1,4,3}, node = 6
 *      	Output: {2,1,4,3,6}
 *      	
 *      	Explanation: 
 *      	Like this:
 *      
 *      
 *      
 *      	  2             2
 *      	 / \           / \
 *      	1   4   -->   1   4
 *      	   /             / \ 
 *      	  3             3   6
 *      		
 *      ```
 *
 * 挑战：
 *      Can you do it without recursion?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/insert-node-in-a-binary-search-tree/description
 * @date   2019-07-11 18:30:01
 */
public class L_0085_Insert_Node_in_a_Binary_Search_Tree {

    static class Solution {
        /*
         * @param root: The root of the binary search tree.
         * @param node: insert this node into the binary search tree
         * @return: The root of the new binary search tree.
         */
        public TreeNode insertNode(TreeNode root, TreeNode node) {
            
            if (root == null) return node;
            
            if (root.val > node.val)
                root.left = insertNode(root.left, node);
            else
                root.right = insertNode(root.right, node);
            
            return root;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
