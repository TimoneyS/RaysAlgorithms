package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;


/**
 * 给定一颗二叉树，返回垂直顺序遍历的结点值。
 * 如果两个结点在同一列或同一行，则左结点优先。
 *
 * @author rays1
 *
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
        
        // {3,9,20,#,#,15,7} -> [[9],[3,15],[20],[7]]
        // {3,9,8,4,0,1,7}   -> [[4],[9],[3,0,1],[8],[7]]
        TreeNode root = TreeNode.parse("{3,9,8,4,0,1,7,#,#,#,2,5}");
        TreeNode.show(root);
        
        Out.p(new Solution().verticalOrder(root));
        
    }

}
