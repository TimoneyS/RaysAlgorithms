package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个集合的整数，可能包含重复数字，返回所有可能的子集合。
 *
 * 用例：
 *      **Example 1:**
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

    /**
     * 同 Subsets 类似，这里一个数字不能直接用出现与否表示，而是应该用出现的次数。
     * 因此，题目可以转换为不同位置有着不同的进位规则的特殊数字表示。
     * 然后找出所有的数字，在根据数字构建子集合即可。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> rs = new LinkedList<List<Integer>>();
            int n = nums.length;
            Arrays.sort(nums);
            
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) n --;
            }
            
            int[] marked  = new int[n];
            int[] count   = new int[n];
            
            build(nums, count);
            
            int power = 1;
            for (int i = 0; i < count.length; i++) {
                power *= (count[i] + 1);
            }
            
            for (int i = 0; i < power; i++) {
                List<Integer> l = new LinkedList<Integer>();
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < marked[j]; k++) {
                        l.add(nums[j]);
                    }
                }
                rs.add(l);
                markedChange(marked, count);
            }
            
            return rs;
        }
        
        /**
         * 统计 每个数字出现的次数
         */
        public void build (int[] nums, int[] count) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[cursor] = nums[i];
                count[cursor] ++;
                if (i < nums.length - 1 && nums[i+1] != nums[i]) {
                    cursor ++;
                }
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
        
        int[] nums = {1,2,2,3};
        
        Out.p(new Solution().subsetsWithDup(nums));
        
    }

}
