package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * If the depth of a tree is smaller than 5, this tree can be represented by a list of three-digits integers.
 *
 * For each integer in this list:
 *     1. The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 *     2. The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8.
 *        The position is the same as that in a full binary tree.
 *     3. The units digit represents the value V of this node, 0 <= V <= 9.
 *
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 5.
 * You need to return the sum of all paths from the root towards the leaves.
 *
 * 一种特殊的表示二叉树的方式：
 *      百位表示结点深度
 *      十位表示结点在该层的序号
 *      个位表示结点的值
 * 从这样的表达方式中，计算所有指向叶子结点的路径的值，返回这些路径之和。     
 *      
 * @author rays1
 * @url    https://www.lintcode.com/problem/binary-tree-path-sum-iv/description
 */
public class L_0863_Binary_Tree_Path_Sum_IV {

    static class Solution {
    
        public int pathSum(int[] nums) {
            Map<Integer, Integer> tree = new HashMap<>();
            for (int n : nums) {
                int v = n % 10;
                n /= 10;
                int o = n % 10;
                n /= 10;
                int l = n;
                int index = (1 << (l-1)) + o - 1;
                tree.put(index, v);
            }
            if (tree.isEmpty()) return 0;
            return dfs(tree, 1, 0);
        }

        private int dfs(Map<Integer, Integer> tree, int i, int base) {
            int l = 2*i;
            int r = l+1;
            base += tree.get(i);
            if (!tree.containsKey(l) && !tree.containsKey(r)) {
                return base;
            } else {
                int rs = 0;
                if (tree.containsKey(l)) rs += dfs(tree, l, base); 
                if (tree.containsKey(r)) rs += dfs(tree, r, base);
                return rs;
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {113, 215, 221};
        Out.p(new Solution().pathSum(nums));
        
    }

}
