package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 给定一个二叉树，不断的摘下所有的叶子，直到树为空。
 * 
 * 例如：
 * 
 *  输入：{1,2,3,4,5}
 *  输出：[[4, 5, 3], [2], [1]].
 *  
 *       1            1         
 *      / \          / \ 
 *     2   3   -->  2   3  --> 1
 *    / \      
 *   4   5     
 *
 * @author rays1
 *
 */
public class L_0650_Find_Leaves_of_Binary_Tree {

    /**
     * 后序遍历数组，记录每个结点离叶子节点的最远距离
     * 这个距离就是结点被删除的次序，保存到map中。
     * 
     * 遍历结束后，按照map中存储的距离信息，拼出结果数组。
     * 
     * 更进一步的可以直接用List保存信息，距离就是结果索引，因为必然先计算完距离近的
     * 保证结果中索引是从小到大计算完毕。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> rs = new ArrayList<>();
            walk(root, rs);
            return rs;
        }
        
        int walk(TreeNode root, List<List<Integer>> rs) {
            if (root == null) return -1;
            int d = Math.max(walk(root.left, rs), walk(root.right, rs))+1;
            if (d >= rs.size()) rs.add(new ArrayList<Integer>());
            rs.get(d).add(root.val);
            return d;
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,2,3,4,5}");
        Out.p(new Solution().findLeaves(root));
        
    }

}
