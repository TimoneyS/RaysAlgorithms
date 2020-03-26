package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Find Elements in a Contaminated Binary Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree with the following rules:
 * 	root.val == 0
 * 	If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
 * 	If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
 * Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.
 * You need to first recover the binary tree and then implement the FindElements class:
 * 	FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
 * 	bool find(int target) Return if the target value exists in the recovered binary tree.
 *
 * Example:
 *      Example 1
 *      Input
 *      [FindElements,find,find]
 *      [[[-1,null,-1]],[1],[2]]
 *      Output
 *      [null,false,true]
 *      Explanation
 *      FindElements findElements = new FindElements([-1,null,-1]); 
 *      findElements.find(1); // return False 
 *      findElements.find(2); // return True 
 *      Example 2
 *      Input
 *      [FindElements,find,find,find]
 *      [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 *      Output
 *      [null,true,true,false]
 *      Explanation
 *      FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 *      findElements.find(1); // return True
 *      findElements.find(3); // return True
 *      findElements.find(5); // return False
 *      Example 3
 *      Input
 *      [FindElements,find,find,find,find]
 *      [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 *      Output
 *      [null,true,false,false,true]
 *      Explanation
 *      FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 *      findElements.find(2); // return True
 *      findElements.find(3); // return False
 *      findElements.find(4); // return False
 *      findElements.find(5); // return True
 *      Constraints:
 *      	TreeNode.val == -1
 *      	The height of the binary tree is less than or equal to 20
 *      	The total number of nodes is between [1, 10^4]
 *      	Total calls of find() is between [1, 10^4]
 *      	0 <= target <= 10^6
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree/
 * @since   2020-03-27 00:10:18
 */
public class L1387_Find_Elements_in_a_Contaminated_Binary_Tree {
    /**
     * 构造按照前序遍历依次构造即可
     *
     * 查询的时候根据目标值和当前值，以及层级的关系，推断出应该在左子树还是右子树中查询
     */
    class FindElements {
        TreeNode root;

        public FindElements(TreeNode root) {
            revert(root, 0);
            this.root = root;
        }

        private void revert(TreeNode node, int base) {
            if (node == null) return;
            node.val = base;
            revert(node.left, base * 2 + 1);
            revert(node.right, base * 2 + 2);
        }

        public boolean find(int target) {
            int targetLevel = 0;
            while (target >= (1 << (targetLevel + 1)) - 1) targetLevel ++;
            return find(0, targetLevel, root, target);
        }

        private boolean find(int l1, int l2, TreeNode node, int target) {
            if (node == null) return false;
            if (node.val == target) return true;

            int t = target - (1 << l2) + 1;
            int c = node.val - (1 << l1) + 1;
            int line = (1 << l2 - l1 - 1);
            if (t - c * (1 << l2 - l1) >= line) {
                return find(l1+1, l2, node.right, target);
            }
            return find(l1+1, l2, node.left, target);
        }
    }

    public static void main(String[] args) {
    }
}
