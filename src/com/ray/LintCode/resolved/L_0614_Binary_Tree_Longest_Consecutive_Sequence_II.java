package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 给定一颗二叉树，寻找最长连续序列路径的长度。路径可以从任意的结点开始和结束。
 *
 * @author rays1
 *
 */
public class L_0614_Binary_Tree_Longest_Consecutive_Sequence_II {

    /**
     * 本题和 595 的不同之处在于，每个结点所在的路径不仅仅可能是父结点到子结点，也可能是子结点之间构成路径。
     * 
     *    p
     *    |
     *    n
     *   / \
     *  l   r 
     * 
     * 如上图：
     *      每个结点可能的路径 不仅仅是  p - n - l, p - n - r
     *      也可能是 l - n - r
     *      
     *      注意: p - n - l 和 l - n - p 是等效的，所以实际路径可以认为只有三条，其中两条是父结点到子结点
     * 
     * 就单个结点而言，向每一侧只能是递增或递减，保留两个长度:
     *      递增的最大长度 inc
     *      递减的最大长度 dec
     * 
     * 全局的最大长度只能是从某个结点延申开来，因此全局的最大长度是 max { 每个结点的 dec + inc - 1 } 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        int max;
        
        public int longestConsecutive2(TreeNode root) {
            max = 0;
            helper(root);
            return max;
        }

        int[] helper(TreeNode root) {
            if(root == null) return new int[2];
            
            int[] rs = new int[] {1, 1};
            
            int[] left = helper(root.left);
            if (inc(root, root.left)) rs[0] = Math.max(rs[0],  left[0] + 1);
            if (dec(root, root.left)) rs[1] = Math.max(rs[1],  left[1] + 1);
            
            int[] right = helper(root.right);
            if (inc(root, root.right)) rs[0] = Math.max(rs[0], right[0] + 1);
            if (dec(root, root.right)) rs[1] = Math.max(rs[1], right[1] + 1);
            
            max = Math.max(max, rs[1] + rs[0] - 1);
            
            return rs;
        }

        boolean inc(TreeNode n1, TreeNode n2) { return n2 != null && n1.val + 1 == n2.val; }
        boolean dec(TreeNode n1, TreeNode n2) { return n2 != null && n1.val - 1 == n2.val; }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
