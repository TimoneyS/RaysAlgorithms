package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组 S，大小为 n，寻找元素 a b c 使得  a + b + c = 0。
 *      寻找所有可能的不重复的组合。
 *
 * 用例：
 *      用例 1:
 *      输入:[2,7,11,15]
 *      输出:[]
 *      
 *      用例 2:
 *      输入:[-1,0,1,2,-1,-4]
 *      输出:	
 *              [
 *                  [-1, 0, 1],
 *                  [-1, -1, 2]
 *              ]
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/3sum/description
 * @date   2019-07-11 18:17:02
 */
public class L_0057_3Sum {

    static class Solution {
        
        public List<List<Integer>> threeSum(int[] numbers) {
            
            List<List<Integer>> rs = new ArrayList<List<Integer>>();
            Map<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
            
            for (int i = 0; i < numbers.length; i++) {
                if (hash.containsKey(numbers[i])) {
                    continue;
                }
                twoSum(numbers, i+1, 0-numbers[i], hash, rs);
                hash.put(numbers[i], true);
            }
         
            return rs;
        }
        
        private void twoSum(int[] numbers, int start, int target, Map<Integer, Boolean> basemarked, List<List<Integer>> rs) {
            
            Map<Integer, Boolean> marked = new HashMap<Integer, Boolean>();
            Map<Integer, Integer> remain = new HashMap<>();
            
            for (int i = start; i < numbers.length; i++) {
                int num = numbers[i];
                
                if (marked.containsKey(num) || basemarked.containsKey(num)) {
                    continue;
                }
                if (remain.containsKey(num)) {
                    int j = remain.get(num);
                    List<Integer> l = new ArrayList<Integer>(3);
                    l.add(numbers[start-1]);
                    l.add(numbers[i]);
                    l.add(numbers[j]);
                    Collections.sort(l);
                    marked.put(numbers[i], true);
                    marked.put(numbers[j], true);
                    
                    rs.add(l);
                }
                
                remain.put(target-num, i);
                
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};
        
        Out.p(new Solution().threeSum(numbers));
        
    }

}
