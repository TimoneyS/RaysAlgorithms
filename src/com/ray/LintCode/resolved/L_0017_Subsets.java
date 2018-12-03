package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * Given a set of distinct integers, return all possible subsets.
 * <p>
 * <b>Example</b><br>
 * If S = [1,2,3], a solution is:
 * <li> [
 * <li>  [],
 * <li>  [1],[2],[3],
 * <li>  [1,2],[2,3],[1,3],
 * <li>  [1,2,3]
 * <li> ]
 * @author rays1
 *
 */
public class L_0017_Subsets {

    static class Solution {
        
        /**
         * @param nums: A set of numbers
         * @return: A list of lists
         */
        public List<List<Integer>> subsets(int[] nums) {
            // write your code here
            int n = nums.length;
            Arrays.sort(nums);
            int[] marked = new int[nums.length];
            List<List<Integer>> rs = new LinkedList<List<Integer>>();
         
            for (int i = 0; i < Math.pow(2, n); i++) {
                
                List<Integer> l = new LinkedList<Integer>();
                for (int j = 0; j < n; j++) {
                    if (marked[j] == 1)
                        l.add(nums[j]);
                }
                rs.add(l);
                
                markedChange(marked);
            }
            
            return rs;
        }
        
        public void markedChange(int[] marked) {
            
            for (int i = 0; i < marked.length; i++) {
                
                if (marked[i] == 0) {
                    marked[i] = 1;
                    return;
                }
                marked[i] = 0;
                
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,2,3};
        
        for (List<Integer> l : new Solution().subsets(nums)) {
            Out.p(l);
        }
        
    }
    
}
