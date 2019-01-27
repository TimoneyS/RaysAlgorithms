package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个目标数字 target, 一个非负整数 k 和一个升序排序的整数数组 A 。
 * 在 A 中查找与目标最接近的 k 个数字，按数字和目标之间的差升序排序。如果差异相同，则按数字升序排序。
 *
 * 如：
 *       A = [1, 2, 3]， target = 2，k = 3   返回 [2, 1, 3]
 *       A = [1, 4, 6, 8]， target = 3，k = 3   返回 [2, 1, 3]
 *
 * 时间复杂度 O(logn + k)
 * 
 *
 * @author rays1
 *
 */
public class L_0460_Find_K_Closest_Elements {

    /**
     * 二分搜索寻找最接近 target 的元素索引，然后向两边搜索最接近 target 的k个数字
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] kClosestNumbers(int[] A, int target, int k) {
            int[] rs = new int[k];
            int l = 0, r = 0;
            l = index(A, target);
            r = l + 1;
            
            Out.p(r);
            
            for (int i = 0; i < rs.length; i++) {
                if (l >= 0 && r < A.length && target - A[l] <= A[r] - target || r >= A.length) {
                    rs[i] = A[l--];
                } else {
                    rs[i] = A[r++];
                }
            }
            return rs;
        }
        
        int index(int[] A, int target) {
            
            int l = 0, r = A.length - 1, m = 0;
            while (l <= r) {
                
                m = (l+r)/2;
                
                if (A[m] == target) {
                    while (m > 0 && A[m-1] == A[m]) m -- ;
                    return m;
                } else if (A[m] > target) {
                    r --;
                } else {
                    l++ ;
                }
       
            }
            
            if (r >= 0 && l < A.length && target - A[r] <= A[l] - target || l >= A.length) {
                return r;
            }
            return l;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,4,8,12,16,28,38};
        int target  = 1;
        int k       = 4;
        
        Out.p(new Solution().kClosestNumbers(A, target, k));
        
    }

}
