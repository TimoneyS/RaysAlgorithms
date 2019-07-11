package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array `num` and a number `target`. Find all unique combinations in `num` where the numbers sum to `target`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: num = [7,1,2,5,1,6,10], target = 8
 *      Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: num = [1,1,1], target = 2
 *      Output: [[1,1]]
 *      Explanation: The solution set must not contain duplicate combinations.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/combination-sum-ii/description
 * @date   2019-07-11 18:31:16
 */
public class L_0153_Combination_Sum_II {

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] nums, int target) {
            List<List<Integer>> results = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return results;
            }

            Arrays.sort(nums);
            List<Integer> base = new ArrayList<Integer>();
            cs(nums, 0, base, target, results);

            return results;
        }

        private void cs(int[] nums, int start, List<Integer> base, int target, List<List<Integer>> results) {
            
            if (target == 0) {
                results.add(new ArrayList<Integer>(base));
                return;
            }

            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[i - 1]) { // 跳过重复的物品
                    continue;
                }
                if (target < nums[i]) {
                    break;
                }
                base.add(nums[i]);
                cs(nums, i + 1, base, target - nums[i], results);
                base.remove(base.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        
        int[] nums = {10,1,6,7,2,1,5};
        int target = 8;
        
        List<List<Integer>>  rs = new Solution().combinationSum2(nums, target);
        
        Out.p(rs);
    }

}
