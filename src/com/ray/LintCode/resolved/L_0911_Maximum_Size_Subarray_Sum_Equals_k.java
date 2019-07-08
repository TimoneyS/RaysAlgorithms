package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * Description :
 *   Given an array `nums` and a target value `k`, find the maximum length of a subarray that sums to k.
 *   If there isn't one, return 0 instead.
 *
 * Example :
 *   **Example1**
 *   ```
 *   Input:  nums = [1, -1, 5, -2, 3], k = 3
 *   Output: 4
 *   Explanation:
 *   because the subarray [1, -1, 5, -2] sums to 3 and is the longest.
 *   ```
 *   
 *   **Example2**
 *   ```
 *   Input: nums = [-2, -1, 2, 1], k = 1
 *   Output: 2
 *   Explanation:
 *   because the subarray [-1, 2] sums to 1 and is the longest.
 *   ```
 *
 * Challenge :
 *   Can you do it in O(n) time?
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-size-subarray-sum-equals-k/description
 * @date   2019-07-03 17:34:16
 */
public class L_0911_Maximum_Size_Subarray_Sum_Equals_k {

    /**
     * 数组阶段和相减就是子数组和
     * 利用Map找出和对应的另一个阶段和，计算最大距离
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int maxSubArrayLen(int[] nums, int k) {
            
            Map<Integer, List<Integer>> map = new HashMap<>();
            
            map.put(0, new ArrayList<>());
            map.get(0).add(-1);
            
            for (int i = 0; i < nums.length; i++) {
                nums[i] += i == 0 ? 0 : nums[i-1];
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
            
            int rs = 0;
            for (int r = nums.length-1; r >= 0; r--) {
                if (map.containsKey(nums[r]-k)) {
                    for (int l : map.get(nums[r]-k)) {
                        if (l < r) rs = Math.max(rs, r-l);
                    }
                }
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        Out.p(new Solution().maxSubArrayLen(nums, k));
    }

}
