package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组，寻找和最小的子数组。
 *
 * 用例：
 *      **用例 1**
 *      输入：[1, -1, -2, 1]
 *      输出：-3
 *      
 *      **用例 2**
 *      输入：[1, -1, -2, 1, -4]
 *      输出：-6
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-subarray/description
 * @date   2019-07-11 17:58:01
 */
public class L_0044_Minimum_Subarray {

    /**
     * 和 L_0041_Maximum_Subarray 类似，最大值改为最小值即可
     * 
     * 设 sum[i] 表示以 i 结束的和最大子数组之和
     * 
     * 则有
     *      sum[i+1] = min(sum[i], 0) + nums[i+1]
     * 最终的结果为
     *      rs = min { sum[0], sum[1], ... , sum[n-1] }
     * 
     * 则算法如下
     * 
     * // 计算 sum 数组
     * for (int i = 1; i < n; i++)
     *      sum[i] = Math.min(sum[i-1], 0) + nums[i]
     *
     * // 再计算结果
     * for (int s : sum)
     *      rs = Math.min(rs, s);

     * @author rays1
     *
     */
    static class Solution {
        
        public int minSubArray(List<Integer> nums) {
            int sum = 0, min = Integer.MAX_VALUE; 
            for (int i : nums) {
                sum = Math.min(sum, 0) + i;
                min = Math.min(min, sum);
            }
            return min;
        }
        
    }
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {1, 2, 2, 2});
        Out.p(new Solution().minSubArray(nums));
        
    }

}
