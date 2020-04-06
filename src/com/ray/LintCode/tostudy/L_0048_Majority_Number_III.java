package com.ray.LintCode.tostudy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组和一个数字 k，数组中有一个数字出现的次数超过了数字大小的 1 / k。找出这个数字。
 * 用例：
 *      用例 1:
 *      输入: [3,1,2,3,2,3,3,4,4,4] and k=3, 
 *      输出: 3.
 *      
 *      用例 2:
 *      输入: [1,1,2] and k=3, 
 *      输出: 1.
 *
 * 挑战：
 *      时间复杂度 O(n)
 *      空间复杂度 O(k)
 *      
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/majority-number-iii/description
 * @date   2019-07-11 18:00:38
 */
public class L_0048_Majority_Number_III {

    /**
     * 一次取 k 个数字，若这 k 个数字彼此不同，则全部丢弃。
     * 若有重复的数字，则将重复的次数变为统计次数，去重后补充到 k 个数字再比较
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int majorityNumber(List<Integer> nums, int k) {
            
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int num : nums) {
                
                map.putIfAbsent(num, 0);
                map.put(num, map.get(num) + 1);
                Out.p(map);
                if (map.size() >= k) {
                    for (Iterator<Entry<Integer, Integer>> i = map.entrySet().iterator(); i.hasNext();) {
                        Map.Entry<Integer, Integer> e = i.next();
                        if (e.getValue() == 1) {
                            i.remove();
                        } else {
                            e.setValue(e.getValue() - 1);
                        }
                    }
                }
                
                Out.p(map);
                Out.sep();
            }
            
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                e.setValue(0);
            }
            
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                }
            }
            
            int rs = 0, max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (max < e.getValue()) {
                    max = e.getValue();
                    rs = e.getKey();
                }
            }
            return rs;
        }
    }
    
    // 空间复杂度 O(n) 的解法
    static class Solution2 {
        
        public int majorityNumber(List<Integer> nums, int k) {
            
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int num : nums) {
                map.putIfAbsent(num, 0);
                map.put(num, map.get(num) + 1);
            }
            
            int rs = 0;
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (max < e.getValue()) {
                    max = e.getValue();
                    rs = e.getKey();
                }
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {
                7,1,7,7,61,61,61,10,10,10,61
        });
        int k = 3;
        
        Out.p(new Solution().majorityNumber(nums, k));
        Out.p(new Solution2().majorityNumber(nums, k));
    }

}
