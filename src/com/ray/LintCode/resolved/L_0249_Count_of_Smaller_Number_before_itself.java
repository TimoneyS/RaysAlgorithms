package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * n个元素的整型数组，对于每个元素 A[i]，统计 A[0..i-1] 中小于 A[i] 的元素个数
 *
 * 对于 [1,2,7,8,5]， 返回 [0,1,2,3,2]
 *
 * @author rays1
 *
 */
public class L_0249_Count_of_Smaller_Number_before_itself {
    
    /**
     * 利用插入排序的原理，在插入过程中更新每个元素的排名
     * @author rays1
     */
    static class Solution1 {
        
        public List<Integer> countOfSmallerNumberII(int[] A) {
            Integer[] rs = new Integer[A.length];
            
            for (int i = 0; i < rs.length; i++) {
                rs[i] = rank(A, 0, i-1, A[i]);
                if (rs[i] == i) continue;
                
                int tmp = A[i];
                for (int j = i; j > rs[i]; j--) {
                    A[j] = A[j-1];
                }
                A[rs[i]] = tmp;
                
            }
            return Arrays.asList(rs);
        }
        
        public int rank(int[] A, int l, int r, int num) {
            while (l<r) {
                int m = (l+r)/2;
                // target 其实表示 位于 target-1 和 target 之间的数字
                if (A[m] < num)
                    l = m+1;
                else
                    r = m-1;
            }
            return (l>r) ? l : (A[r] >= num) ? r : r+1;
        }
        
    }
    
    /**
     * 利用段树，未完成
     * @author rays1
     *
     */
    static class Solution {
        
        public SegmentTreeNode build(int[] A, int start, int end) {
            if (A == null || A.length == 0)  return null;
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start == end) {
                root.count = 1;
                root.max = A[start];
            } else {
                int m = (start+end)/2;
                root.left  = build(A, start, m);
                root.right = build(A, m+1, end);
                root.count = root.left.count + root.right.count;
                root.max = Math.max( root.left.max, root.right.max);
            }
            return root;
        }
        
        public int max(SegmentTreeNode node) {return node == null? Integer.MIN_VALUE : node.max; }
        public int count(SegmentTreeNode node) {return node == null? 0 : node.count; }
        
        public List<Integer> countOfSmallerNumberII(int[] A) {
            SegmentTreeNode root = build(A, 0, A.length-1);
            Integer[] rs = new Integer[A.length];
            
//            for (int i = 0; i < rs.length; i++) {
//                rs[i] = count(root, A, i);
//            }
            
            SegmentTreeNode.show(root);
            
            count(root, A, 9);
            
            return Arrays.asList(rs);
        }
        
        public int count(SegmentTreeNode root, int[] A, int index) {
            if (root == null || root.start >= index) return 0;
            
            Out.pf("[%s, %s]\n", root.start, root.end);
            
            if (root.end <= index && root.max < A[index]) { 
                return root.count;
            } else if (root.start == root.end) {
                return (root.end < index && A[index] > root.max) ? 1 : 0;
            } else {
                return count(root.left, A, index) + count(root.right, A, index);
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,2,7,8,5};
        
        Timer.CLICK();
        List<Integer> rs = new Solution1().countOfSmallerNumberII(A);
        Timer.STOP();
        
        Out.p(rs);
    }

}
