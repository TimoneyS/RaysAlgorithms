package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个整型数组，寻找和是0的子数组。返回子数组开始和结束索引。
 *
 * 如 [ -3, 1, 2, -3, 4 ] 返回 [ 0, 2] 或 [ 1, 3]
 *
 * @author rays1
 *
 */
public class L_0138_Subarray_Sum {
    
    /*
     * 如果数组中从 i 到 j 部分的和为 0
     * 那么必然数组之和 s[0..i-1] = s[0..j+1]
     * 因此只要一直加，同时保存每次累加的结果
     * 直到找到两个和相等的部分即可
     */
    static class Solution {
        public List<Integer> subarraySum(int[] nums) {
            
            ArrayList<Integer> rs = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum)) {
                    rs.add(map.get(sum)+1);
                    rs.add(i);
                    break;
                }
                map.put(sum, i);
            }
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {-3,1,2,-3,4};
        
        Out.p(new Solution().subarraySum(nums));
    }

}
