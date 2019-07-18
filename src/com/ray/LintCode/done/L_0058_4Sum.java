package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个包含 n 个整数的数组，寻找 a b c d 使得 a + b + c + d = target
 *      寻找所有可能的组合
 *
 * 用例：
 *      Example 1:
 *      Input:[2,7,11,15],3
 *      Output:[]
 *      
 *      Example 2:
 *      Input:[1,0,-1,0,-2,2],0
 *      Output:
 *      [[-1, 0, 0, 1]
 *      ,[-2, -1, 1, 2]
 *      ,[-2, 0, 0, 2]]
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/4sum/description
 * @date   2019-07-11 18:17:10
 */
public class L_0058_4Sum {

    /**
     * 和 3Sum 类似
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public List<List<Integer>> fourSum(int[] numbers, int target) {
            List<List<Integer>>   rs = new ArrayList<List<Integer>>();
            Arrays.sort(numbers);
            
            Set<Integer> fourMarked = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                if (fourMarked.contains(numbers[i])) continue;
                threeSum(numbers, i, target-numbers[i], numbers[i], fourMarked, rs);
                fourMarked.add(numbers[i]);
            }
            return rs;
        }
        
        public List<List<Integer>> threeSum(int[] numbers, int i, int target, int fourBase, Set<Integer> fourMarked,
                List<List<Integer>> rs) {
        
            Set<Integer> threeMarked = new HashSet<>();
            
            for (int j = i+1; j < numbers.length; j++) {
                if (threeMarked.contains(numbers[j])) continue;
                if (fourMarked.contains(numbers[j])) continue;
                
                twoSum(numbers, i, j, target-numbers[j], fourMarked, threeMarked, rs);
                
                threeMarked.add(numbers[j]);
            }
         
            return rs;
        }
    
        private List<List<Integer>> twoSum(int[] numbers, int i, int j, int target, 
                Set<Integer> fourMarked, Set<Integer> threeMarked, List<List<Integer>> rs) {
            
            Set<Integer> marked = new HashSet<>();
            Map<Integer, Integer> remain = new HashMap<>();
            
            for (int k = j+1; k < numbers.length; k++) {
                
                if (marked.contains(numbers[k])) continue;
                if (fourMarked.contains(numbers[k])) continue;
                if (threeMarked.contains(numbers[k])) continue;
                
                if (remain.containsKey(numbers[k])) {
                    int l = remain.get(numbers[k]);
                    
                    List<Integer> llist = new ArrayList<Integer>(4);
                    llist.add(numbers[i]);
                    llist.add(numbers[j]);
                    llist.add(numbers[l]);
                    llist.add(numbers[k]);
                    
                    marked.add(numbers[k]);
                    marked.add(numbers[l]);
                    
                    rs.add(llist);
                }
                
                remain.put(target-numbers[k], k);
                
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {1, 0, -1, 0, -2, 2};
        int target = 0;
        
        Out.p(new Solution().fourSum(numbers, target));
        
    }

}
