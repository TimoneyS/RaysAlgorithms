package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个有序数组和一个目标值，返回目标值在数组中的索引。
 *      若不存在则返回一个可以插入目标值的索引，插入后数组还是有序的。
 *      数组中不存在重复元素
 * 用例：
 *      `[1,3,5,6]`, 5 → 2
 *      
 *      `[1,3,5,6]`, 2 → 1
 *      
 *      `[1,3,5,6]`, 7 → 4
 *      
 *      `[1,3,5,6]`, 0 → 0
 *
 * 挑战：
 *      O(log(n)) time
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-insert-position/description
 * @date   2019-07-11 18:20:27
 */
public class L_0060_Search_Insert_Position {

    /**
     * 二分搜索原理
     * @author rays1
     *
     */
    static class Solution {
        
        public int searchInsert(int[] A, int target) {
            int l = 0,r = A.length-1;
            if (r==-1) return 0;
            while (l<r) {
                int m = (l+r)/2;
                if (target == A[m]) return m;
                if (target > A[m])      l = m+1;
                else if (target < A[m]) r = m-1;
            }
            return (l>r) ? l : (A[r] >= target) ? r : r+1;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {5};
        int target = 5;
        
        Out.p(new Solution().searchInsert(A, target));
        
        
    }

}
