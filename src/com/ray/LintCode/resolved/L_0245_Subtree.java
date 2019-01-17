package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 子树判断
 *
 * @author rays1
 *
 */
public class L_0245_Subtree {

    /**
     * 首先根据根节点从树1中查找所有的可能的根节点
     * 依次从每个根节点开始判断树是否和待判断的子树一致。
     * @author rays1
     *
     */
    static class Solution {
        
        public void find(TreeNode root, int val, List<TreeNode> rs) {
            if (root == null) return;
            if (root.val == val)
                rs.add(root);
            find(root.left, val, rs);
            find(root.right, val, rs);
        }
        
        public boolean isSubtree(TreeNode T1, TreeNode T2) {
            if (T2 == null) return true;
            List<TreeNode> rs = new ArrayList<>();
            find(T1, T2.val, rs);
            if (rs.size() == 0) return false;
            
            for (TreeNode t : rs) {
                if (compare(t, T2))
                    return true;
            }
            
            return false;
        }

        private boolean compare(TreeNode t1, TreeNode t2) {
            if (t1 == null || t2 == null) return t2 == t1;
            if (t1.val == t2.val) {
                if (compare(t1.left, t2.left)) {
                    return compare(t1.right, t2.right);
                }
            }
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode T1 = TreeNode.parse("{989,982,#,972,#,947,#,920,#,903,#,894,#,881,#,866,#,864,#,842,#,841,#,796,#,726,#,647,#,613,719,593,#,#,#,590,#,558,#,554,#,538,#,512,#,504,#,468,505,467,#,#,#,456,#,413,#,331,#,330,407,320,#,#,#,312,#,306,#,301,#,274,#,251,#,235,#,231,#,222,#,181,#,93,#,83,#,73,#,64,#,62,#,60,#,28,#,21,#,20,#,-32,#,-52,#,-70,#,-87,#,-98,#,-102,#,-115,#,-116,#,-139,#,-183,#,-224,#,-241,#,-263,#,-284,#,-294,#,-296,#,-320,#,-330,#,-392,#,-398,#,-407,#,-431,#,-445,#,-460,#,-463,#,-492,#,-507,#,-518,#,-539,#,-552,#,-558,#,-559,#,-587,#,-673,#,-736,#,-757,#,-766,#,-767,#,-823,#,-830,#,-867,#,-875,#,-891,#,-905,#,-910,#,-924,#,-960,#,-985,#,-988}");
        TreeNode T2 = TreeNode.parse("{320,312,#,306,#,301,#,274,#,251,#,235,#,231,#,222,#,181,#,93,#,83,#,73,#,64,#,62,#,60,#,28,#,21,#,20,#,-32,#,-52,#,-70,#,-87,#,-98,#,-102,#,-115,#,-116,#,-139,#,-183,#,-224,#,-241,#,-263,#,-284,#,-294,#,-296,#,-320,#,-330,#,-392,#,-398,#,-407,#,-431,#,-445,#,-460,#,-463,#,-492,#,-507,#,-518,#,-539,#,-552,#,-558,#,-559,#,-587,#,-673,#,-736,#,-757,#,-766,#,-767,#,-824,#,-830,#,-867,#,-875,#,-891,#,-905,#,-910,#,-924,#,-960,#,-985,#,-988}");
        
        Out.p(new Solution().isSubtree(T1, T2));
        
    }

}
