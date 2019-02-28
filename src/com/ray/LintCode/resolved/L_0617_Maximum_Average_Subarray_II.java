package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个数组包含正数和负数。
 * 寻找平均数最大的子数组，数组的长度大于等于给定的长度 k
 *
 * 例如：
 *      数组          [1,12,-5,-6,50,3], k = 3
 *      结果为      [-6, 50, 3], avg = 15.667
 * @author rays1
 *
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
