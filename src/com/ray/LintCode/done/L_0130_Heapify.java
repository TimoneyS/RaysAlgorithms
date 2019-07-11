package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array, heapify it into a min-heap array.<div>For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].</div>
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : [3,2,1,4,5]
 *      Output : [1,2,3,4,5]
 *      Explanation : return any one of the legitimate heap arrays
 *      ```
 *
 * 挑战：
 *      <p>O(n) time complexity</p>
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/heapify/description
 * @date   2019-07-11 18:30:56
 */
public class L_0130_Heapify {

    static class Solution {
        public void heapify(int[] A) {
            for (int i = 1; i < A.length; i++) {
                up(A, i);
            }
        }
        
        public void up(int[] A, int i) {
            int findex = (i-1)/2;
            while (findex >= 0 && A[i] < A[findex]) {
                int t = A[i];
                A[i] = A[findex];
                A[findex] = t;
                i = findex;
                findex = (findex-1)/2;
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {6,3,2,1,5,4};
        
        new Solution().heapify(A);
        Out.p(A);
        
    }

}
