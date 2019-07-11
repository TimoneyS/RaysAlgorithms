package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a set of candidtate numbers `candidates` and a target number `target`. Find all unique combinations in `candidates` where the numbers sums to `target`.
 *      
 *      The **same** repeated number may be chosen from `candidates` unlimited number of times.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: candidates = [2, 3, 6, 7], target = 7
 *      Output: [[7], [2, 2, 3]]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: candidates = [1], target = 3
 *      Output: [[1, 1, 1]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/combination-sum/description
 * @date   2019-07-11 18:31:00
 */
public class L_0135_Combination_Sum {

    static class Solution {
        List<List<Integer>> rs;
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            
            Set<Integer> set = new HashSet<>();
            for (Integer integer : candidates) {
                set.add(integer);
            }
            candidates = null;
            
            Integer[] can = set.toArray(new Integer[0]);
            Arrays.sort(can);
            
            rs = new ArrayList<List<Integer>>();
            
            cs(new ArrayList<Integer>(), can, target, 0);
            
            return rs;
        }

        private void cs(List<Integer> base, Integer[] candidates, int target, int start) {
            
            if (target < 0 || start >= candidates.length) return;
            if (target == 0) {
                ArrayList<Integer> r = new ArrayList<>();
                r.addAll(base);
                rs.add(r);
                return;
            }
            
            // 包含当前
            base.add(candidates[start]);
            cs(base, candidates, target-candidates[start], start);
            base.remove(base.size()-1);
            
            // 不包含当前 直接下一个
            cs(base, candidates, target, start+1);
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] candidates = {6,7,3,2};
        int target = 7;
        
        Out.p(new Solution().combinationSum(candidates, target));
        
    }

}
