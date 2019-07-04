package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * Description :
 *   Given a binary tree, imagine yourself standing on the right side of it,
 *    return the values of the nodes you can see ordered from top to bottom
 *
 * Example :
 *   **Example 1**
 *   
 *   ```
 *   Input: {1,2,3,#,5,#,4}
 *   Output: [1,3,4]
 *   Explanation:
 *      1            
 *    /   \
 *   2     3         
 *    \     \
 *     5     4       
 *   ```
 *   
 *   **Example 2**
 *   
 *   ```plain
 *   Input: {1,2,3}
 *   Output: [1,3]
 *   Explanation:
 *      1            
 *    /   \
 *   2     3        
 *   ```
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-right-side-view/description

 * @date   2019-07-04 16:21:26
 */
public class L_0760_Binary_Tree_Right_Side_View {

    /**
     * 前序遍历数，中 -> 左 -> 右
     * 将每个层级的结点加入列表，后加入的覆盖先加入的即可。
     * 
     * 或者按照 中 -> 右  -> 左， 每次只添加层级大于列表长度的元素。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            heler(root, 0, rs);
            return rs;
        }
        
        public void heler(TreeNode node, int level, List<Integer> rs) {
            if (node == null) return;
            if (rs.size() <= level) {
                rs.add(node.val);
            }
            heler(node.right, level+1, rs);     
            heler(node.left, level+1, rs);
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,2,3,#,5,#,4}");
        Out.p(new Solution().rightSideView(root));
        
    }

}
