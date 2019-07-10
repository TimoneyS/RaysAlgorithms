package com.ray.LintCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a set of distinct integers, return all possible subsets.
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
 *      Input: [1,2,3]
 *      Output:
 *      [
 *        [3],
 *        [1],
 *        [2],
 *        [1,2,3],
 *        [1,3],
 *        [2,3],
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
 * @url    https://www.lintcode.cn/problem/subsets/description
 * @date   2019-07-10 22:48:43
 */
public class L_0017_Subsets {

    static class Solution {
    
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
        
        Out.p(new Solution());
        
    }

}
