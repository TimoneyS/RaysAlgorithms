package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array with positive and negative numbers, find the `maximum average subarray` which length should be greater or equal to given length `k`.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      [1,12,-5,-6,50,3]
 *      3
 *      Output:
 *      15.667
 *      Explanation:
 *       (-6 + 50 + 3) / 3 = 15.667
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      [5]
 *      1
 *      Output:
 *      5.000
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-average-subarray-ii/description
 * @date   2019-07-11 18:34:31
 */
public class L_0617_Maximum_Average_Subarray_II {

    /**
     * 假设最大的平均数为 avg {a[i] ~ a[j] } = avg
     * 则
     *      a[i] + a[i+1] + ... + a[j] = avg * (j-i+1)
     *      a[i] - avg + a[i+1] - avg + ... + a[j] - avg = 0
     * 
     * 数组的平均值一定在  max 和 min 之间，则可以采用二分搜索方式查询
     * 在数组中寻找最大的 x 
     * 使得存在大于等于 k 的子数组有 sum { a[i] - x + .. a[j] - x } = 0 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        // 寻找长度至少为 k 的，sum {A[i]-avg + ... + A[j] - avg} >= 0 的子数组
        private boolean canFind(int[] A, int K, double avg) {
            double rightSum = 0, leftSum = 0, minLeftSum = 0;
            
            for (int i = 0; i < K; i++) {
                rightSum += A[i] - avg;
            }
            
            for (int i = K; i <= A.length; ++i) {
                if (rightSum - minLeftSum >= 0) {
                    return true;
                }
                if (i < A.length) {
                    rightSum += A[i] - avg;
                    leftSum  += A[i - K] - avg;
                    minLeftSum = Math.min(minLeftSum, leftSum);
                }
            }
            
            return false;
        } 
         
        public double maxAverage(int[] A, int K) {
            double min, max, mid;
            min = max = A[0];
            for (int i = 0; i < A.length; ++i) {
                min = Math.min(A[i], min);
                max = Math.max(A[i], max);
            }
            
            while (min + 1e-5 < max) {
                mid = (min + max) / 2;
                if (canFind(A, K, mid)) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
            
            return min;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
