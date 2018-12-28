package com.ray.LintCode.resolved;

/**
 * Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.
 * @author rays1
 *
 */
public class L_0177_Convert_Sorted_Array_to_Binary_Search_Tree_With_Minimal_Height {

    static class Solution {
        public TreeNode sortedArrayToBST(int[] A) {
            return build(A, 0, A.length-1);
        }
        
        public TreeNode build(int[] A, int s, int t) {
            if (s > t) return null;
            else if (s == t) return new TreeNode(A[s]);
            int mid = (s+t)/2;
            TreeNode root = new TreeNode(A[mid]);
            root.left  = build(A, s, mid-1);
            root.right = build(A, mid+1, t);
            return root;
        } 
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,2,3,4,5,6,7};
        TreeNode root = new Solution().sortedArrayToBST(A);
        TreeNode.show(root);
        
    }

}
