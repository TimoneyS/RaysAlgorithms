package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T. Each number
 * in C may only be used once in the combination. 一个数字集合 C 和一个目标 T
 * ，寻找集合中所有和为T的数字的组合。数字只能使用一次。
 * 
 * 
 * @author rays1
 *
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
