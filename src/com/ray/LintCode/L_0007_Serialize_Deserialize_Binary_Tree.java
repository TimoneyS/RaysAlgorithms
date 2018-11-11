package com.ray.LintCode;

import java.util.LinkedList;

import com.ray.io.Out;

/**
 * Design an algorithm and write code to serialize and deserialize a binary tree. 
 * Writing the tree to a file is called 'serialization' and reading back from the file to 
 * reconstruct the exact same binary tree is 'deserialization'.
 * <p>
 * Example
 * <p>
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:<br>
 * 
 *    3     <br>
 *   / \    <br>
 *  9  20   <br>
 *    /   \ <br>
 *   15   7 <br>
 * 
 * Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
 * You can use other method to do serializaiton and deserialization.
 * @author rays1
 *
 */
public class L_0007_Serialize_Deserialize_Binary_Tree {
    
    static class TreeNode {
        public int      val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    static class Solution {
        /**
         * This method will be invoked first, you should design your own algorithm 
         * to serialize a binary tree which denote by a root node to a string which
         * can be easily deserialized by your own "deserialize" method later.
         */
        public String serialize(TreeNode root) {
            // write your code here
            if (root == null) return "{}";
            
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            
            queue.add(root);
            
            TreeNode emptyNode = new TreeNode(-1);
            
            StringBuilder sb = new StringBuilder("{");
            while (!queue.isEmpty()) {
                
                TreeNode node = queue.poll();
                
                if (node.val == -1) {
                    sb.append('#');
                } else {
                    if (node.left == null)
                        queue.add(emptyNode);
                    else
                        queue.add(node.left);
                    
                    if (node.right == null)
                        queue.add(emptyNode);
                    else
                        queue.add(node.right);
                    
                    sb.append(node.val);
                }
                    
                sb.append(",");
            }
            
            while (sb.charAt(sb.length()-2) == '#') {
                sb.setLength(sb.length()-2);
            }
            sb.setCharAt(sb.length()-1, '}');
                
            return sb.toString();
           
        }

        /**
         * This method will be invoked second, the argument data is what exactly
         * you serialized at method "serialize", that means the data is not given by
         * system, it's given by your own serialize method. So the format of data is
         * designed by yourself, and deserialize it here as you serialize it in 
         * "serialize" method.
         */
        public TreeNode deserialize(String data) {
            // write your code here
            if (data.equals("{}"))  return null;
            
            String[] dataArr = data.substring(1, data.length()- 1).split(",");
            
            TreeNode root = new TreeNode(Integer.valueOf(dataArr[0]));
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            
            queue.add(root);
            
            boolean isLeft = true;
            for (int i = 1; i < dataArr.length; i++) {
                
                TreeNode node = null;
                TreeNode childNode = null;
                
                if (!dataArr[i].equals("#"))
                    childNode = new TreeNode(Integer.valueOf(dataArr[i]));
                if (isLeft) {
                    node = queue.peek();
                    node.left = childNode;
                } else {
                    node = queue.poll();
                    node.right = childNode;
                }
                if (childNode != null)
                    queue.add(childNode);
                
                isLeft = !isLeft;
            }
            return root;
        }
        
  
        
    }
    
    public static void main(String[] args) {
        
        TreeNode node = new Solution().deserialize("{}");
        Out.p(new Solution().serialize(node));
        
    }
    
    
}
