package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 * Given a set of candidate numbers (C) and a target number (T),
 *  find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * @author rays1
 *
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
