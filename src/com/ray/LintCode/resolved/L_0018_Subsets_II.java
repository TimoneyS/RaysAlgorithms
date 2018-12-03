package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 * <b>Example</b><br>
 * Input: [1,2,2], a solution is:
 * <li> [
 * <li>  [],
 * <li>  [1],[2]
 * <li>  [1,2],[2,2],
 * <li>  [1,2,2]
 * <li> ]
 * @author rays1
 *
 */
public class L_0018_Subsets_II {
    
    static class Solution {
        
        /**
         * @param nums: A set of numbers.
         * @return: A list of lists. All valid subsets.
         */
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // write your code here
            List<List<Integer>> rs = new LinkedList<List<Integer>>();
            
            int n = nums.length;
            
            Arrays.sort(nums);
            
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) n --;
            }
            
            int[] marked  = new int[n];
            int[] count   = new int[n];
            int[] newNums = new int[n];
            
            build(nums, newNums, count);
            
            int power = 1;
            for (int i = 0; i < count.length; i++) {
                power *= (count[i] + 1);
            }
            
            for (int i = 0; i < power; i++) {
                Out.p(marked);
                
                List<Integer> l = new LinkedList<Integer>();
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < marked[j]; k++) {
                        l.add(newNums[j]);
                    }
                }
                rs.add(l);
                markedChange(marked, count);
            }
            
            return rs;
        }
        
        public void build (int[] nums, int[] newNums, int[] count) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                newNums[cursor] = nums[i];
                count[cursor] ++;
                if (i < nums.length - 1 && nums[i+1] != nums[i])
                    cursor ++;
            }
        }
        
        public void markedChange(int[] marked, int[] count) {
            for (int i = 0; i < marked.length; i++) {
                if (marked[i] != count[i]) {
                    marked[i] += 1;
                    return;
                }
                marked[i] = 0;
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,2,2};
        
        for (List<Integer> l : new Solution().subsetsWithDup(nums)) {
            Out.p(l);
        }
    }
    
}
