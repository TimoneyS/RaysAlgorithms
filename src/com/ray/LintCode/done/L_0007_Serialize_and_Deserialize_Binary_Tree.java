package com.ray.LintCode.done;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      设计算法序列化合反序列化二叉树。序列化就是将一棵树解析为文本，反序列化则时从文本得到树。
 *      
 * 用例：
 *      **用例 1:**
 *      输入：{3,9,20,#,#,15,7}
 *      输出：{3,9,20,#,#,15,7}
 *      解释：
 *      二叉树 {3,9,20,#,#,15,7} 的结构如下：
 *      	  3
 *      	 / \
 *      	9  20
 *      	  /  \
 *      	 15   7
 *      可以被序列化为 {3,9,20,#,#,15,7}
 *      
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/serialize-and-deserialize-binary-tree/description

 * @date   2019-07-10 16:15:23
 */
public class L_0007_Serialize_and_Deserialize_Binary_Tree {
    
    /**
     * 序列化的顺序是对树的BFS搜索
     *      首先被序列化的是根结点
     *      然后是根结点的左结点，根节点的右结点
     *      按照层级，从左向右，从上到下依次将结点写入字符串即可。
     *      
     * 反序列话的顺序和序列话一致
     *      首先读取的是根节点
     *      然后是根结点的左结点，根节点的右结点
     *      按照层级，从左向右，从上到下依次将字符串生成结点即可。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String serialize(TreeNode root) {
            
            Queue<TreeNode> queue = new ArrayDeque<>();
            if (root != null) queue.add(root);
            
            TreeNode dummy = new TreeNode(0);
            StringBuilder sb = new StringBuilder("{");
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.equals(dummy)) {
                    sb.append('#');
                } else {
                    queue.add(node.left  == null ? dummy : node.left);
                    queue.add(node.right == null ? dummy : node.right);
                    sb.append(node.val);
                }
                sb.append(",");
            }
            
            while (sb.length() > 2 && sb.charAt(sb.length()-2) == '#') {
                sb.setLength(sb.length()-2);
            }
            
            if (sb.charAt(sb.length()-1) == ',') {
                sb.setCharAt(sb.length()-1, '}');
            } else {
                sb.append('}');
            }
                
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            data = data.trim();
            String[] dataArr = data.substring(1, data.length()- 1).split(",");
            TreeNode pile = new TreeNode(0);
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(pile);
            
            boolean isLeft = false;
            for (String val : dataArr) {
                
                if (val.equals("")) continue;
                
                if (!val.equals("#")) {
                    TreeNode node = new TreeNode(Integer.valueOf(val));
                    if (isLeft) {
                        node = queue.peek().left = node;
                    } else {
                        node = queue.peek().right = node;
                    }
                    queue.add(node);
                }
                if (!isLeft) {
                    queue.poll();
                }
                isLeft = !isLeft;
            }
            return pile.right;
        }
    
    }
    
    public static void main(String[] args) {
        
        String data = "{}";
        
        Solution sol = new Solution();
        TreeNode root = sol.deserialize(data);
        Out.p(sol.serialize(root));
        
        TreeNode.show(root);
        
    }

}
