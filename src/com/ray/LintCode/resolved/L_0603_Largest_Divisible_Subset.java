package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个无重复的正整数集合，寻找满足如下条件的最大子集：
 *      子集中的每一对元素 (Si, Sj) 都有 Si % Sj = 0 或 Sj % Si = 0 。
 *
 * 例如
 *      给一个数组 [1,2,3]，返回 [1,2] 或 [1,3]
 *      给一个数组 [1,2,4,8]，返回 [1,2,4,8]
 *
 * @author rays1
 *
 */
public class L_0603_Largest_Divisible_Subset {

    /**
     * 如果 Si % Sj = 0 则一定有 Si >= Sj
     * 如果对子集进行排序，则任意的数字可以被其左侧的所有数字整除,换而言之任意的数字是其左侧的所有数字的公倍数。
     * 进一步的其左侧相邻的数字是左侧其他数字的倍数，因此只要这个数字正好是其左侧相邻的数字的倍数即可。
     * 
     * 算法原理
     *      对于数组 nums 维护一个数组 dp，dp[i] 表示最终元素为 nums[i] 的最大子集的 size
     *      每当遇见一个新的数字nums[i]，则向前检查其能够乘除的所有的数字 nums[j]，保留 dp[j] 最大的一个
     *      
     *      为了构建结果，还需要一个数组 prev 保存子集关系
     *
     */
    static class Solution {
    
        public List<Integer> largestDivisibleSubset(int[] nums) {
            
            Arrays.sort(nums);
            
            int maxIndex = 0;
            int[] dp   = new int[nums.length];
            int[] prev = new int[nums.length];
            
            Arrays.fill(prev, -1);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int idx = -1;
                for (int j = i-1; j >= 0; j --) {
                    if (num % nums[j] != 0) continue;
                    if (idx == -1 || dp[idx] < dp[j]) idx = j;
                }
                if (idx != -1) {
                    dp[i]   = dp[idx] + 1;
                    prev[i] = idx;
                    if (dp[maxIndex] < dp[i]) maxIndex = i;
                }
            }
            
            List<Integer> rs = new ArrayList<>();
            
            for (int i = maxIndex;  i != -1; i = prev[i]) {
                rs.add(0, nums[i]);
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {2,3,4,5,6,7,8,12,24};
        
        Out.p(new Solution().largestDivisibleSubset(nums));
        
    }

}
