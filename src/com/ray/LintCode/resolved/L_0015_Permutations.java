package com.ray.LintCode.resolved;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a list of numbers, return all possible permutations.
 * 
 * <p>
 * Example
 * <p>
 * For nums = [1,2,3], the permutations are:
 * <li>
 * <li>[
 * <li> [1,2,3],
 * <li> [1,3,2],
 * <li> [2,1,3],
 * <li> [2,3,1],
 * <li> [3,1,2],
 * <li> [3,2,1]
 * <li>]
 * <p>
 * Challenge:Do it without recursion.
 * @author rays1
 *
 */
public class L_0015_Permutations {
    static class Solution {
        /*
         * @param nums: A list of integers.
         * @return: A list of permutations.
         */
        public List<List<Integer>> permute(int[] nums) {
            
            List<List<Integer>> rs = new LinkedList<List<Integer>>();
            
            permute(rs, new LinkedList<>(), nums);
            
            return rs;
        }
        
        public void permute(List<List<Integer>> rs, List<Integer> base, int [] nums) {
            
            if (nums.length == 0) {
                rs.add(base);
                return;
            }
            
            for (int num : nums ) {
                int[] newNum = new int[nums.length - 1];
                int index = 0;
                for (int j : nums) {
                    if (j != num)
                        newNum[index++] = j;
                }
                List<Integer> newBase = new LinkedList<Integer>(base);
                newBase.add(num);
                permute(rs, newBase, newNum);
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        
        new Solution().permute(nums);
        
    }
    
}
