package com.ray.LintCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a collection of integers that might contain duplicates, *nums*, return all possible subsets (the power set).
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: [0]
 *      Output:
 *      [
 *        [],
 *        [0]
 *      ]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: [1,2,2]
 *      Output:
 *      [
 *        [2],
 *        [1],
 *        [1,2,2],
 *        [2,2],
 *        [1,2],
 *        []
 *      ]
 *      ```
 *
 * 挑战：
 *      Can you do it in both recursively and iteratively?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/subsets-ii/description
 * @date   2019-07-10 22:49:09
 */
public class L_0018_Subsets_II {

    static class Solution {
    
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
        
        Out.p(new Solution());
        
    }

}
