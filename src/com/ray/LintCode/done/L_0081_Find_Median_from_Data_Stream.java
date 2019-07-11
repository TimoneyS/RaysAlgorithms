package com.ray.LintCode.done;

import static com.ray.io.Out.p;

import com.ray.io.Out;

/**
 * 描述：
 *      Numbers keep coming, return the median of numbers at every time a new number added.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: [1,2,3,4,5]
 *      Output: [1,1,2,2,3]
 *      Explanation:
 *      The medium of [1] and [1,2] is 1.
 *      The medium of [1,2,3] and [1,2,3,4] is 2.
 *      The medium of [1,2,3,4,5] is 3.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: [4,5,1,3,2,6,0]
 *      Output: [4,4,4,3,3,3,3]
 *      Explanation:
 *      The medium of [4], [4,5], [4,5,1] is 4.
 *      The medium of [4,5,1,3], [4,5,1,3,2], [4,5,1,3,2,6] and [4,5,1,3,2,6,0] is 3.
 *      ```
 *
 * 挑战：
 *      Total run time in O(_nlogn_).
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-median-from-data-stream/description
 * @date   2019-07-11 18:29:58
 */
public class L_0081_Find_Median_from_Data_Stream {

    static class Solution {
        
        /**
         * @param nums: A list of integers
         * @return: the median of numbers
         */
        public int[] medianII(int[] nums) {
            Balance_BST tree = new Balance_BST();
            int idx = 0;
            for (int i : nums) {
                tree.put(i);
                nums[idx++] = tree.root.val;
                
                tree.show();
            }
            return nums;
        }
        
        static class Balance_BST {
            
            class Node {
                Node left;
                Node right;
                int val;
                int size;
                public Node(int val) {
                    this.val = val;
                    this.size = 1;
                }
            }
            Node root;
            public void put(int v) {
                root = put(root, v);
                root = balance(root);
            }
            
            public Node put(Node n, int v) {
                if (n == null) return new Node(v);
                if (v <= n.val) {
                    n.left = put(n.left, v);
                } else {
                    n.right = put(n.right, v);
                }
                n.size = size(n.left) + size(n.right)+1;
                return n;
            }
       
            private Node removeMin(Node n) {
                if (n == null) return n;
                if (n.left == null) return n.right;
                n.left = removeMin(n.left);
                n.size = size(n.left) + size(n.right)+1;
               return n;
            }
            
            private Node removeMax(Node n) {
                if (n == null) return n;
                if (n.right == null) return n.left;
                n.right = removeMax(n.right);
                n.size = size(n.left) + size(n.right)+1;
                return n;
            }
            
            private Node min(Node n) {
                if (n.left == null) return n;
                else return min(n.left);
            }
            
            private Node max(Node n) {
                if (n.right == null) return n;
                else return max(n.right);
            }
            
            private Node balance(Node n) {
                if (size(n) == 1) return n;
                int r = size(root.left) - size(root.right);
                if (r == 1) {
                    // 需要从左移动一个元素到右
                    int nv = n.val;
                    n.val = max(n.left).val;
                    n.left = removeMax(n.left);
                    n.right = put(n.right, nv);
                    n.size = size(n.left) + size(n.right)+1;            
                } else if (r == -2) {
                    // 需要从右移动一个元素到左
                    int nv = n.val;
                    n.val = min(n.right).val;
                    n.right = removeMin(n.right);
                    n.left = put(n.left, nv);
                    n.size = size(n.left) + size(n.right)+1;
                }
                
                return n;
            }
        
            private int size(Node node) {return node == null? 0 : node.size; }
            
            public void show() {
                p("== tree ===========================");
                if (root != null) tree(root, 1);
                p("===================================");
            }

            public void tree(Node node, int deepth) {
                if(node == null) return;
                tree(node.right, deepth+1);
                Out.pf("%"+(deepth*10)+"s", " ");
                Out.pf("--[%2s,s:%2s]\n", node.val, node.size);
                tree(node.left, deepth+1);
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {-1,-100,-3,-100,-2,-10000,500,0,0,0,-499,500,2000,0,0,0,3000,-100,-200,-10000,100000};
        
        Out.p(new Solution().medianII(nums));
        
    }

}
