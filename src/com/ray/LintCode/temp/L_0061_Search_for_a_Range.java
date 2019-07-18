package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a sorted array of *n* integers, find the starting and ending position of a given target value.
 *      
 *      If the target is not found in the array, return `[-1, -1]`.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      []
 *      9
 *      Output:
 *      [-1,-1]
 *      
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      [5, 7, 7, 8, 8, 10]
 *      8
 *      Output:
 *      [3, 4]
 *      ```
 *
 * 挑战：
 *      O(log *n*) time.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-for-a-range/description
 * @date   2019-07-11 18:20:29
 */
public class L_0061_Search_for_a_Range {

    static class Solution {
        
        /**
         * @param A: an integer sorted array
         * @param target: an integer to be inserted
         * @return: a list of length 2, [index1, index2]
         */
        public int[] searchRange(int[] A, int target) {
            
            int l = searchInsert(A, target);
            int r = searchInsert(A, target+1);
            if (l == r) return new int[] {-1, -1};
            
            return new int[] {l, r-1};
        }
        
        /**
         * 假设 a 是 位于 target-1 和 target 之间的数字
         * 在数组中搜索 a 的索引，搜索结果必然是刚好大于 target-1的位置
         * @param A
         * @param target
         * @return
         */
        private int searchInsert(int[] A, int target) {
            int l = 0,r = A.length-1;
            if (r==-1) return 0;
            while (l<r) {
                int m = (l+r)/2;
                // target 其实表示 位于 target-1 和 target 之间的数字
                if (A[m] <= target - 1) l = m+1;
                else r = m-1;
            }
            return (l>r) ? l : (A[r] >= target) ? r : r+1;
        }
 
    }
    
    public static void main(String[] args) {
        
        int[] A = {5, 7, 7, 8, 8, 10};
        int target = 8;
        
        Out.p(new Solution().searchRange(A, target));
        
    }

}
