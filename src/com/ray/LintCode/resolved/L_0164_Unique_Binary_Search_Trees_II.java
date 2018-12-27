package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 返回 n 个数字可能构成的所有二叉树
 *
 * @author rays1
 *
 */
public class L_0164_Unique_Binary_Search_Trees_II {

    static class Solution {
        
        private List<TreeNode>[][] mem;
        
        @SuppressWarnings("unchecked")
        public void init(int n) {
            mem = new List[n+2][n+2];
        }
        
        public List<TreeNode> generateTrees(int n) {
            init(n);
            return helper(1, n, 0);
        }
        
        public List<TreeNode> helper(int s, int t, int level) {
            List<TreeNode> rs = new ArrayList<>();
            
            if (mem[s][t] == null) {
                
                if (s > t) {
                    rs.add(null);
                } else if (s == t) {
                    rs.add(new TreeNode(s));
                } else {
                    for (int i = s;i <= t; i++) {
                        
                        for (TreeNode l : helper(s, i-1, level + 1)) {
                            for (TreeNode r : helper(i+1, t, level + 1)) {
                                TreeNode root = new TreeNode(i);
                                root.left = l;
                                root.right = r;
                                rs.add(root);
                            }
                        }
                        
                    }

                }
                
                mem[s][t] = rs;
                
            }
            
            return mem[s][t];
        }
        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = 7;
        
        
        Solution sol = new Solution();
        List<TreeNode> rs = sol.generateTrees(n);
        
        Out.p(rs.size());
        
//        for (TreeNode root : rs) {
//            TreeNode.show(root);
//        }
        
    }

}
