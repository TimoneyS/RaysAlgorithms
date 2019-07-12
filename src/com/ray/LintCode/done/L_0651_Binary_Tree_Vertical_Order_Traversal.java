package com.ray.LintCode.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *      
 *      If two nodes are in the same row and column, the order should be from **left to right**.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Inpurt:  {3,9,20,#,#,15,7}
 *      Output: [[9],[3,15],[20],[7]]
 *      Explanation:
 *         3
 *        /\
 *       /  \
 *       9  20
 *          /\
 *         /  \
 *        15   7
 *      ```
 *      **Example2**
 *      ```
 *      Input: {3,9,8,4,0,1,7}
 *      Output: [[4],[9],[3,0,1],[8],[7]]
 *      Explanation:
 *           3
 *          /\
 *         /  \
 *         9   8
 *        /\  /\
 *       /  \/  \
 *       4  01   7
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-vertical-order-traversal/description
 * @date   2019-07-11 18:34:49
 */
public class L_0651_Binary_Tree_Vertical_Order_Traversal {

    /**
     * 广度优先遍历，使用 TreeMap记录元素的相对的垂直索引。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<List<Integer>> verticalOrder(TreeNode root) {
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();
            
            Queue<TreeNode> q1 = new ArrayDeque<TreeNode>();
            Queue<Integer>  q2  = new ArrayDeque<Integer>();            
            
            if (root != null)
                q1.add(root);
            q2.add(0);
            
            while (!q1.isEmpty()) {
              
                TreeNode node = q1.poll();
                int index = q2.poll();
                
                map.putIfAbsent(index, new ArrayList<>());
                map.get(index).add(node.val);
                
                if (node.left != null) {
                    q1.add(node.left);
                    q2.add(index - 1);
                }
                
                if (node.right != null) {
                    q1.add(node.right);
                    q2.add(index + 1);
                }
                
            }
            
            return new ArrayList<>(map.values());
        }

    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
