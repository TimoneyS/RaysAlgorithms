package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 
 * 检查两个树是否相同，相同表示树的结构相同，并且每个相同的位置的结点，值也相同。
 *
 * @author rays1
 *
 */
public class L_0469_Same_Tree {

    /**
     * 先比较内存地址，如果内存地址相同则不用比较
     * 
     * 如果二者只有一个为null，或者值不相等则返回false
     * 否则递归比较
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isIdentical(TreeNode a, TreeNode b) {
            if (a == b) return true;
            if (a == null || b == null || a.val != b.val) return false;
            return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
