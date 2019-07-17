package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个没有重复数字的集合，返回所有可能的子集合。
 *
 * 用例：
 *      **Example 1:**
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

    /**
     * 所有的数字是唯一的，那么在子集中一个数字要么出现，要么不出现。
     * 因此一共的可能有 2^n 种
     * 
     * 如果用 1 表示出现，0 表示不出现，那么每个子集合将对应一个二进制的数字。
     * 因此只要找到所有数字，然后构建对应的集合即可。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> rs = new LinkedList<List<Integer>>();
            for (int i = 0; i < Math.pow(2, n); i++) {
                List<Integer> l = new ArrayList<Integer>();
                int j = 0, mark = i;
                while (mark != 0) {
                    if ((mark & 1) == 1) {
                        l.add(nums[j]);
                    }
                    mark >>= 1;
                    j++;
                }
                rs.add(l);
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1, 2, 3};
        
        Out.p(new Solution().subsets(nums));
        
    }

}
