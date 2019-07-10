package com.ray.LintCode.done;

import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一组数字，返回所有可能的排列组合。
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: [1,2,3]
 *      Output:
 *      [
 *        [1,2,3],
 *        [1,3,2],
 *        [2,1,3],
 *        [2,3,1],
 *        [3,1,2],
 *        [3,2,1]
 *      ]
 *      ```
 *
 * 挑战：
 *      Do it without recursion.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/permutations/description
 * @date   2019-07-10 22:39:57
 */
public class L_0015_Permutations {

    static class Solution {
    
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
                    if (j != num) {
                        newNum[index++] = j;
                    }
                }
                List<Integer> newBase = new LinkedList<Integer>(base);
                newBase.add(num);
                permute(rs, newBase, newNum);
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
