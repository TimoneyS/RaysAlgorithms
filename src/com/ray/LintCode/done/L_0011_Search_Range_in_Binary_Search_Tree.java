package com.ray.LintCode.done;

import java.util.LinkedList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一个二叉搜索树和一个范围 [ k1, k2 ]，按照升序返回给定范围内的节点值。
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：{5},6,10
 *      Output：[]
 *              5
 *      it will be serialized {5}
 *      No number between 6 and 10
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：{20,8,22,4,12},10,22
 *      Output：[12,20,22]
 *      Explanation：
 *              20
 *             /  \
 *            8   22
 *           / \
 *          4   12
 *      it will be serialized {20,8,22,4,12}
 *      [12,20,22] between 10 and 22
 *      ```
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-range-in-binary-search-tree/description
 * @date   2019-07-10 21:44:10
 */
public class L_0011_Search_Range_in_Binary_Search_Tree {

    static class Solution {
    
        public List<Integer> searchRange(TreeNode root, int k1, int k2) {
            List<Integer> list = new LinkedList<Integer>();
            searchRange(root, list, k1, k2);
            return list;
        }
        
        public void searchRange(TreeNode root, List<Integer> list, int l, int h) {
            if (root == null) return;
            searchRange(root.left, list, l, h);
            if (root.val >= l && root.val <= h) list.add(root.val);
            searchRange(root.right, list, l, h);            
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
