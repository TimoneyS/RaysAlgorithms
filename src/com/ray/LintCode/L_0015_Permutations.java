package com.ray.LintCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

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
            // write your code here
            int N = nums.length;
            
            Integer[][] arr = new Integer[N*N-N][N];
            
            for (int k = 1; k < N; k++) {
                // k is the deviation
                for (int i = 0; i < N; i++) {
                    int deviation = k * i + k;
                    for (int j = 0; j < N; j++) {
                        arr[j + k * N - N][i] = nums[ (j + deviation)%N];
                    }
                }
            }
            
            List<List<Integer>> list = new LinkedList<>();
            
            if (nums.length == 0)
                list.add(new LinkedList<Integer>());
            else if (nums.length == 1)
                list.add(Arrays.asList(new Integer[]{nums[0]}));
            else    
                for (Integer[] temp : arr) {
                    list.add(Arrays.asList(temp));
                }
            
            Out.p(arr, "%s");
            
            return list;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {5,4,6,2};
        
        new Solution().permute(nums);
    }
    
}
