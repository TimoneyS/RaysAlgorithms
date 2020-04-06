package com.ray.LintCode.tostudy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ray.leetcode.util.TreeNode;
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

    /**
     * 二叉搜索树的特点是左子树的值都小于根节点，右子树的值都大于根节点。
     * 
     * 按照左 - 中 - 右 的遍历顺序得到的结点是有序的。
     * 
     * 遍历时：
     *      如果根节点小于 区间最小值，则左子树可以忽略
     *      如果根节点大于 区间最大值，则右子树可以忽略
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> searchRange(TreeNode root, int l, int h) {
            List<Integer> rs = new LinkedList<Integer>();
            searchRange(root, rs, l, h);
            return rs;
        }
        
        public void searchRange(TreeNode root, List<Integer> list, int l, int h) {
            if (root == null) return;
            if (root.val >= l) {
                searchRange(root.left, list, l, h);
            }
            if (root.val >= l && root.val <= h) {
                list.add(root.val);
            }
            if (root.val <= h) {
                searchRange(root.right, list, l, h);
            }
        }
    
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("{20,8,22,4,12}");
        
        int l = 10;
        int h = 22;
        
        Out.p(new Solution().searchRange(root, l, h).equals(Arrays.asList(new Integer[]{12, 20,22})));
    }

}
