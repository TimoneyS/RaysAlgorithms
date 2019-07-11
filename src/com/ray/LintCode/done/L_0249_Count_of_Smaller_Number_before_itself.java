package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.LintCode.util.SegmentTreeNode;
import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      Give you an integer array (index from 0 to n-1, where n is the size of this array, data value from 0 to 10000) . For each element `Ai` in the array, count the number of element before this element `Ai` is smaller than it and return count number array.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [1,2,7,8,5]
 *      Output:
 *      [0,1,2,3,2]
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      [7,8,2,1,3]
 *      Output:
 *      [0,1,0,0,2]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/count-of-smaller-number-before-itself/description
 * @date   2019-07-11 18:32:06
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
