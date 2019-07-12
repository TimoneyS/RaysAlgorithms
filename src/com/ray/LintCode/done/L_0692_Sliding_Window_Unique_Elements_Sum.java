package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array and a window size that is sliding along the array, find the sum of the count of unique elements in each window.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      [1, 2, 1, 3, 3]
 *      3
 *      Output: 5
 *      Explanation:
 *      First window [1, 2, 1], only 2 is unique, count is 1.
 *      Second window [2, 1, 3], all elements unique, count is 3.
 *      Third window [1, 3, 3], only 1 is unique, count is 1.
 *      sum of count = 1 + 3 + 1 = 5
 *      ```
 *      **Example1**
 *      ```
 *      Input:
 *      [1, 2, 1, 2, 1]
 *      3
 *      Output: 3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sliding-window-unique-elements-sum/description
 * @date   2019-07-11 18:35:33
 */
public class L_0692_Sliding_Window_Unique_Elements_Sum {


    /**
     * 用 map 保存数字计数，用 set 保存计数为 1 的元素
     * @author rays1
     *
     */
    static class Solution {
    
        public int slidingWindowUniqueElementsSum(int[] nums, int k) {
            
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            
            for (int i = 0; i < k && i < nums.length; i ++) {
                change(nums[i], map, set, 1);
            }
            int rs = set.size();
            
            for (int i = k; i < nums.length; i++) {
                change(nums[i-k], map, set, -1);
                change(nums[i], map, set, 1);
                rs += set.size();
            }
            
            return rs;
        }
        
        void change(int num, Map<Integer, Integer> map, Set<Integer> set, int diff) {
            int c = map.getOrDefault(num, 0) + diff;
            map.put(num, c);
            if (c == 0 || c > 1) {
                set.remove(num);
            } else if (c == 1) {
                set.add(num);
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
