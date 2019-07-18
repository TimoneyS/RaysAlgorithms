package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `target`, a non-negative integer `k` and an integer array `A` sorted in ascending order, find the `k` closest numbers to `target` in `A`, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: A = [1, 2, 3], target = 2, k = 3
 *      Output: [2, 1, 3]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: A = [1, 4, 6, 8], target = 3, k = 3
 *      Output: [4, 1, 6]
 *      ```
 *
 * 挑战：
 *      O(logn + k) time
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-k-closest-elements/description
 * @date   2019-07-11 18:33:19
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
        
        Out.p(new Solution());
        
    }

}
