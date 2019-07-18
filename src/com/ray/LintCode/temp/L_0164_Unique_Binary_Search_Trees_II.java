package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      <p><span style="line-height: 30px;">Given&nbsp;</span><i style="line-height: 30px;">n</i><span style="line-height: 30px;">, generate all structurally unique&nbsp;</span><span style="font-weight: 700; line-height: 30px;">BST's</span><span style="line-height: 30px;">&nbsp;(binary search trees) that store values 1...</span><i style="line-height: 30px;">n</i><span style="line-height: 30px;">.</span><br></p>
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:3
 *      Output:
 *          1         3     3       2    1
 *           \       /     /       / \    \
 *            3     2     1       1   3    2
 *           /     /       \                \
 *          2     1         2                3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/unique-binary-search-trees-ii/description
 * @date   2019-07-11 18:31:25
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
