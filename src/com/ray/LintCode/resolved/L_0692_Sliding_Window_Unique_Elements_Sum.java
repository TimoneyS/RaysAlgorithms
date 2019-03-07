package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;

/**
 * 给一个数组和一个滑动窗口的大小, 求每一个窗口内只出现一次的元素的个数和
 *
 * @author rays1
 *
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
        
        int[] nums = {1,2,1,3,3};
        int k = 6;
        
        Out.p(new Solution().slidingWindowUniqueElementsSum(nums, k));
        
    }

}
